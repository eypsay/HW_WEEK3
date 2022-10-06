package com.sayilir.coder.dataAccess;

import com.sayilir.coder.entities.Category;
import com.sayilir.coder.entities.Course;

import java.util.List;

public class JDBCCourse implements BaseDao<Course>{
    private final List<Course> courses  ;

    public JDBCCourse(List<Course> courses) {
        this.courses = courses;
    }


    @Override
    public void save(Course course) {
        courses.add(course);
        System.out.println("Saved " + course.getName() +" course into JDBC." );
    }

    @Override
    public List<Course> getAll() {
        return courses;
    }

    @Override
    public void printAll() {
        System.out.println("***All Courses*** \n -----------------");
        for (Course course:courses
        ) {
            System.out.println(course.getName());
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course update(int id, Course course) {
        return null;
    }
}
