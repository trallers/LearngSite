<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin| Edit user</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
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
                <li>
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
                    <h2>User info</h2>
                    <s:hidden name="userId"/>
                    <s:form action="ban_user" class="Center" validate="true">
                        <s:textfield name="user.id" readonly="true" class="form-control"
                                     placeholder="Enter id" cssStyle="display: none"/>
                        <s:textfield name="user.role" readonly="true" label="Role" class="form-control"
                                     placeholder="Enter role"/>
                        <s:textfield name="user.login" label="Login" readonly="true" class="form-control"
                                     placeholder="Enter login"/>
                        <s:hidden name="user.password" label="Password" readonly="true" class="form-control"
                                  placeholder="Enter password"/>
                        <s:textfield name="user.name" label="Name" readonly="true" class="form-control"
                                     placeholder="Enter name"/>
                        <s:textfield name="user.surname" label="Surname" readonly="true" class="form-control"
                                     placeholder="Enter surname"/>
                        <s:textfield name="user.phone" label="Phone" readonly="true" class="form-control"
                                     placeholder="Enter phone"/>
                        <s:textfield name="user.email" label="Email" readonly="true" class="form-control"
                                     placeholder="Enter email"/>
                        <s:checkbox name="user.banStatus" label="Is banned"/>
                        <s:submit value="Save changes" class="btn"/>
                    </s:form>
                </div>
            </div>
        </div>
    </div>
</content>
<footer class="navbar navbar-fixed-bottom">
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

