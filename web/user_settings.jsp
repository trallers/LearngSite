<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 10.04.2016
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
  <s:form action="update_user" class="Center">
    <h2>Settings</h2>
    <s:hidden name="user.id"></s:hidden>
    <s:hidden name="user.role"></s:hidden>
    <s:hidden name="user.banStatus"></s:hidden>
    <s:textfield name="user.login" label="Login" readonly="true"></s:textfield>
    <s:password name="user.password" label="Password"></s:password>
    <s:textfield name="user.name" label="Name"></s:textfield>
    <s:textfield name="user.surname" label="Surname"></s:textfield>
    <s:textfield name="user.phone" label="Phone"></s:textfield>
    <s:textfield name="user.email" label="Email"></s:textfield>
    <s:submit value="Save changes"></s:submit>
  </s:form>
</body>
</html>
