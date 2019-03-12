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
  </head>
  <%@include file="/header/header.jsp"%>
  <body>
  <fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>
  <fmt:setBundle basename="/resources/l18n/page_content" var="page_content" scope="session" />
  <form id="1">
      <fmt:message key="page.greetengs" bundle="${page_content}"/>
  </form>
  <form id="2">
      <label><fmt:message key="login" bundle="${page_content}"/>
         <input name="login" type="text" pattern="[\p{Alpha}\d\p{punct}]+@[\p{Alpha}]+.[\p{Alpha}]+" autofocus/>
      </label>
    <br>
      <label><fmt:message key="password" bundle="${page_content}"/>
         <input name="password" type="text">
      </label>
    <br>
    <input type="hidden" name="command" value="login" />
    <input type="submit" value="<fmt:message key="button.login" bundle="${page_content}"/> " formmethod="post"
           formaction="controller"/>
    <br>
    <p>${sessionScope.get("wrong_data")}</p>
  </form>
  </body>
</html>
