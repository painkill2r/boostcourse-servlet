<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP Life Cycle</title>
</head>
<body>
<h1>Hello, JSP</h1>
<%
    System.out.println("jspService()");
%>
<%!
    /**
     * Init 메소드 호출
     * JSP를 실행시키기 전 작업할 것이 있다면 해당 메소드 구현
     */
    public void jspInit() {
        System.out.println("jspInit()");
    }
%>

<%!
    /**
     * Destroy 메소드 호출
     * JSP가 종료되기 전에 작업할 것이 있다면 해당 메소드 구현
     */
    public void jspDestroy() {
        System.out.println("jspDestroy()");
    }
%>
</body>
</html>
