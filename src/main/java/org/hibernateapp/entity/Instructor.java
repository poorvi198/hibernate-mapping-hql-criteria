package org.hibernateapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(mappedBy = "instructor",
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor(String name, Double salary) {
        this.name = name;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course)
    {
        if(courses == null)
        {
            courses = new ArrayList<Course>();
        }

        courses.add(course);
        course.setInstructor(this);
    }
}
