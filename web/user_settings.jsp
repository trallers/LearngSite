<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>Student| Student settings</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

  <link href="font-awesome/css/font-awesome.min.css"  rel="stylesheet"
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
          <a href="<s:url action="home_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">Home</a>
        </li>
        <li>
          <a href="<s:url action="list_courses_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">My courses</a>
        </li>
        <li>
          <a href="<s:url action="list_lessons_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">Passed lessons</a>
        </li>
        <li>
          <a href="<s:url action="list_certificates_for_students"><s:param name="userId">${param["userId"]}</s:param></s:url>">My certificates</a>
        </li>
        <li  class="active">
          <a href="<s:url action="get_user_for_student"><s:param name="userId">${param["userId"]}</s:param></s:url>">My settings</a>
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
        <s:form action="update_user" class="Center">
          <h2>Settings</h2>
          <s:hidden name="user.id" class="form-control"/>
          <s:hidden name="user.role" class="form-control"/>
          <s:hidden name="user.banStatus"  class="form-control"/>
          <s:textfield name="user.login" label="Login" readonly="true"  class="form-control"/>
          <s:password name="user.password" label="Password"  class="form-control"/>
          <s:textfield name="user.name" label="Name"  class="form-control"/>
          <s:textfield name="user.surname" label="Surname"  class="form-control"/>
          <s:textfield name="user.phone" label="Phone" class="form-control"/>
          <s:textfield name="user.email" label="Email" class="form-control"/>
          <s:hidden name="userId" value="%{userId}" class="form-control"/>
          <s:submit value="Save changes" class="active btn btn-primary allElements"/>
        </s:form>

      </div>
    </div>
  </div>
</div>
<footer class="navbar-bottom">
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
