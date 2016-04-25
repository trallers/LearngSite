<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin| Edit courese</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css"  rel="stylesheet"
          type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <s:head></s:head>
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
                <li>
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
                <h2>Course info</h2>
                <s:form action="create_or_update_course"  validate="true" method="POST">
                    <s:actionerror></s:actionerror>
                    <s:hidden name="course.id" readonly="true" label="Id" class="form-control"
                              placeholder="Enter id"/>
                    <s:textfield name="course.name" label="Name" class="form-control"
                                 placeholder="Enter name"/>
                    <s:textfield name="course.technology" label="Technology" class="form-control"
                                 placeholder="Enter technology"/>
                    <s:select
                            headerKey="0"
                            headerValue="--Select lecturer-"
                            name="lecturerID"
                            label="Lecturer"
                            list="lecturerList"
                            listKey="id"
                            listValue="surname"
                            required="true" class="form-control"
                            placeholder="Enter technology"/>
                    <s:textfield name="course.price" label="Price" class="form-control"
                                 placeholder="Enter price"/>
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
                    <p class="muted pull-right">© 2016 Trellers. All rights reserved</p>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>


