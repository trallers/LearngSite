<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 09.04.2016
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
  <s:form action="ban_user" class="Center">
    <h2>Edit user</h2>
    <s:textfield name="user.id" readonly="true" label="ID"></s:textfield>
    <s:textfield name="user.role" readonly="true" label="Role"></s:textfield>
    <s:textfield name="user.login" label="Login" readonly="true"></s:textfield>
    <s:hidden name="user.password" label="Password" readonly="true"></s:hidden>
    <s:textfield name="user.name" label="Name" readonly="true"></s:textfield>
    <s:textfield name="user.surname" label="Surname" readonly="true"></s:textfield>
    <s:textfield name="user.phone" label="Phone" readonly="true"></s:textfield>
    <s:textfield name="user.email" label="Email" readonly="true"></s:textfield>
    <s:textfield name="user.banStatus" label="Ban status" readonly="false"></s:textfield>
    <s:submit value="Save changes"></s:submit>
  </s:form>
</body>
</html>
