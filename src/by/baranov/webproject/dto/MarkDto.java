package by.baranov.webproject.dto;

import java.sql.Date;

public class MarkDto {
    private Date date;
    private String subjectName;
    private int mark;

    public MarkDto(Date date, String subjectName, int mark) {
        this.date = date;
        this.subjectName = subjectName;
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"date\":\"" + date + "\"" +
                ", \"subjectName\":\"" + subjectName + "\"" +
                ", \"mark\":\"" + mark + "\"" +
                '}';
    }
}
