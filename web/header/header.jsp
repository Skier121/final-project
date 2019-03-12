<%@ page import="by.baranov.webproject.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 14.02.2019
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/localeChange.js" type="text/javascript"></script>

<%
    User user = (User) session.getAttribute("userInSystem");
    if (user != null) {
%>
<span>Hello <%=user.getFirstName()%> <%=user.getLastName()%></span>
<form id="logout" style="display: inline">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="logout" formmethod="post" formaction="controller">
</form>
<%
    }
%>


<label for="languageSelector">Select language</label>
<select id="languageSelector">
    <option value="setEn" <%=session.getAttribute("locale").toString().equals("en") ? "selected='selected'" : ""%>>English</option>
    <option value="setRu" <%=session.getAttribute("locale").toString().equals("ru") ? "selected='selected'" : ""%>>Русский</option>
</select>
