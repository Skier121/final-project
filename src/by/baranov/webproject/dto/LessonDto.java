package by.baranov.webproject.dto;

public class LessonDto {
    private int lessonNumber;
    private String lessonSubjectName;
    private String lessonClassName;

    public LessonDto(int lessonNumber, String lessonSubjectName, String lessonClassName) {
        this.lessonNumber = lessonNumber;
        this.lessonSubjectName = lessonSubjectName;
        this.lessonClassName = lessonClassName;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getLessonSubjectName() {
        return lessonSubjectName;
    }

    public void setLessonSubjectName(String lessonSubjectName) {
        this.lessonSubjectName = lessonSubjectName;
    }

    public String getLessonClassName() {
        return lessonClassName;
    }

    public void setLessonClassName(String lessonClassName) {
        this.lessonClassName = lessonClassName;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"lessonNumber\":" + lessonNumber +
                ", \"sunjectName\":\"" + lessonSubjectName + "\"" +
                ", \"className\":\"" + lessonClassName + "\"" +
                '}';
    }
}
