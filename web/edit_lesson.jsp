<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer| Edit lesson</title>
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
                    <a href="<s:url action="home_lecturer"><s:param name="userId">${param["userId"]}</s:param></s:url>">Home</a>
                </li>
                <li class="active">
                    <a href="<s:url action="list_lessons_for_lecturer"><s:param name="userId">${param["userId"]}</s:param></s:url>">My
                        lessons</a>
                </li>
                <li>
                    <a href="#">Settings</a>
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
                    <h2>Lesson info</h2>
                    <s:hidden name="userId"/>
                    <s:form action="create_or_update_lesson" method="POST">
                        <s:hidden name="lesson.id" class="form-control"
                                  placeholder="Enter login"/>
                        <s:select
                                name="courseName"
                                label="Course name"
                                list="courseList"
                                listKey="name"
                                listValue="name"
                                required="true"
                                class="form-control"/>
                        <s:hidden name="lesson.data.id" class="form-control"
                                  placeholder="Enter login"/>
                        <s:textarea name="lesson.data.data" label="Data" class="form-control"
                                    placeholder="Enter data"/>
                        <s:hidden name="userId" value="%{userId}" class="form-control"
                                  placeholder="Enter login"/>
                        <s:submit value="Save" class="btn"/>
                    </s:form>
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
</body>
</html>
