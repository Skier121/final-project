
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="/resources/l18n/page_content" var="page_content" scope="session" />
<table>
    <tr>
        <td>
            <label> <fmt:message key="registration.email" bundle="${page_content}"/></label>
        </td>
        <td>
            <input id="email" name="email" />
        </td>
    </tr>
    <tr>
        <td>
            <label> <fmt:message key="registration.phone" bundle="${page_content}"/></label>
        </td>
        <td>
            +<input id="phone" name="phone" />
        </td>
    </tr>
    <tr>
        <td>
            <label> <fmt:message key="registration.address" bundle="${page_content}"/></label>
        </td>
        <td>
            <input id="address" name="address"/>
        </td>
    </tr>
    <tr>
        <td>
            <label> <fmt:message key="registration.firstName" bundle="${page_content}"/></label>
        </td>
        <td>
            <input id="firstName" name="firstName" />
        </td>
    </tr>
    <tr>
        <td>
            <label> <fmt:message key="registration.lastName" bundle="${page_content}"/></label>
        </td>
        <td>
            <input id="lastName" name="lastName" />
        </td>
    </tr>
    <tr>
        <td>
            <label> <fmt:message key="registration.role" bundle="${page_content}"/></label>
        </td>
        <td>
            <select id="role" name="role">
                <option>PUPIL</option>
                <option>PARENT</option>
                <option>TEACHER</option>
                <option>ADMIN</option>
            </select>
        </td>
    </tr>
</table>

