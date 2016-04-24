<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson</title>
</head>
<body>
<s:form action="create_or_update_lesson" method="POST">
    <s:textfield name="lesson.id" readonly="true" label="Id"></s:textfield>
    <s:select
            name="courseName"
            label="Course name"
            list="courseList"
            listKey="name"
            listValue="name"
            required="true"/>
    <s:textarea name="lesson.data" label="Data"></s:textarea>
    <s:hidden name="userId" value="%{userId}"></s:hidden>
    <s:submit value="Save"></s:submit>
</s:form>
</body>
</html>
