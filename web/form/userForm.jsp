
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="/resources/l18n/page_content" var="page_content" scope="session" />
<label> <fmt:message key="registration.email" bundle="${page_content}"/>
    <input id="email" name="email" />
</label>
<br>
<label> <fmt:message key="registration.phone" bundle="${page_content}"/>
    +<input id="phone" name="phone" />
</label>
<br>
<label> <fmt:message key="registration.address" bundle="${page_content}"/>
    <input id="address" name="address"/>
</label>
<br>
<label> <fmt:message key="registration.firstName" bundle="${page_content}"/>
    <input id="firstName" name="firstName" />
</label>
<br>
<label> <fmt:message key="registration.lastName" bundle="${page_content}"/>
    <input id="lastName" name="lastName" />
</label>
<br>
<label> <fmt:message key="registration.role" bundle="${page_content}"/>
    <select id="role" name="role">
        <option>PUPIL</option>
        <option>PARENT</option>
        <option>TEACHER</option>
        <option>ADMIN</option>
    </select>
</label>

