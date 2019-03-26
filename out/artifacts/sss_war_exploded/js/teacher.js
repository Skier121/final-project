$(document).ready(() => {
    const beginLesson = (lessonId)=>{
        if (confirm("Really?")) {
            $.ajax({
                url: "/test/json",
                method: "GET",
                data: {action: "beginLesson", lessonId: lessonId},
            }).then((resp) => {
            });
        }
    };

    const showLessons = () => {
        var $table = $("#lessons tbody");
        $table.html("");

        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllTeacherSubject"},
        }).then((resp) => {
            $.each(resp, (i, lesson) => {
                const tr = $("<tr></tr>");
                const beginButton = $("<input type='button' value='begin'/>");
                beginButton.on("click", ()=>{
                    beginLesson(lesson.lessonId)
                });
                const tdBegin = $("<td></td>").append(beginButton);
                tr.append(`<td>${lesson.lessonId}</td>`);
                tr.append(`<td>${lesson.lessonNumber}</td>`);
                tr.append(`<td>${lesson.subjectName}</td>`);
                tr.append(`<td>${lesson.className}</td>`);
                tr.append(tdBegin);
                $table.append(tr)
            });
        });
    };

    showLessons();

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

    $("#addPupilToClas").on("submit", (e) => {
        console.log("addPupilToClas")
        e.stopPropagation();
        addPupilToClas();
        return false;
    });
});