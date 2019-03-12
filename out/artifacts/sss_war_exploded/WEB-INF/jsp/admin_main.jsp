<%@ page import="by.baranov.webproject.util.JspHelper" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.02.2019
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Admin</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/adminUser.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/admin.css" type="text/css">

</head>
<body>
<fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>

<table class="layout">
    <tr>
        <td colspan="2" class="header">
            <%@include file="/header/header.jsp" %>
        </td>
    </tr>
    <tr>
        <td class="menu">
            <form id="toClasses">
                <input type="hidden" name="command" value="classes"/>
                <input type="submit" value="<fmt:message key="admin.classes.form" bundle="${page_content}"/> "
                       formmethod="post" formaction="controller">
            </form>
            <form id="toSubjects" >
                <input type="hidden" name="command" value="subjectAndTeacher"/>
                <input type="submit" value="<fmt:message key="admin.subjects.form" bundle="${page_content}"/> "
                       formmethod="post" formaction="controller">
            </form>
        </td>
        <td class="main">
            <b><fmt:message key="admin.user.form" bundle="${page_content}"/></b>
            <form id="createUser" style="background-color: #b6ffae">
                <input type="hidden" id="user-action" name="action" value="createUser">
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

            <table id="users">
                <thead>
                <tr>
                    <th>#</th>
                    <th><fmt:message key="admin.usertable.firstName" bundle="${page_content}"/></th>
                    <th><fmt:message key="admin.usertable.lastName" bundle="${page_content}"/></th>
                    <th><fmt:message key="admin.usertable.email" bundle="${page_content}"/></th>
                    <th><fmt:message key="admin.usertable.phone" bundle="${page_content}"/></th>
                    <th><fmt:message key="admin.usertable.address" bundle="${page_content}"/></th>
                    <th><fmt:message key="admin.usertable.role" bundle="${page_content}"/></th>
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
