$(document).ready(() => {
    const deleteClass = (classId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "deleteClass", classId: classId},
            }).then((resp) => {
                showClasses();
            });
        }
    };

    const showClasses = () => {
        var $table = $("#classes tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllClasses"},
        }).then((resp) => {
            $.each(resp, (i, clas) => {
                const tr = $("<tr></tr>");
                const deleteButton = $("<input type='button' value='delete'/>");
                deleteButton.on("click", ()=>{
                    deleteClass(clas.classId)
                });
                const tdDelete = $("<td></td>").append(deleteButton);
                const updateButton = $("<input type='button' value='edit'/>");
                updateButton.on("click", ()=>{
                    $("#class-action").val("updateClass");
                    $("#classId").val(clas.classId);
                    $("#className").val(clas.className);
                    $("#addNewUser").val("update " + user.email);
                });
                const tdupdate = $("<td></td>").append(updateButton);
                tr.append(`<td>${clas.classId}</td>`);
                tr.append(`<td>${user.className}</td>`);
                tr.append(updateButton);
                tr.append(tdDelete);
                $table.append(tr)
            });
        });
    };
    showClasses();
    const createOrUpadateClass = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#createClass").serialize(),
        }).then((resp) => {
            var $formCreateClass = $("#createClass .error");
            $formCreateClass.text(resp.result);
            if (resp.error) {
                $formCreateClass.text(resp.error);
            } else {
                $("#class-action").val("createClass");
                $("#classId").val("");
                $("#className").val("");
                $("#addNewClass").val("Create");

                $formCreateClass.text("");
                console.log("showClasses")
                showClasses();
            }
        });
    };

    $("#createClass").on("submit", (e) => {
        console.log("createClass")
        e.stopPropagation();
        createOrUpadateClass();
        return false;
    });
});