$(document).ready(() => {
    const deleteClass = (clasId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "deleteClas", clasId: clasId},
            }).then((resp) => {
                showClasses();
            });
        }
    };

    const deletePupil = (userId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "deletePupil", pupilId: userId},
            }).then((resp) => {
                showPupils();
            });
        }
    };

    const showPupils = () => {
        var $table4 = $("#pupils tbody");
        $table4.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllPupilInClas", clas: $("#clasSelect").val()},
        }).then((resp) => {
            $.each(resp, (i, user) => {
                const tr = $("<tr></tr>");
                const pupilDeleteButton = $("<input type='button' value='delete'/>");
                pupilDeleteButton.on("click", ()=>{
                    deletePupil(user.userId)
                });
                const tdDelete = $("<td></td>").append(pupilDeleteButton);
                tr.append(`<td>${user.userId}</td>`);
                tr.append(`<td>${user.firstName}</td>`);
                tr.append(`<td>${user.lastName}</td>`);
                tr.append(`<td>${user.email}</td>`);
                tr.append(tdDelete);
                $table4.append(tr)
            });
        });
    };

    const showClasses = () => {
        var $table = $("#classes tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllClas"},
        }).then((resp) => {
            var $select = $("#clasSelect");
            $select.html('');
            $.each(resp, (i, clas) => {
                $select.append(`<option>${clas.clasName}</option>`);
                const tr = $("<tr></tr>");
                const deleteButton = $("<input type='button' value='delete'/>");
                deleteButton.on("click", ()=>{
                    deleteClass(clas.clasId)
                });
                const tdDelete = $("<td></td>").append(deleteButton);
                const updateButton = $("<input type='button' value='edit'/>");
                updateButton.on("click", ()=>{
                    $("#clas-action").val("updateClas");
                    $("#clasId").val(clas.clasId);
                    $("#clasName").val(clas.clasName);
                    $("#addNewClas").val("Update class");
                });
                const tdupdate = $("<td></td>").append(updateButton);
                tr.append(`<td>${clas.clasId}</td>`);
                tr.append(`<td>${clas.clasName}</td>`);
                tr.append(updateButton);
                tr.append(tdDelete);
                $table.append(tr)
            });
        });
    };

    showClasses();

    const createOrUpadateClas = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#formCreateClas").serialize(),
        }).then((resp) => {
            var $form2 = $("#formCreateClass .error");
            $form2.text(resp.result);
            if (resp.error) {
                $form2.text(resp.error);
            } else {
                $("#clas-action").val("createClas");
                $("#clasName").val("");
                $("#addNewClas").val("Addd new class");

                $form2.text("");
                console.log("showClasses")
                showClasses();
            }
        });
    };

    const addPupilToClas = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#addPupilToClas").serialize(),
        }).then((resp) => {
            var $form3 = $("#pupil_result");
            $form3.text(resp.result);
            $("#pupilEmail").val("");
            console.log("addPupilToClas")
            showPupils();
        });
    };

    $("#formCreateClas").on("submit", (e) => {
        console.log("createClas")
        e.stopPropagation();
        createOrUpadateClas();
        return false;
    });

    $("#addPupilToClas").on("submit", (e) => {
        console.log("addPupilToClas")
        e.stopPropagation();
        addPupilToClas();
        return false;
    });
});