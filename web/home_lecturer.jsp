<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 02.04.2016
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Lecturer</title>
</head>
<body>
<h1>HALLO, LECTURER</h1>
<ul>
  <li>
    <h2>
      <a href="<s:url action="list_lessons_for_lecturer"><s:param name="userId">${param["userId"]}</s:param></s:url>">My lessons</a>
    </h2>
    <h3>
      <a href="<s:url action="logout"></s:url>">Logout</a>
    </h3>
  </li>
</ul>
</body>
</html>
