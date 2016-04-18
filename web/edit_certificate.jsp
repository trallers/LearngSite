<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 17.04.2016
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Certificate</title>
</head>
<body>
  <s:form action="create_or_update_certificate">
    <s:textfield name="certificate.id" readonly="true" label="ID"></s:textfield>
    <s:textfield name="certificate.idStudent" label="Id student"></s:textfield>
    <s:textfield name="certificate.idCourse" label="Id course"></s:textfield>
    <s:textarea name="certificate.data" label="Data"></s:textarea>
    <s:textfield name="certificate.date" label="Date"></s:textfield>
    <s:submit value="Save"></s:submit>
  </s:form>
</body>
</html>
