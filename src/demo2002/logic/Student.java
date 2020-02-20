package demo2002.logic;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int kurs;
    private String group;

    public Student(int id, String name, int kurs, String group) {
        this.id = id;
        this.name = name;
        this.kurs = kurs;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                kurs == student.kurs &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kurs, group);
    }


    @Override
    public int compareTo(Student o) {
        int res = name.compareTo(o.name);
        if (res !=0) return res;
        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kurs=" + kurs +
                ", group='" + group + '\'' +
                '}';
    }
}
