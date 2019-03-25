package by.baranov.webproject.entity;

public class Subject extends Entity {
    private long subjectId;
    private String subjectName;
    private long teacherId;

    public Subject(String subjectName, long teacherId) {
        this.subjectName = subjectName;
        this.teacherId = teacherId;
    }

    public Subject(long subjectId, String subjectName, long teacherId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacherId = teacherId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"subjectId\":" + subjectId +
                ", \"subjectName\":\"" + subjectName + "\"" +
                ", \"teacherId\":\"" + teacherId + "\"" +
                '}';
    }
}
