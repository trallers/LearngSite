<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 23.04.2016
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create admin</title>
  <s:head></s:head>
</head>
<body>
<s:form action="add_admin" class="Center" validate="true">
  <h2>Add admin</h2>
  <s:actionerror></s:actionerror>
  <s:hidden name="user.id"/>
  <s:hidden name="user.role" value="admin"/>
  <s:textfield name="user.login" label="Login"/>
  <s:password name="user.password" label="Password"/>
  <s:textfield name="user.name" label="Name"/>
  <s:textfield name="user.surname" label="Surname"/>
  <s:textfield name="user.phone" label="Phone"/>
  <s:textfield name="user.email" label="Email"/>
  <s:hidden name="user.banStatus" value="0"/>
  <s:submit value="Add admin"/>
</s:form>
</body>
</html>