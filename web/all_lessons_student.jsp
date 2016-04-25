<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 04.04.2016
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>
</head>
<body>
      <h1>ALL LESSONS</h1>
      <s:if test="lessonList.size() > 0">
        <div class="content">
          <table class="courses_table" cellpadding="5px">
            <tr class="even">
              <th>Name of course</th>
              <th>Data</th>
            </tr>
            <s:iterator value="lessonList" status="userStatus">
              <tr>
                <td><s:property value="course.name"/></td>
                <td><s:property value="data.data" /></td>
              </tr>
            </s:iterator>
          </table>
        </div>
      </s:if>
</body>
</html>
