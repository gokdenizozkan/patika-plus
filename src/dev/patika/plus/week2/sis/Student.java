package dev.patika.plus.week2.sis;

public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    public Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAverage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.grade = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.grade = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.grade = kimya;
        }

    }

    public void addBulkPerformanceNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.performance = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.performance = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.performance = kimya;
        }

    }

    public void isPass() {
        if (this.mat.grade == 0 || this.fizik.grade == 0 || this.kimya.grade == 0
        || this.mat.performance == 0 || this.fizik.performance == 0 || this.kimya.performance == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAverage() {
        this.avarage = (((this.fizik.grade * this.fizik.gradeWeight) + (this.fizik.performance * (1.0f - this.fizik.gradeWeight))
                + (this.kimya.grade * this.kimya.gradeWeight) + (this.kimya.performance * (1.0f - this.kimya.gradeWeight))
                + (this.mat.grade * this.mat.gradeWeight) + (this.mat.performance * (1.0f - this.mat.gradeWeight)))
                / 3);
    }

    public boolean isCheckPass() {
        calcAverage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("(%"+ this.mat.gradeWeight + ") Matematik Notu : " + this.mat.grade);
        System.out.println("(%"+ (1.0f - this.mat.gradeWeight) + ") --Performans Notu : " + this.mat.performance);
        System.out.println("(%"+ this.fizik.gradeWeight + ") Fizik Notu : " + this.fizik.grade);
        System.out.println("(%"+ (1.0f - this.fizik.gradeWeight) + ") --Performans Notu : " + this.fizik.performance);
        System.out.println("(%"+ this.kimya.gradeWeight + ") Kimya Notu : " + this.kimya.grade);
        System.out.println("(%"+ (1.0f - this.kimya.gradeWeight) + ") --Performans Notu : " + this.kimya.performance);
    }

}
