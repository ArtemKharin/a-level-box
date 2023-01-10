<%@ page import="ua.kharin.model.TestData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="WEB-INF/mytags.tld" prefix="m" %>
<html>
<head>
    <title>JSP Sample</title>
</head>
<body>
<p>
<h1>This is Tags test page!</h1><br>
Current Date and Time is: <m:today></m:today><br>
1+1=<m:calc first="1" second="1">+</m:calc><br>
1-1=<m:calc first="1" second="1">-</m:calc><br>
2*5=<m:calc first="2" second="5">*</m:calc><br>
20/5=<m:calc first="20" second="5">/</m:calc><br>
<%
    pageContext.setAttribute("testobj", new TestData());
%>
<m:print-object value="${pageScope.testobj}"/>
</body>
</html>
