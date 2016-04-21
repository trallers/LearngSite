<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 18.04.2016
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>Courses</h1>
  <s:if test="courseList.size() > 0">
    <div class="content">
      <table class="coursesTable" cellpadding="5px">
        <tr class="even">
          <th>ID</th>
          <th>Name</th>
          <th>Technology</th>
          <th>Id lecturer</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
        <s:iterator value="courseList" status="userStatus">
          <tr>
            <td><s:property value="id" /></td>
            <td><s:property value="name" /></td>
            <td><s:property value="technology" /></td>
            <td><s:property value="idLecturer" /></td>
            <td><s:property value="price" /></td>
            <td>
              <s:url id="editURL" action="get_course_for_admin">
                <s:param name="courseId" value="%{id}"></s:param>
              </s:url>
              <s:a href="%{editURL}">Edit</s:a>
            </td>
            <td>
              <s:url id="deleteURL" action="delete_course">
                <s:param name="courseId" value="%{id}"></s:param>
              </s:url>
              <s:a href="%{deleteURL}">Delete</s:a>
            </td>
          </tr>
        </s:iterator>
      </table>
    </div>
  </s:if>
  <s:url id="addURL" action="get_course_for_admin">
    <s:param name="courseId" value="%{null}"></s:param>
  </s:url>
  <s:a href="%{addURL}">Create</s:a>
  <s:url id="back" value="home_admin.jsp">
    <s:param name="userID" value="%{userID}"></s:param>
  </s:url>
  <s:a href="%{back}">Back</s:a>
</body>
</html>
