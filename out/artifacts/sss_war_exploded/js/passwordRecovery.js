console.log("recover js")
$(document).ready(() => {
    $("#emailInput").on("submit", (e) => {
        console.log("recover")
        e.stopPropagation();
        recoverPassword();
        return false;
    });

    const recoverPassword = ()=>{
        $.ajax({
            url: "/test/json",
            method: "POST",
            data: $("#emailInput").serialize(),
        }).then((resp) => {
            var $form2 = $("#passwordRecovery_result");
            $form2.text(resp.result);
            $("#email").val("");
        });
    };
});