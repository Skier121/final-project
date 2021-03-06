<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.02.2019
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Parent</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/parent.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/parent.css" type="text/css">
</head>

<body>
<fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>
<table class="layout">
    <tr>
        <td colspan="1" class="header">
            <%@include file="/header/header.jsp" %>
        </td>
    </tr>
    <tr>
        <td class="main">
            <label>
                <fmt:message key="parent.table.timetable" bundle="${page_content}"/>
            </label>
            <table id="timetable">
                <thead>
                <tr>
                    <th><fmt:message key="parent.table.date" bundle="${page_content}"/></th>
                    <th><fmt:message key="parent.table.lessonNumber" bundle="${page_content}"/></th>
                    <th><fmt:message key="parent.table.subjectName" bundle="${page_content}"/></th>
                    <th><fmt:message key="parent.table.homework" bundle="${page_content}"/></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
            <br>
            <label>
                <fmt:message key="parent.table.marks" bundle="${page_content}"/>
            </label>
            <table id="marks">
                <thead>
                <tr>
                    <th><fmt:message key="parent.table.marks.date" bundle="${page_content}"/></th>
                    <th><fmt:message key="parent.table.marks.subjectName" bundle="${page_content}"/></th>
                    <th><fmt:message key="parent.table.marks.mark" bundle="${page_content}"/></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </td>
    </tr>
</table>

</body>
</html>
