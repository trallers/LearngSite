<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Learning site</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css"  rel="stylesheet"
          type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <s:head />
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
                    <a href="index.jsp">Home</a>
                </li>
                <li>
                    <a href="#">Courses</a>
                </li>
                <li>
                    <a href="/register.jsp" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Sign
                        Up</a>
                </li>
                <li class="active">
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
                <h1>Welcome!</h1>
                <s:actionmessage/>
                <s:actionerror/>
                <s:form action="login" method="post" validate="true">
                    <s:div class="form-group">
                        <s:textfield label="Login" name="login" class="form-control"
                                     placeholder="Enter login"/>
                    </s:div>
                    <s:div class="form-group">
                        <s:password label="Password" name="password" class="form-control"
                                    placeholder="Enter password"/>
                    </s:div>
                    <s:submit value="Login" class="active btn btn-primary allElements"/>
                </s:form>
            </div>

        </div>
    </div>
</div>
<footer class="navbar-fixed-bottom">
    <div class="container">
        <div class="row"  style="background-color: #272b30">
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