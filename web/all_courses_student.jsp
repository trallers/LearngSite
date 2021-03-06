<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student| All courses</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
                    <a href="<s:url action="home_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">Home</a>
                </li>
                <li class="active">
                    <a href="<s:url action="list_courses_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">My
                        courses</a>
                </li>
                <li>
                    <a href="<s:url action="list_lessons_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">Passed
                        lessons</a>
                </li>
                <li>
                    <a href="<s:url action="list_certificates_for_students"><s:param name="userId">${param["userId"]}</s:param></s:url>">My
                        certificates</a>
                </li>
                <li>
                    <a href="<s:url action="get_user_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">My
                        settings</a>
                </li>
                <li>
                    <a href="<s:url action="logout"/>" data-toggle="modal">Logout <span
                            class="glyphicon glyphicon-log-out"></span></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<content class="container-fluid body-content">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>All courses</h1>
                    <s:hidden name="userId" value="%{userId}"/>
                    <s:if test="courseList.size() > 0">
                        <div class="content">
                            <table class="courses_table table table-hover">
                                <thead>
                                <th>Name</th>
                                <th>Technology</th>
                                <th>Price</th>
                                </thead>
                                <s:iterator value="courseList" status="userStatus">
                                    <tr>
                                        <s:hidden name="id" value="id"/>
                                        <td><s:property value="name"/></td>
                                        <td><s:property value="technology"/></td>
                                        <td><s:property value="price"/></td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </div>
                    </s:if>
                </div>
            </div>
        </div>
    </div>
</content>
<footer class="navbar navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-md-8">
                    <a href="#">Terms of Service</a>|
                    <a href="#">Privacy</a>
                </div>
                <div class="col-md-4">
                    <p class="muted pull-right">© 2016 Trallers. All rights reserved</p>
                </div>
            </div>
        </div>
    </div>
</footer>

<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>