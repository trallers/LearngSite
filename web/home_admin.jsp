<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 02.04.2016
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>HALLO, ODMEN</h1>
<ul>

  <li>
    <h2>
      <a href="<s:url action="list_users_for_admin" ></s:url>">Users</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_courses_for_admin"></s:url>">Courses</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_lessons_for_admin"></s:url>">Lessons</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_certificates_for_admin"></s:url>">Certificates</a>
    </h2>
  </li>
</ul>
</body>
</html>
