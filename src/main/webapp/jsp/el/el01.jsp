<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("p1", "page scope value");
    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1", "session scope value");
    application.setAttribute("a1", "application scope value");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>EL 예제</title>
</head>
<body>
<h3>표현식 사용</h3>
pageContext.getAttribute("p1"): <%= pageContext.getAttribute("p1") %><br/>
<br/>

<h3>EL 사용</h3>
pageContext.getAttribute("p1"): ${pageScope.p1}<br/>
request.getAttribute("r1"): ${requestScope.r1}<br/>
session.getAttribute("s1"): ${sessionScope.s1}<br/>
application.getAttribute("a1"): ${applicationScope.a1}<br/>
<br/>

<h3>각 Scope에 저장된 변수 명칭이 겹치지 않는 경우 줄여서 사용 가능, 하지만 명시적으로 사용하는 것을 권장.</h3>
pageContext.getAttribute("p1"): ${p1}<br/>
request.getAttribute("r1"): ${r1}<br/>
session.getAttribute("s1"): ${s1}<br/>
application.getAttribute("a1"): ${a1}<br/>
</body>
</html>
