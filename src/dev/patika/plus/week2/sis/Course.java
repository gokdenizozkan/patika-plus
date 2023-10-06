package dev.patika.plus.week2.sis;

public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int grade;
    int performance; // another grade type
    float gradeWeight;

    public Course(String name, String code, String prefix, float gradeWeight) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.grade = 0;
        this.performance = 0;
        this.gradeWeight = gradeWeight;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }
}
