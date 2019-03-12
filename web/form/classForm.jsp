<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="/resources/l18n/page_content" var="page_content" scope="session" />
<label> <fmt:message key="admin.classtable.class" bundle="${page_content}"/>
    <input id="className" name="className" />
</label>


