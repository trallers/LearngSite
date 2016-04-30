<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin| All courses</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="navbar navbar-default navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>Learning portal</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="home_admin.jsp">Home</a>
                </li>
                <li>
                    <a href="<s:url action="list_users_for_admin" ></s:url>">Users</a>
                </li>
                <li class="active">
                    <a href="<s:url action="list_courses_for_admin"></s:url>">Courses</a>
                </li>
                <li>
                    <a href="<s:url action="list_lessons_for_admin"></s:url>">Lessons</a>
                </li>
                <li>
                    <a href="<s:url action="list_certificates_for_admin"></s:url>">Certificates</a>
                </li>
                <li>
                    <a href="<s:url action="logout"/>" data-toggle="modal">Logout <span
                            class="glyphicon glyphicon-log-out"></span></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>All courses</h2>
                <s:if test="courseList.size() > 0">
                    <div class="content">
                        <table class="table table-hover" class="coursesTable">
                            <thead>
                            <th>Name</th>
                            <th>Technology</th>
                            <th>Id lecturer</th>
                            <th>Price</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            </thead>
                            <s:iterator value="courseList" status="userStatus">
                                <tr>
                                    <s:hidden value="id"/>
                                    <td><s:property value="name"/></td>
                                    <td><s:property value="technology"/></td>
                                    <td><s:property value="idLecturer"/></td>
                                    <td><s:property value="price"/></td>
                                    <td>
                                        <s:url id="editURL" action="get_course_for_admin">
                                            <s:param name="courseId" value="%{id}"/>
                                        </s:url>
                                        <s:a href="%{editURL}">Edit</s:a>
                                    </td>
                                    <td>
                                        <s:url id="deleteURL" action="delete_course">
                                            <s:param name="courseId" value="%{id}"/>
                                        </s:url>
                                        <s:a href="%{deleteURL}">Delete</s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </div>
                </s:if>
                <s:url id="addURL" action="get_course_for_admin">
                    <s:param name="courseId" value="%{null}"/>
                </s:url>
                <s:a href="%{addURL}">Create</s:a>
                <s:url id="back" value="home_admin.jsp">
                    <s:param name="userID" value="%{userID}"/>
                </s:url>
            </div>
        </div>
    </div>
</div>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <hr>
            <div class="col-lg-12">
                <div class="col-md-8">
                    <a href="#">Terms of Service</a>|
                    <a href="#">Privacy</a>
                </div>
                <div class="col-md-4">
                    <p class="muted pull-right">© 2016 Trellers. All rights reserved</p>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>