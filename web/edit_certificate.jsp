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
  <s:head/>
</head>
<body>
  <s:form action="create_or_update_certificate" validate="true">
    <s:hidden name="certificate.id" readonly="true" label="ID"/>
    <s:select
            headerKey="0"
            headerValue="--Select student-"
            name="idStudent"
            label="Student"
            list="studentList"
            listKey="id"
            listValue="surname"
            required="true"/>
    <s:select
            headerKey="0"
            headerValue="--Select course-"
            name="idCourse"
            label="Course"
            list="courseList"
            listKey="id"
            listValue="name"
            required="true"/>
    <s:textarea name="certificate.data" label="Data"/>
    <s:textfield name="certificate.date" label="Date"/>
    <s:submit value="Save"/>
  </s:form>
</body>
</html>
