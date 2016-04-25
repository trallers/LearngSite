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
    <title>Admin</title>
</head>
<body>
<h1>HALLO, ODMEN</h1>
<ul>

  <li>
    <h2>
      <a href="<s:url action="list_users_for_admin"/>">Users</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_courses_for_admin"/>">Courses</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_lessons_for_admin"/>">Lessons</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_certificates_for_admin"/>">Certificates</a>
    </h2>
  </li>
  <li>
    <h3>
      <a href="<s:url action="logout"/>">Logout</a>
    </h3>
  </li>
</ul>
</body>
</html>
