<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin| Edit certificate</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css"  rel="stylesheet"
          type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <s:head/>
    <sx:head/>
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
                    <a href="<s:url action="list_users_for_admin" />">Users</a>
                </li>
                <li>
                    <a href="<s:url action="list_courses_for_admin"/>">Courses</a>
                </li>
                <li>
                    <a href="<s:url action="list_lessons_for_admin"/>">Lessons</a>
                </li>
                <li class="active">
                    <a href="<s:url action="list_certificates_for_admin"/>">Certificates</a>
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
                <h2>Certificate info</h2>
                <s:form action="create_or_update_certificate">
                    <s:actionerror/>
                    <s:hidden name="certificate.id" readonly="true" label="ID" class="form-control"/>
                    <s:select
                            name="studentSurname"
                            label="Student"
                            list="studentList"
                            listKey="surname"
                            listValue="surname"
                            required="true"
                            class="form-control"/>
                    <s:select
                            name="courseName"
                            label="Course"
                            list="courseList"
                            listKey="name"
                            listValue="name"
                            required="true"
                            class="form-control"/>
                    <s:textarea name="certificate.data" label="Data" class="form-control"
                                placeholder="Enter data"/>
                    <sx:datetimepicker name="certificate.date" label="Date" displayFormat="yyyy-MM-dd"/>
                    <s:submit value="Save" class="active btn btn-primary"/>
                </s:form>
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
                    <p class="muted pull-right">© 2016 Trallers. All rights reserved</p>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>

