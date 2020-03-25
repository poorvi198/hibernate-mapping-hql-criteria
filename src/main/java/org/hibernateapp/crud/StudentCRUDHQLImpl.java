package org.hibernateapp.crud;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernateapp.entity.Course;
import org.hibernateapp.entity.Instructor;
import org.hibernateapp.entity.Student;
import org.hibernateapp.entity.StudentDetail;
import java.util.ArrayList;


public class StudentCRUDHQLImpl implements StudentCRUD {

    public void createStudent(Session session) {
        session.beginTransaction();
        StudentDetail studentDetail = new StudentDetail("bhopal","9876543210");
        Student student = new Student("RN9","romi","manit",studentDetail);
        session.save(student);
        session.getTransaction().commit();
    }

    public void createInstructor(Session session) {
        session.beginTransaction();
        Instructor instructor = new Instructor("David",50000.0);
        session.save(instructor);
        session.getTransaction().commit();
    }

    public void createCourses(Session session)
    {
        session.beginTransaction();
        Instructor instructor = (Instructor) session.get(Instructor.class,1);
        Course course1 = new Course("Spring");
        Course course2 = new Course("hibernate");
        instructor.addCourse(course1);
        instructor.addCourse(course2);
        session.save(course1);
        session.save(course2);
        session.getTransaction().commit();
    }

    public void courseStudent(Session session){
        session.beginTransaction();
        Student student= (Student)session.get(Student.class,1);
        Course course = (Course)session.get(Course.class,1);
        Course course2 = (Course)session.get(Course.class,2);
        course.addStudent(student);
        course2.addStudent(student);
        session.getTransaction().commit();
    }
    public void readAllStudent(Session session) {
        session.beginTransaction();
        Query query = session.createQuery("from Student");
        ArrayList<Student> students = (ArrayList<Student>) query.list();
        System.out.println(students);
        session.getTransaction().commit();
    }

    public void updateStudent(Session session) {
        session.beginTransaction();
        Query query = session.createQuery("update Student set name='rishabh' , rollno='RN12' where id = 10");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void deleteStudent(Session session) {
        session.beginTransaction();
        Student student = (Student) session.get(Student.class,11);
        session.delete(student);
        session.getTransaction().commit();
    }

    public void readStudent(Session session) {
        session.beginTransaction();
        Student student = (Student) session.get(Student.class,10);
        System.out.println(student);
        session.getTransaction().commit();
    }
}
