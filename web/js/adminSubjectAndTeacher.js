$(document).ready(() => {
    const deleteSubject = (subjectId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "deleteSubject", subjectId: subjectId},
            }).then((resp) => {
                showSubject();
            });
        }
    };

    const showTeacher = () => {
        var $table1 = $("#teachers tbody");
        $table1.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllTeacher"},
        }).then((resp) => {
            $.each(resp, (i, user) => {
                const tr = $("<tr></tr>");
                tr.append(`<td>${user.userId}</td>`);
                tr.append(`<td>${user.firstName}</td>`);
                tr.append(`<td>${user.lastName}</td>`);
                $table1.append(tr)
            });
        });
    };

    const showSubject = () => {
        var $table = $("#subjects tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllSubject"},
        }).then((resp) => {
            $.each(resp, (i, subject) => {
                const tr = $("<tr></tr>");
                const deleteButton = $("<input type='button' value='delete'/>");
                deleteButton.on("click", ()=>{
                    deleteSubject(subject.subjectId)
                });
                const tdDelete = $("<td></td>").append(deleteButton);
                const updateButton = $("<input type='button' value='edit'/>");
                updateButton.on("click", ()=>{
                    $("#action").val("updateSubject");
                    $("#subjectId").val(subject.subjectId);
                    $("#subjectName").val(subject.subjectName);
                    $("#teacherId").val(subject.teacherId);
                    $("#addSubject").val("Update subject");
                });
                const tdupdate = $("<td></td>").append(updateButton);
                tr.append(`<td>${subject.subjectId}</td>`);
                tr.append(`<td>${subject.subjectName}</td>`);
                tr.append(`<td>${subject.teacherId}</td>`);
                tr.append(updateButton);
                tr.append(tdDelete);
                $table.append(tr)
            });
        });
    };
    showSubject();
    showTeacher();

    const createOrUpadateSubject = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#formCreateSubject").serialize(),
        }).then((resp) => {
            var $form2 = $("#addSubject_result");
            $form2.text(resp.result);
            $("#subject-action").val("createSubject");
            $("#subjectName").val("");
            $("#teacherId").val("");
            $("#addNewSubject").val("Addd new subject");

            $form2.text("");
            console.log("showSubject")
            showSubject();

        });
    };

    $("#formCreateSubject").on("submit", (e) => {
        console.log("createSubject")
        e.stopPropagation();
        createOrUpadateSubject();
        return false;
    });
});