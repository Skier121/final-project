$(document).ready(() => {
    const showTimetable = () => {
        var $table1 = $("#timetable tbody");
        $table1.html("");
        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllLessonsAndHomework"},
        }).then((resp) => {
            $.each(resp, (i, lesson) => {
                const tr = $("<tr></tr>");
                tr.append(`<td>${lesson.date}</td>`);
                tr.append(`<td>${lesson.lessonNumber}</td>`);
                tr.append(`<td>${lesson.subjectName}</td>`);
                tr.append(`<td>${lesson.homework}</td>`);
                $table1.append(tr)
            });
        });
    };

    const showMarks = () => {
        var $table = $("#marks tbody");
        $table.html("");
        $.ajax({
            url: "/test/json",
            method: "GET",
            data: {action: "findAllMarks"},
        }).then((resp) => {
            $.each(resp, (i, mark) => {
                const tr = $("<tr></tr>");
                tr.append(`<td>${mark.date}</td>`);
                tr.append(`<td>${mark.subjectName}</td>`);
                tr.append(`<td>${mark.mark}</td>`);
                $table.append(tr)
            });
        });
    };
    showMarks();
    showTimetable();
});