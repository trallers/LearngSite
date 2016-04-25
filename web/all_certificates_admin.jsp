<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 10.04.2016
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Certificates</title>
</head>
<body>
<h1>ALL CERTIFICATES</h1>
<s:if test="certificateList.size() > 0">
  <div class="content">
    <table class="certificates_table" cellpadding="5px">
      <tr class="even">
        <th>Id student</th>
        <th>Id course</th>
        <th>Data</th>
        <th>Date</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      <s:iterator value="certificateList" status="userStatus">
        <tr>
          <td><s:property value="id" /></td>
          <td><s:property value="idStudent" /></td>
          <td><s:property value="idCourse" /></td>
          <td><s:property value="data" /></td>
          <td><s:property value="date" /></td>
          <td>
            <s:url id="editURL" action="get_certificate_for_admin">
              <s:param name="certificateId" value="%{id}"/>
            </s:url>
            <s:a href="%{editURL}">Edit</s:a>
          </td>
          <td>
            <s:url id="deleteURL" action="delete_certificate">
              <s:param name="certificateId" value="%{id}"/>
            </s:url>
            <s:a href="%{deleteURL}">Delete</s:a>
          </td>

        </tr>
      </s:iterator>
    </table>
  </div>
</s:if>
<s:url id="addURL" action="get_certificate_for_admin">
  <s:param name="certificateId" value="%{null}"/>
</s:url>
<s:a href="%{addURL}">Create</s:a>
<s:url id="back" value="home_admin.jsp">
  <s:param name="userId" value="%{userId}"/>
</s:url>
<s:a href="%{back}">Back</s:a>
</body>
</html>
