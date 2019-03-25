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

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/adminSubjectAndTeacher.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/adminTeacherAndSubject.css" type="text/css">


</head>
<body>
<fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>

<table class="layout">
    <tr>
        <td colspan="4" class="header">
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
            <form id="toUsers" >
                <input type="hidden" name="command" value="users"/>
                <input type="submit" value="<fmt:message key="admin.user.form" bundle="${page_content}"/> "
                       formmethod="post" formaction="controller">
            </form>
        </td>
        <td class="main">
            <td>
                <b><fmt:message key="admin.subjects.form" bundle="${page_content}"/></b>
                <form id="formCreateSubject" style="background-color: #91e2ff">
                    <input type="hidden" id="action" name="action" value="createSubject">
                    <input type="hidden" id="subjectId" name="subjectId" value="">
                    <br>
                    <table>
                        <tr>
                            <td>
                                <label><fmt:message key="admin.subject.subjectName" bundle="${page_content}"/></label>
                            </td>
                            <td>
                                <input id="subjectName" type="text" name="subjectName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><fmt:message key="admin.subject.teacherId" bundle="${page_content}"/></label>
                            </td>
                            <td>
                                <input id="teacherId" type="text" name="teacherId"/>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <div id="addSubject_result"></div>
                    <input id="addSubject" type="submit"
                           value="<fmt:message key="admin.subject.addNewSubject" bundle="${page_content}"/>"/>
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
            </td>
            <td>
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
            </td>
        </td>
    </tr>
</table>
</body>
</html>
