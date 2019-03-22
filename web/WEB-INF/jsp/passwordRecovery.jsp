<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 20.03.2019
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>PasswordRecovery</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/passwordRecovery.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/passwordRecovery.css" type="text/css">
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
        <td class="main">
            <form id="emailInput">
                <input type="hidden" id="action" name="action" value="recoverPassword"/>
                <input id="email" type="text" name="email"/>
                <br>
                <div id="passwordRecovery_result"></div>
                <br>
                <input type="submit" id="recover"
                       value="<fmt:message key="passwordRecovery.recover" bundle="${page_content}"/>"/>
            </form>
            <form id="back">
            <input type="submit" name="back to main"
                   value="<fmt:message key="passwordRecovery.toMain" bundle="${page_content}"/>"
                   formmethod="post" formaction="controller"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
