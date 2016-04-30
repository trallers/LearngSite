<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.12.3.js"></script>
    <title>Learning site</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
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


                <s:form action="registration" method="post" validate="true">
                    <s:actionerror/>
                    <s:textfield name="login" id="login"
                                 class="form-control" label="Login"
                                 placeholder="Enter login"/>
                    <s:label id="status" name="status"></s:label>
                    <s:password name="user.password" label="Password" class="form-control"
                                placeholder="Enter password"/>
                    <s:password name="repeatPassword" label="Repeat password" class="form-control"
                                placeholder="Repeat password"/>
                    <s:select class="ListU form-control" list="{'student','lecturer'}" name="user.role" label="Role"
                              placeholder="student"/>
                    <s:textfield name="user.name" label="Name" class="form-control"
                                 placeholder="Enter name"/>
                    <s:textfield name="user.surname" label="Surname" class="form-control"
                                 placeholder="Enter surname"/>
                    <s:textfield name="user.phone" label="Phone" class="form-control"
                                 placeholder="Enter phone"/>
                    <s:textfield name="user.email" label="Email" class="form-control"
                                 placeholder="Enter email"/>
                    <s:hidden name="user.banStatus" value="0" class="form-control"
                              placeholder=""/>
                    <s:submit value="Register" class="active btn btn-primary"/>

                </s:form>

                <script>
                    $("#login").keyup(function () {
                        $("#status").html('<img src="images/loader.gif" width="16" height="16" align="absmiddle">&nbsp;Checking availability...');
                        $.ajax({
                            type: "GET",
                            url: 'check_login_exist.action?userName=' + $("#login").val(),
                            dataType: 'text',
                            success: function (data) {
                                if ('exist' === data) {
                                    $("#status").html('<img src="images/cross.png" width="16" height="16" align="absmiddle">&nbsp;User with this login already exist');
                                }
                            },
                            error: function () {
                                alert("Abnormal！");
                            }
                        });
                        if ($("#login").val().length > 3)
                            $("#status").html('<img src="images/tick.png" width="16" height="16" align="absmiddle">&nbsp;You can use this login');
                        else
                            $("#status").html('<img src="images/cross.png" width="16" height="16" align="absmiddle">&nbsp;Login should be longer than 3 characters');
                    });
                </script>
            </div>

        </div>
    </div>
</div>
<footer class="navbar-bottom">
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


