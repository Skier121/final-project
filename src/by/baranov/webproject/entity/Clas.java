package by.baranov.webproject.entity;

import java.io.Serializable;

public class Clas extends Entity implements Serializable {
    private long id;
    private String name;

    public Clas(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clas(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"classId\":" + id +
                ", \"className\":\"" + name + "\"" +
                '}';
    }
}
