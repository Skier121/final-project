package by.baranov.webproject.dto;

import java.sql.Date;

public class TimetableAndHomeworkDto {
    private Date date;
    private int lessonNumber;
    private String subjectName;
    private String homework;

    public TimetableAndHomeworkDto(Date date, int lessonNumber, String subjectName, String homework) {
        this.date = date;
        this.lessonNumber = lessonNumber;
        this.subjectName = subjectName;
        this.homework = homework;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"date\":\"" + date + "\"" +
                ", \"lessonNumber\":\"" + lessonNumber + "\"" +
                ", \"subjectName\":\"" + subjectName + "\"" +
                ", \"homework\":\"" + homework + "\"" +
                '}';
    }
}
