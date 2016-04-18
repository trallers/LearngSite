<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 02.04.2016
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>HALLO, STUDENT</h1>
<ul>
  <li>
    <h2>
      <a href="<s:url action="list_courses_for_student"><s:param name="userID">${param["userID"]}</s:param></s:url>">My courses</a>
    </h2>
  </li>
  <li>
  <h2>
    <a href="<s:url action="list_lessons_for_student"><s:param name="userID">${param["userID"]}</s:param></s:url>">Passed lessons</a>
  </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="list_certificates_for_students"><s:param name="userID">${param["userID"]}</s:param></s:url>">My certificates</a>
    </h2>
  </li>
  <li>
    <h2>
      <a href="<s:url action="get_user_for_student"><s:param name="userID">${param["userID"]}</s:param></s:url>">Settings</a>
    </h2>
  </li>
  <li>
    <h3>
      <a href="<s:url action="logout"></s:url>">Logout</a>
    </h3>
  </li>

</ul>
</body>
</html>
