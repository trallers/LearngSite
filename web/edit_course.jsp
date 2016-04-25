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
    <title>Course</title>
    <s:head></s:head>
</head>
<body>
  <s:form action="create_or_update_course"  validate="true" method="POST">
      <s:actionerror></s:actionerror>
      <s:hidden name="course.id" readonly="true" label="Id"/>
      <s:textfield name="course.name" label="Name"/>
      <s:textfield name="course.technology" label="Technology"/>
      <s:select
              headerKey="0"
              headerValue="--Select lecturer-"
              name="lecturerID"
              label="Lecturer"
              list="lecturerList"
              listKey="id"
              listValue="surname"
              required="true"/>
      <s:textfield name="course.price" label="Price"/>
      <s:submit value="Save"/>
  </s:form>
</body>
</html>
