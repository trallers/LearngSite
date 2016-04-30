<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Student| All certificates</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css"  rel="stylesheet"
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
                    <a href="home_student.jsp">Home</a>
                </li>
                <li>
                    <a href="all_courses_student.jsp">Courses</a>
                </li>
                <li>
                    <a href="all_lessons_student.jsp">Lessons</a>
                </li>
                <li class="active">
                    <a href="all_certificates_student.jsp">Certificates</a>
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
            <div class="col-md-12 text-center">
                <h1>All Certificates</h1>
                <s:if test="certificateList.size() > 0">
                    <div class="content">
                        <table class="certificates_table table table-hover">
                            <thead>
                                <th>Data</th>
                                <th>Date</th>
                            </thead>
                            <s:iterator value="certificateList" status="userStatus">
                                <tr>
                                    <td><s:property value="data" /></td>
                                    <td><s:property value="date" /></td>
                                </tr>
                            </s:iterator>
                        </table>
                    </div>
                </s:if>
            </div>
        </div>
    </div>
</div>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="row" style="background-color: #272b30">
            <hr>
            <div class="col-lg-12" >
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

