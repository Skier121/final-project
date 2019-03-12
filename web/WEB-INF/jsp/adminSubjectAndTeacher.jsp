<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.03.2019
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Subject</title>
    <%@include file="/header/header.jsp" %>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/adminSubject.js" type="text/javascript"></script>
</head>
<body>
<fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>
<input type="button" value="reload" onclick="window.location.reload()">
<form id="form2" style="background-color: #b6ffae">
    <input type="hidden" id="user-action" name="action" value="create">
    <input type="hidden" id="userId" name="userId" value="">
    <br>
    <%@ include file="/form/userForm.jsp" %>
    <br>
    <div id="addNewUser_result"></div>
    <br/>
    <div class="error" style="color: red;">

    </div>
    <input id="addNewUser" type="submit"
       value="<fmt:message key="admin.users.button.registration" bundle="${page_content}"/>"/>
</form>

<table id="teachers">
    <thead>
    <tr>
        <th><fmt:message key="admin.teachertable.teacherID" bundle="${page_content}"/></th>
        <th><fmt:message key="admin.teachertable.firstName" bundle="${page_content}"/></th>
        <th><fmt:message key="admin.teachertable.lastName" bundle="${page_content}"/></th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>

<table id="subjects">
    <thead>
    <tr>
        <th><fmt:message key="admin.subjecttable.subjectID" bundle="${page_content}"/></th>
        <th><fmt:message key="admin.subjecttable.subjectName" bundle="${page_content}"/></th>
        <th><fmt:message key="admin.subjecttable.teacherID" bundle="${page_content}"/></th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
</html>
