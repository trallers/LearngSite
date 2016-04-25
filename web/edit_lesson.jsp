<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson</title>
</head>
<body>
<s:form action="create_or_update_lesson" method="POST">
    <s:hidden name="lesson.id"/>
    <s:select
            headerKey="0"
            headerValue="---Select course---"
            name="courseName"
            label="Course name"
            list="courseList"
            listKey="name"
            listValue="name"
            required="true"/>
    <s:hidden name="lesson.data.id"/>
    <s:textarea name="lesson.data.data" label="Data"/>
    <s:hidden name="userId" value="%{userId}"/>
    <s:submit value="Save"/>
</s:form>
</body>
</html>
