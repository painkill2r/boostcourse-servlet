<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Application Scope</title>
</head>
<body>
<%
    try {
        int value = (int) application.getAttribute("value");
        value += 2;

        application.setAttribute("value", value);
        %>
        <h1><%= value %></h1>
        <%
    } catch (NullPointerException e) {
        %>
        <h1>value에 설정된 값이 없습니다.</h1>
        <%
    }
%>
</body>
</html>
