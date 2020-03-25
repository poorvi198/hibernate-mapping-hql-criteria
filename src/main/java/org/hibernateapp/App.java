package org.hibernateapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernateapp.crud.StudentCRUD;
import org.hibernateapp.crud.StudentCRUDCriteria;
import org.hibernateapp.crud.StudentCRUDHQLImpl;
import org.hibernateapp.entity.Course;
import org.hibernateapp.entity.Instructor;
import org.hibernateapp.entity.Student;
import org.hibernateapp.entity.StudentDetail;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final SessionFactory sessionFactory;
    private static StudentCRUD studentCRUD = new StudentCRUDHQLImpl();
    private static StudentCRUDCriteria criteria = new StudentCRUDCriteria();

    static {

        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetail.class)
                .buildSessionFactory();
    }

    public static void main( String[] args )
    {
        try
        {

            //studentCRUD.createStudent(sessionFactory.getCurrentSession());
            //studentCRUD.createInstructor(sessionFactory.getCurrentSession());
            //studentCRUD.createCourses(sessionFactory.getCurrentSession());
            //studentCRUD.readAllStudent(sessionFactory.getCurrentSession());
            //studentCRUD.updateStudent(sessionFactory.getCurrentSession());
            //studentCRUD.deleteStudent(sessionFactory.getCurrentSession());
            studentCRUD.readStudent(sessionFactory.getCurrentSession());
            //studentCRUDHQLImpl.courseStudent(sessionFactory.getCurrentSession());
            criteria.readStudentAndCourses(sessionFactory.getCurrentSession());
        }
        catch (Exception e)
        {
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }
        finally
        {
            sessionFactory.close();
        }
    }
}
