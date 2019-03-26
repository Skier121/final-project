$(document).ready(() => {
    const beginLesson = (lessonId)=>{
        window.location.htef="/WEB-INF/jsp/lesson.jsp"
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
});