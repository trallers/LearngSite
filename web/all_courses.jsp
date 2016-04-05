<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 03.04.2016
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <h1>ALL COURSES</h1>
  <s:if test="courseList.size() > 0">
    <div class="content">
      <table class="courses_table" cellpadding="5px">
        <tr class="even">
          <th>Name</th>
          <th>Technology</th>
          <th>Price You</th>
        </tr>
        <s:iterator value="courseList" status="userStatus">
          <tr>
            <td><s:property value="name" /></td>
            <td><s:property value="technology" /></td>
            <td><s:property value="price" /></td>
          </tr>
        </s:iterator>
      </table>
    </div>
  </s:if>
</body>
</html>
