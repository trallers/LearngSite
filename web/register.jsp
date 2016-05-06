<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <title>Learning site</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="js/jquery-1.12.3.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    <s:head/>
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
<content class="container-fluid body-content">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Register on our site</h3>
                            <p>Enter your data to sign up:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-user-plus"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <s:form role="form" action="registration" method="post" validate="true"
                                class="form-group login-form">
                            <s:actionerror/>
                            <s:label value="Login"/>
                            <s:label id="status" name="status"/>
                            <s:textfield name="login" id="login"
                                         class="form-control"
                                         placeholder="Enter your login"/>
                            <s:label value="Password"/>
                            <s:password name="user.password" id="password" class="form-control"
                                        placeholder="Enter password"/>
                            <s:label value="Repeat password"/>
                            <s:label id="passwordStatus" name="passwordStatus"/>
                            <s:password name="repeatPassword" id="repeatPassword"
                                        class="form-control"
                                        placeholder="Repeat password"/>
                            <s:label value="Role"/>
                            <s:select class="ListU form-control" list="{'student','lecturer'}" name="user.role"
                                      placeholder="student"/>
                            <s:label value="Name"/>
                            <s:textfield name="user.name" class="form-control"
                                         placeholder="Enter your name"/>
                            <s:label value="Surname"/>
                            <s:textfield name="user.surname" class="form-control"
                                         placeholder="Enter surname"/>
                            <s:label value="Phone"/>
                            <s:textfield name="user.phone" class="form-control"
                                         placeholder="Enter phone"/>
                            <s:label value="Email"/>
                            <s:textfield name="user.email" class="form-control"
                                         placeholder="Enter email"/>
                            <s:hidden name="user.banStatus" value="0" class="form-control"
                                      placeholder=""/>
                            <s:submit value="Sign up" class="btn loginButton"/>

                        </s:form>
                        <script type="text/javascript" src="js/script.js"></script>
                    </div>
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


