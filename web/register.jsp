<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 21.04.2016
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:form action="register" method="post" class="Center" validate="true">
  <h2>Registration</h2>
  <s:textfield name="user.login" label="Login"/>
  <s:password name="user.password" label="Password"></s:password>
  <s:select class="ListU" list="{'student','lecturer'}" name="user.role" label="Role"></s:select>
  <s:textfield name="user.name" label="Name"></s:textfield>
  <s:textfield name="user.surname" label="Surname"></s:textfield>
  <s:textfield name="user.phone" label="Phone"></s:textfield>
  <s:textfield name="user.email" label="Email"></s:textfield>
  <s:hidden name="user.banStatus" value="0"></s:hidden>
  <s:submit value="Register"></s:submit>
</s:form>
</body>
</html>
