package org.hibernateapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="rollno")
    private String rollno;

    @Column(name = "name")
    private String name;

    @Column(name = "university")
    private String university;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_detail_id")
    private StudentDetail studentDetail;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Student() {
    }

    public Student(String rollno, String name, String university, StudentDetail studentDetail) {
        this.rollno = rollno;
        this.name = name;
        this.university = university;
        this.studentDetail = studentDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollno='" + rollno + '\'' +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", studentDetail=" + studentDetail +
                '}';
    }
}
