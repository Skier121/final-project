
$(document).ready(()=>{
    $("#languageSelector").on("change", (e)=>{
        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: e.target.value},
        }).then(()=>{
            console.log("aaaaaaaaaaaaaaaaaaaa")
            window.location.reload();
        });
    })
});