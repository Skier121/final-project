$(document).ready(() => {
    const showUserData = () => {
        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findUserData"},
        }).then((resp) => {
            $("#firstName").val(resp.firstName);
            $("#lastName").val(resp.lastName);
            $("#email").val(resp.email);
            $("#phone").val(resp.phoneNumber);
            $("#address").val(resp.address);
        });
    };
    showUserData();
    const upadateUserData = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#userData").serialize(),
        }).then((resp) => {
            var $res = $("#updateUserData_result");
            $res.text(resp.result);
        });
    };

    const setNewPassword = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#userData").serialize(),
        }).then((resp) => {
            var $res = $("#setNewPassword_result");
            $res.text(resp.result);
            $("#newPassword").val("");
        });
    };

    $("#userData").on("submit", (e) => {
        console.log("updateUserData")
        e.stopPropagation();
        upadateUserData();
        return false;
    });

    $("#changePassword").on("submit", (e) => {
        console.log("setNewPassword")
        e.stopPropagation();
        setNewPassword();
        return false;
    });
});