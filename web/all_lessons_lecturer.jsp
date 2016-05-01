<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Learning site| All lessons</title>
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
        <li class="active">
          <a href="<s:url action="list_lessons_for_lecturer"><s:param name="userId">${param["userId"]}</s:param></s:url>">My lessons</a>
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
        <h1>All lessons</h1>
        <s:if test="lessonList.size() > 0">
          <div class="content">
            <table class="lessons_table table table-hover">
              <thead>
                <th>Course name</th>
                <th>Lesson data</th>
              </thead>
              <s:iterator value="lessonList" status="userStatus">
                <tr>
                  <td><s:property value="course.name" /></td>
                  <td><s:property value="data.data" /></td>
                  <td>
                    <s:url id="editURL" action="get_lesson_for_lecturer">
                      <s:param name="lessonId" value="%{id}"></s:param>
                      <s:param name="userId" value="%{userId}"></s:param>
                    </s:url>
                    <s:a href="%{editURL}">Edit</s:a>
                  </td>
                  <td>
                    <s:url id="deleteURL" action="delete_lesson">
                      <s:param name="lessonId" value="%{id}"></s:param>
                      <s:param name="userId" value="%{userId}"></s:param>
                    </s:url>
                    <s:a href="%{deleteURL}">Delete</s:a>
                  </td>
                </tr>
              </s:iterator>
            </table>
          </div>
        </s:if>
        <s:url id="addURL" action="get_lesson_for_lecturer">
          <s:param name="userId" value="%{userId}"/>
          <s:param name="lessonId" value="%{null}"/>
        </s:url>
        <s:a href="%{addURL}">Create</s:a>
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

