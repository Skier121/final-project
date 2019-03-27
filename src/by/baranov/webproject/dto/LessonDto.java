package by.baranov.webproject.dto;

public class LessonDto {
    private long lessonId;
    private int lessonNumber;
    private String lessonSubjectName;
    private String lessonClassName;

    public LessonDto(long lessonId, int lessonNumber, String lessonSubjectName, String lessonClassName) {
        this.lessonId = lessonId;
        this.lessonNumber = lessonNumber;
        this.lessonSubjectName = lessonSubjectName;
        this.lessonClassName = lessonClassName;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
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
                "  \"lessonId\":\"" + lessonId + "\"" +
                ", \"lessonNumber\":\"" + lessonNumber + "\"" +
                ", \"subjectName\":\"" + lessonSubjectName + "\"" +
                ", \"className\":\"" + lessonClassName + "\"" +
                '}';
    }
}
