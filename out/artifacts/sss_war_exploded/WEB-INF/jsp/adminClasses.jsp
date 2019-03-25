<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11.03.2019
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Classes</title>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/adminClasses.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/adminClass.css" type="text/css">

</head>
<body>
<fmt:setLocale value="${sessionScope.get('locale')}" scope="session"/>
<table class="layout">
    <tr>
        <td colspan="3" class="header">
            <%@include file="/header/header.jsp" %>
        </td>
    </tr>
    <tr>
        <td class="menu">
            <div><a href="/test/controller?command=users">
                <fmt:message key="admin.user.form" bundle="${page_content}"/>
                </a>
            </div>
            <div><a href="/test/controller?command=subjectAndTeacher">
                <fmt:message key="admin.link.subjectAndTeacher" bundle="${page_content}"/>
                </a>
            </div>
        </td>
        <td class="classAndPupil">
            <table class="cas">
                <td class="mainClass">
                    <b><fmt:message key="admin.classes.form" bundle="${page_content}"/></b>
                    <form id="formCreateClas" style="background-color: #b6ffae">
                        <input type="hidden" id="clas-action" name="action" value="createClas">
                        <input type="hidden" id="clasId" name="clasId" value="">
                        <br>
                        <%@ include file="/form/classForm.jsp" %>
                        <br>
                        <div id="clas_result"></div>
                        <br/>
                        <div class="error" style="color: red;">

                        </div>
                        <input id="addNewClas" type="submit"
                               value="<fmt:message key="admin.classes.button.addNew" bundle="${page_content}"/>"/>
                    </form>

                    <table id="classes">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th><fmt:message key="admin.classtable.class" bundle="${page_content}"/></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </td>

                <td class="mainPupil">
                    <b><fmt:message key="admin.classes.form" bundle="${page_content}"/></b>
                    <form id="addPupilToClas" style="background-color: #b6ffae">
                        <input type="hidden" id="action" name="action" value="addPupilToClas">
                        <input type="hidden" id="classId" name="classId" value="">
                        <br>
                        <%@ include file="/form/pupilForm.jsp" %>
                        <br>
                        <div id="pupil_result"></div>
                        <br/>
                        <div class="error" style="color: red;">

                        </div>
                        <input id="addPupil" type="submit"
                               value="<fmt:message key="admin.classes.addPupil" bundle="${page_content}"/>"/>
                    </form>
                    <table id="pupils">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th><fmt:message key="admin.class.pupiltable.firstName" bundle="${page_content}"/></th>
                            <th><fmt:message key="admin.class.pupiltable.lastName" bundle="${page_content}"/></th>
                            <th><fmt:message key="admin.class.pupiltable.email" bundle="${page_content}"/></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </td>
            </table>
        </td>
    </tr>
</table>

</body>
</html>
