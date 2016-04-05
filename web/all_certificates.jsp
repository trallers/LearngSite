<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 03.04.2016
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>

      <h1>ALL CERTIFICATES</h1>
      <s:if test="certificateList.size() > 0">
        <div class="content">
          <table class="certificates_table" cellpadding="5px">
            <tr class="even">
              <th>Data</th>
              <th>Date</th>
            </tr>
            <s:iterator value="certificateList" status="userStatus">
              <tr>
                  <td><s:property value="data" /></td>
                  <td><s:property value="date" /></td>
              </tr>
            </s:iterator>
          </table>
        </div>
      </s:if>
</body>
</html>
