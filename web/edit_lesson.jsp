<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:form action="create_or_update_lesson">
    <s:textfield name="lesson.id" readonly="true" label="Id"></s:textfield>
    <s:textfield name="lesson.courseName" label="Name"></s:textfield>
    <s:textarea name="lesson.data" label="Technology"></s:textarea>
    <s:submit value="Save"></s:submit>
</s:form>
</body>
</html>
