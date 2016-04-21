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
  <s:head />
</head>
</head>
<body>

<h2>Login</h2>
<s:actionmessage></s:actionmessage>
<s:actionerror></s:actionerror>
<s:form action="login" method="post" validate="true">
  <s:textfield name="login" label="Login"></s:textfield>
  <s:password name="password" label="Password"></s:password>
  <s:submit value="Login"></s:submit>
</s:form>
</body>
</html>
