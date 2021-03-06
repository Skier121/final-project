<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08.02.2019
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Teacher</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/teacher.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/teacher.css" type="text/css">
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
            <table id="lessons">
                <thead>
                <tr>
                    <th>#</th>
                    <th><fmt:message key="teacher.lessons.table.lessonNumber" bundle="${page_content}"/></th>
                    <th><fmt:message key="teacher.lessons.table.lessonName" bundle="${page_content}"/></th>
                    <th><fmt:message key="teacher.lessons.table.className" bundle="${page_content}"/></th>
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
