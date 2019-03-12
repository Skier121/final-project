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

    $("#formCreateClas").on("submit", (e) => {
        console.log("createClas")
        e.stopPropagation();
        createOrUpadateClas();
        return false;
    });
});