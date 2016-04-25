<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 18.04.2016
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>
</head>
<body>
<h1>All lessons</h1>
<s:if test="lessonList.size() > 0">
  <div class="content">
    <table class="lessons_table" cellpadding="5px">
      <tr class="even">
        <th>Course name</th>
        <th>Lesson data</th>
      </tr>
      <s:iterator value="lessonList" status="userStatus">
        <tr>
          <td><s:property value="course.name" /></td>
          <td><s:property value="data.data" /></td>
          <td>
            <s:url id="editURL" action="get_lesson_for_lecturer">
              <s:param name="lessonId" value="%{id}"></s:param>
              <s:param name="userId" value="%{userId}"></s:param>
            </s:url>
            <s:a href="%{editURL}">Edit</s:a>
          </td>
          <td>
            <s:url id="deleteURL" action="delete_lesson">
              <s:param name="lessonId" value="%{id}"></s:param>
              <s:param name="userId" value="%{userId}"></s:param>
            </s:url>
            <s:a href="%{deleteURL}">Delete</s:a>
          </td>
        </tr>
      </s:iterator>
    </table>
  </div>
</s:if>
<s:url id="addURL" action="get_lesson_for_lecturer">
  <s:param name="userId" value="%{userId}"/>
  <s:param name="lessonId" value="%{null}"/>
</s:url>
<s:a href="%{addURL}">Create</s:a>

<s:url id="back" value="home_lecturer.jsp">
  <s:param name="userId" value="%{userId}"/>
</s:url>
<s:a href="%{back}">Back</s:a>
</body>
</html>
