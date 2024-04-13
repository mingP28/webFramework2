<%--
  Created by IntelliJ IDEA.
  User: eo77s
  Date: 2024-04-08
  Time: 오후 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학기별 이수 학점</title>
    <style>
        body {
            padding-top: 10px;
        }

        table {
            width: 90%;
            border-collapse: collapse;
            margin-top: 50px;
            margin-left: 30px;
            text-align: center;
        }
        th, td {
            width: 22.5%;
            padding: 20px;
        }
    </style>
</head>
<body>
<%--    <c:forEach var="course" items="${courses}">--%>
<%--        <p> <c:out value="${course}"></c:out></p>--%>
<%--    </c:forEach>--%>
    <table border="1">
        <thead>
        <tr>
            <th>수강년도</th>
            <th>학기</th>
            <th>취득학점</th>
            <th>상세보기</th>
            <!-- 추가적인 열을 필요에 따라 여기에 추가할 수 있습니다 -->
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${totalCredits}">
            <tr>
                <td><c:out value="${course.year}"/></td>
                <td><c:out value="${course.semester}"/></td>
                <td><c:out value="${course.totalCredit}"/></td>
                <td><a href="<c:url value='/detail/${course.year}/${course.semester}'/>">상세보기</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="1">총계</td>
            <td></td>
            <td>${totalSum}</td>
            <td></td>
        </tr>
        </tfoot>
    </table>
<a href="${pageContext.request.contextPath}/">홈으로</a>
</body>
</html>