<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 18.04.2016
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <s:form action="create_or_update_course">
    <s:textfield name="course.id" readonly="true" label="Id"></s:textfield>
    <s:textfield name="course.name" label="Name"></s:textfield>
    <s:textfield name="course.technology" label="Technology"></s:textfield>
    <s:textarea name="course.idLecturer" label="Id lecturer"></s:textarea>
    <s:textfield name="course.price" label="Price"></s:textfield>
    <s:submit value="Save"></s:submit>
  </s:form>
</body>
</html>
