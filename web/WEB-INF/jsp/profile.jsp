<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 28.03.2019
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Profile</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/profile.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/profile.css" type="text/css">

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
            <b><fmt:message key="user.profile.data" bundle="${page_content}"/></b>
            <form id="userData" style="background-color: #b6ffae">
                <input type="hidden" name="action" value="updateUserData">
                <table>
                    <tr>
                        <td>
                            <label> <fmt:message key="user.profile.email" bundle="${page_content}"/></label>
                        </td>
                        <td>
                            <input id="email" name="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> <fmt:message key="user.profile.phone" bundle="${page_content}"/></label>
                        </td>
                        <td>
                            +<input id="phone" name="phone" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> <fmt:message key="user.profile.address" bundle="${page_content}"/></label>
                        </td>
                        <td>
                            <input id="address" name="address"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> <fmt:message key="user.profile.firstName" bundle="${page_content}"/></label>
                        </td>
                        <td>
                            <input id="firstName" name="firstName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> <fmt:message key="user.profile.lastName" bundle="${page_content}"/></label>
                        </td>
                        <td>
                            <input id="lastName" name="lastName" />
                        </td>
                    </tr>
                </table>
                <div id="updateUserData_result"></div>
                <br/>
                <input id="updateUserData" type="submit"
                       value="<fmt:message key="user.profile.updateData" bundle="${page_content}"/>"/>
            </form>
            <br>
            <fmt:message key="user.profile.passwordChange" bundle="${page_content}"/>
            <form id="changePassword">
                <table>
                    <tr>
                        <td>
                            <input type="hidden" name="action" value="newPassword"/>
                        </td>
                        <td>
                            <input name="newPassword"/>
                        </td>
                    </tr>
                </table>
                <br>
                <div id="setNewPassword_result"></div>
                <br>
                <input id="newPassword" type="submit"
                       pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"
                       value="<fmt:message key="user.profile.setNewPassword" bundle="${page_content}"/>"/>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
