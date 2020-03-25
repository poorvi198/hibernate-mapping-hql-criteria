package org.hibernateapp.crud;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernateapp.entity.Student;
import java.util.Arrays;
import java.util.List;
public class StudentCRUDCriteria {

    public void readAllStudent(Session session){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> studentList = criteria.list();
        System.out.println(studentList);
        session.getTransaction().commit();
    }

    public void readStudent(Session session)
    {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("RollNo","RN9"));
        Student student = (Student) criteria.uniqueResult();
        System.out.println(student);
        session.getTransaction().commit();
    }

    public void readStudentAndCourses(Session session)
    {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Student.class,"student")
                .setFetchMode("student.courses", FetchMode.JOIN)
                .createAlias("student.courses","courses");
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("name"))
                .add(Projections.property("courses.title"));

        criteria.setProjection(projectionList);

        List<Object[]> list= criteria.list();
        for(Object[] arr:list){
            System.out.println(Arrays.toString(arr));
        }
    }
}
