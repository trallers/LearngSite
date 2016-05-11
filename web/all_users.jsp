<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin| Users</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                    <a href="<s:url action="home_admin"><s:param name="userId">${param["userId"]}</s:param></s:url>">Home</a>
                </li>
                <li class="active">
                    <a href="<s:url action="list_users_for_admin"><s:param name="userId">${param["userId"]}</s:param></s:url>">Users</a>
                </li>
                <li>
                    <a href="<s:url action="list_courses_for_admin"><s:param name="userId">${param["userId"]}</s:param></s:url>">Courses</a>
                </li>
                <li>
                    <a href="<s:url action="list_lessons_for_admin"><s:param name="userId">${param["userId"]}</s:param></s:url>">Lessons</a>
                </li>
                <LI>
                    <a href="<s:url action="list_certificates_for_admin"><s:param name="userId">${param["userId"]}</s:param></s:url>">Certificates</a>
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
                    <h2>All users</h2>
                    <s:if test="userList.size() > 0">
                        <div class="content">
                            <table class="table table-hover" class="courses_table">
                                <thead>
                                <th>Login</th>
                                <th>Role</th>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Ban status</th>
                                <th>Edit</th>
                                <th>Delete</th>
                                <th>Recommendation</th>
                                </thead>
                                <s:iterator value="userList" status="userStatus">
                                    <tr>
                                        <s:hidden name="id" value="id"/>
                                        <td><s:property value="login"/></td>
                                        <td><s:property value="role"/></td>
                                        <td><s:property value="name"/></td>
                                        <td><s:property value="surname"/></td>
                                        <td><s:property value="phone"/></td>
                                        <td><s:property value="email"/></td>
                                        <td><s:property value="banStatus"/></td>
                                        <td>
                                            <s:if test="!currentUser(id)">
                                                <s:url id="editURL" action="get_user_for_admin">
                                                    <s:param name="userId" value="%{userId}"/>
                                                    <s:param name="id" value="%{id}"/>
                                                </s:url>
                                                <s:a class="btn tableBtn" href="%{editURL}">Edit</s:a>
                                            </s:if>

                                        </td>
                                        <td>
                                            <s:if test="!role.equals(\"admin\")">
                                                <s:url id="deleteURL" action="delete_user">
                                                    <s:param name="userId" value="%{userId}"/>
                                                    <s:param name="id" value="id"/>
                                                </s:url>
                                                <s:a id="delBtn%{id}" href="%{deleteURL}"/>
                                                <s:a atr="%{id}" class="btn tableBtn delete" href="" onclick="deleteItem(this)">Delete</s:a>
                                            </s:if>
                                        </td>
                                        <td>
                                            <s:if test="!role.equals(\"admin\")">
                                                <s:url id="recommendationPdf" action="generate_recommendation_pdf">
                                                    <s:param name="userId" value="%{userId}"/>
                                                    <s:param name="id" value="id"/>
                                                </s:url>
                                                <s:url id="recommendationXLSX" action="generate_recommendation_xlsx">
                                                    <s:param name="userId" value="%{userId}"/>
                                                    <s:param name="id" value="id"/>
                                                </s:url>
                                                <s:url id="recommendationCSV" action="generate_recommendation_csv">
                                                    <s:param name="userId" value="%{userId}"/>
                                                    <s:param name="id" value="id"/>
                                                </s:url>
                                                <s:a class="btn tableBtn doc" href="%{recommendationPdf}">PDF</s:a>
                                                <s:a class="btn tableBtn doc" href="%{recommendationCSV}">CSV</s:a>
                                                <br/><s:a class="btn tableBtn doc" href="%{recommendationXLSX}">XLSX</s:a>

                                            </s:if>
                                        </td>
                                    </tr>
                                </s:iterator>

                            </table>
                            <s:url id="create_admin" action="create_admin">
                                <s:param name="userId" value="%{userId}"/>
                                <s:param name="id" value="%{null}"/>
                            </s:url>
                            <s:a class="btn" href="%{create_admin}">Create admin</s:a>
                            <s:url id="pdfStudents" action="generate_studentList_pdf"/>
                            <s:a class="btn doc" href="%{pdfStudents}">Students PDF</s:a>
                            <s:url id="xlsxStudents" action="generate_studentList_xlsx"/>
                            <s:a class="btn doc" href="%{xlsxStudents}">Students XLSX</s:a>
                            <s:url id="csvStudents" action="generate_studentList_csv"/>
                            <s:a class="btn doc" href="%{csvStudents}">Students CSV</s:a>
                            <s:url id="pdfLecturers" action="generate_lecturerList_pdf"/>
                            <s:a class="btn doc" href="%{pdfLecturers}">Lecturers PDF</s:a>
                            <s:url id="xlsxLecturers" action="generate_lecturerList_xlsx"/>
                            <s:a class="btn doc" href="%{xlsxLecturers}">Lecturers XLSX</s:a>
                            <s:url id="csvLecturers" action="generate_lecturerList_csv"/>
                            <s:a class="btn doc" href="%{csvLecturers}">Lecturers CSV</s:a>
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
<script type="text/javascript" src="/js/bootbox.min.js"></script>
<script type="text/javascript" src="/js/modalBox.js"></script>
</body>
</html>

