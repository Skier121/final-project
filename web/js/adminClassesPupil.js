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

    const showClasses = () => {
        var $table = $("#classes tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllClas"},
        }).then((resp) => {
            $.each(resp, (i, clas) => {
                const tr = $("<tr></tr>");
                const deleteButton = $("<input type='button' value='delete'/>");
                deleteButton.on("click", ()=>{
                    deleteClas(clas.clasId)
                });
                const tdDelete = $("<td></td>").append(deleteButton);
                const updateButton = $("<input type='button' value='edit'/>");
                updateButton.on("click", ()=>{
                    $("#action").val("updateClas");
                    $("#userId").val(clas.clasId);
                    $("#firstName").val(clas.clasName);
                    $("#addNewClas").val("update class");
                });
                const tdupdate = $("<td></td>").append(updateButton);
                tr.append(`<td>${clas.clasId}</td>`);
                tr.append(`<td>${clas.clasName}</td>`);
                tr.append(updateButton);
                tr.append(tdDelete);
                $table.append(tr);
                fillSelect();
            });
        });
    };

    const fillSelect = () =>{
        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllClas", pupilId: userId},
        }).then((resp) => {
            var $select = $("#clasSelect");
            $.each(resp, (i, user) => {
                select.append($(`<option value="${clas.name}"></option>`));
            });
        })
    }

    const showPupils = () => {
        var $table1 = $("#pupils tbody");
        $table1.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllPupilInClas", clas: $("#clasSelect")},
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
                $table.append(tr)
            });
        });
    };

    showClasses();
    showPupils();

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

    $("#formCreateClas").on("submit", (e) => {
        console.log("createClas")
        e.stopPropagation();
        createOrUpadateClas();
        return false;
    });
});