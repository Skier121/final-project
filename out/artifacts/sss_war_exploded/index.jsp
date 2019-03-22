<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 04.02.2019
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
  </head>
  <body>
  <fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>
  <fmt:setBundle basename="/resources/l18n/page_content" var="page_content" scope="session" />
  <table class="layout">
    <tr>
      <td colspan="2" class="header">
        <%@include file="/header/header.jsp" %>
      </td>
    </tr>
    <tr>
      <td class="main">
        <form id="1">
          <table>
            <fmt:message key="page.greetengs" bundle="${page_content}"/>
        </form>
        <table class="table">
          <tr>
            <td>
              <label><fmt:message key="login" bundle="${page_content}"/></label>
            </td>
            <td>
              <input name="login" type="text" pattern="[\p{Alpha}\d\p{punct}]+@[\p{Alpha}]+.[\p{Alpha}]+" autofocus/>
            </td>
          </tr>
          <tr>
            <td>
              <label><fmt:message key="password" bundle="${page_content}"/></label>
            </td>
            <td>
                 <input name="password" type="text">
            </td>
          </tr>
        </table>
          <br>
          <input type="hidden" name="command" value="login" />
          <input type="submit" value="<fmt:message key="button.login" bundle="${page_content}"/> " formmethod="post"
                 formaction="controller"/>
          <br>
          <p>${sessionScope.get("wrong_data")}</p>
        </form>
        <form id="passwordRecovery">
          <label>
            <fmt:message key="label.passwordRecovery" bundle="${page_content}"/>
          </label>
          <br>
          <input type="hidden" name="command" value="passwordRecovery"/>
          <input type="submit" value="<fmt:message key="button.passwordRecovery" bundle="${page_content}"/> "
                 formmethod="post" formaction="controller"/>
        </form>
      </td>
    </tr>
  </table>
  </body>
</html>
