console.log(1232132131)
$(document).ready(() => {
    const deleteUser = (userId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "deleteUser", userId: userId},
            }).then((resp) => {
                showUsers();
            });
        }
    };

    const showUsers = () => {
        var $table = $("#users tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllUsers"},
        }).then((resp) => {
            $.each(resp, (i, user) => {
                const tr = $("<tr></tr>");
                const deleteButton = $("<input type='button' value='delete'/>");
                deleteButton.on("click", ()=>{
                    deleteUser(user.userId)
                });
                const tdDelete = $("<td></td>").append(deleteButton);
                const updateButton = $("<input type='button' value='edit'/>");
                updateButton.on("click", ()=>{
                    $("#user-action").val("updateUser");
                    $("#userId").val(user.userId);
                    $("#firstName").val(user.firstName);
                    $("#lastName").val(user.lastName);
                    $("#email").val(user.email);
                    $("#phone").val(user.phoneNumber);
                    $("#address").val(user.address);
                    $("#role").val(user.role);
                    $("#addNewUser").val("update " + user.email);
                });
                const tdupdate = $("<td></td>").append(updateButton);
                tr.append(`<td>${user.userId}</td>`);
                tr.append(`<td>${user.firstName}</td>`);
                tr.append(`<td>${user.lastName}</td>`);
                tr.append(`<td>${user.email}</td>`);
                tr.append(`<td>${user.phoneNumber}</td>`);
                tr.append(`<td>${user.address}</td>`);
                tr.append(`<td>${user.role}</td>`);
                tr.append(updateButton);
                tr.append(tdDelete);
                $table.append(tr)
            });
        });
    };
    showUsers();
    const createOrUpadateUser = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#createUser").serialize(),
        }).then((resp) => {
            var $form2 = $("#createUser .error");
            $form2.text(resp.result);
            if (resp.error) {
                $form2.text(resp.error);
            } else {
                $("#user-action").val("createUser");
                $("#userId").val("");
                $("#firstName").val("");
                $("#lastName").val("");
                $("#email").val("");
                $("#phone").val("");
                $("#address").val("");
                $("#role").val("")
                $("#addNewUser").val("Add new user");

                console.log("showUsers")
                showUsers();
            }
        });
    };

    $("#createUser").on("submit", (e) => {
        console.log("createUser")
        e.stopPropagation();
        createOrUpadateUser();
        return false;
    });
});