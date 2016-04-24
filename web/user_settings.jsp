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
    <s:head/>
</head>
<body>
  <s:form action="update_user" class="Center">
    <h2>Settings</h2>
    <s:hidden name="user.id"/>
    <s:hidden name="user.role"/>
    <s:hidden name="user.banStatus"/>
    <s:textfield name="user.login" label="Login" readonly="true"/>
    <s:password name="user.password" label="Password"/>
    <s:textfield name="user.name" label="Name"/>
    <s:textfield name="user.surname" label="Surname"/>
    <s:textfield name="user.phone" label="Phone"/>
    <s:textfield name="user.email" label="Email"/>
    <s:hidden name="userId" value="%{userId}"/>
    <s:submit value="Save changes"/>
  </s:form>
</body>
</html>
