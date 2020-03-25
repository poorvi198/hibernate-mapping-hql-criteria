package org.hibernateapp.crud;

import org.hibernate.Session;

public interface StudentCRUD {

    void createStudent(Session session);

    void createInstructor(Session session);

    void createCourses(Session session);

    void courseStudent(Session session);

    void readAllStudent(Session session);

    void updateStudent(Session session);

    void deleteStudent(Session session);

    void readStudent(Session session);
}
