<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 26.03.2019
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Lesson</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/lesson.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/lesson.css" type="text/css">
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
        <form id="formHomework">
            <label>
                <fmt:message key="teacher.lesson.currentHomework" bundle="${page_content}"/>
            </label>
            <br>
            <div id="currentHomework" name="currentHomework" type="text"></div>
            <br>
            <label>
                <fmt:message key="teacher.lesson.newHomework" bundle="${page_content}"/>
            </label>
            <br>
            <input type="hidden" name="action" value="newHomework"/>
            <input id="newHomework" type="text"/>
            <input type="submit" id="addHomework"
                   value="<fmt:message key="teacher.lesson.addHomework" bundle="${page_content}"/>"/>
        </form>
        <td class="main">
            <table id="journal">
                <thead>
                <tr>
                    <th><fmt:message key="teacher.lesson.journal.pupilName" bundle="${page_content}"/></th>
                    <th><fmt:message key="teacher.lesson.journal.pupilLastName" bundle="${page_content}"/></th>
                    <th><fmt:message key="teacher.lesson.journal.pupilMark" bundle="${page_content}"/></th>
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
