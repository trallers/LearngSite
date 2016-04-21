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
    <title></title>
</head>
<body>
<s:url id="back" value="home_admin.jsp">
  <s:param name="userID" value="%{userID}"></s:param>
</s:url>
<s:a href="%{back}">Back</s:a>
</body>
</html>
