<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Learning site</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">Courses</a>
                </li>
                <li class="active">
                    <a href="/register.jsp" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign
                        Up</a>
                </li>
                <li>
                    <a href="/login.jsp" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Register</h1>
                <s:actionerror/>

                <s:form action="register" method="post" validate="true">
                    <s:textfield name="user.login" label="Login" id="login"  class="form-control"
                                 placeholder="Enter login"/>
                    <s:password name="user.password" label="Password"  class="form-control"
                                placeholder="Enter password"/>
                    <s:password name="repeatPassword" label="Repeat password"  class="form-control"
                                placeholder="Repeat password"/>
                    <s:select class="ListU form-control" list="{'student','lecturer'}" name="user.role" label="Role"
                              placeholder="student"/>
                    <s:textfield name="user.name" label="Name"  class="form-control"
                                 placeholder="Enter name"/>
                    <s:textfield name="user.surname" label="Surname"  class="form-control"
                                 placeholder="Enter surname"/>
                    <s:textfield name="user.phone" label="Phone"  class="form-control"
                                 placeholder="Enter phone"/>
                    <s:textfield name="user.email" label="Email"  class="form-control"
                                 placeholder="Enter email"/>
                    <s:hidden name="user.banStatus" value="0"  class="form-control"
                              placeholder=""/>
                    <s:submit value="Register" class="active btn btn-primary"/>
                </s:form>
            </div>

        </div>
    </div>
</div>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="row" style="background-color: #272b30">
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