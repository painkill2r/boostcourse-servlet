<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="value1" scope="request" value="test"/>
<c:import url="http://localhost:8080/jsp/jstl/jstlValue.jsp" var="urlValue" scope="request"></c:import>
<%
    request.setAttribute("n", 10);

    request.setAttribute("score", 83);

    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("!!!");
    request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>JSTL 코어 태그</title>
</head>
<body>
값: ${value1}<br/>
<c:remove var="value1" scope="request"/>
지운 뒤 값: ${value1}<br/>
<hr/>
<c:if test="${n == 0}">
    n은 과 0과 같습니다.
</c:if>

<c:if test="${n == 10}">
    n은 과 10과 같습니다.
</c:if>
<hr/>
<c:choose>
    <c:when test="${score >=90 }">
        A학점입니다.
    </c:when>
    <c:when test="${score >=80 }">
        B학점입니다.
    </c:when>
    <c:when test="${score >=70 }">
        C학점입니다.
    </c:when>
    <c:when test="${score >=60 }">
        D학점입니다.
    </c:when>
    <c:otherwise>
        F학점입니다.
    </c:otherwise>
</c:choose>
<hr/>
<c:forEach items="${list}" var="item">
    ${item }<br/>
</c:forEach>
<hr/>
읽어들인 값 : ${urlValue}
</body>
</html>
