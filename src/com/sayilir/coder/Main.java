package com.sayilir.coder;

import com.sayilir.coder.bussiness.CategoryManager;
import com.sayilir.coder.bussiness.CourseManager;
import com.sayilir.coder.bussiness.InstructorManager;
import com.sayilir.coder.dataAccess.*;
import com.sayilir.coder.entities.Category;
import com.sayilir.coder.entities.Course;
import com.sayilir.coder.entities.Instructor;
import com.sayilir.coder.logging.DatabaseLogger;
import com.sayilir.coder.logging.Logger;
import com.sayilir.coder.logging.MailLogger;
import com.sayilir.coder.service.CategoryService;
import com.sayilir.coder.service.CourseService;
import com.sayilir.coder.service.InstructorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // INITIALIZATION
        List<Category> categories = new ArrayList<Category>();
        List<Course> courses = new ArrayList<Course>();
        List<Instructor> instructors = new ArrayList<Instructor>();
        List<Logger> loggers = Arrays.asList(
                new DatabaseLogger(), new MailLogger()
        );


        BaseDao<Category> hibernateCategory = new HibernateCategory(categories);
        BaseDao<Category> jdbcCategory = new JDBCCategory(categories);

        BaseDao<Course> hibernateCourse = new HibernateCourse(courses);
        BaseDao<Course> jdbcCourse = new JDBCCourse(courses);

        BaseDao<Instructor> hibernateInstructor = new HibernateInstructor(instructors);
        BaseDao<Instructor> jdbcInstructor = new JDBCInstructor(instructors);


        Category programlama = new Category(1, "programlama");
        Category database = new Category(2, "database");
        categories.add(programlama);
        categories.add(database);
        Category ml = new Category(3, "Machine Learning");

        Course java = new Course(1, "Java", 100);
        Course csharp = new Course(2, "C#", 75);
        courses.add(java);
        courses.add(csharp);
        Course python = new Course(3, "Python", -1);

        Instructor eyup = new Instructor(1, "Eyyup");
        Instructor engin = new Instructor(2, "Engin");
        instructors.add(eyup);
        instructors.add(engin);
        Instructor semra = new Instructor(3, "semra");


        CategoryService categoryService = new CategoryService(jdbcCategory, categories, loggers);
        CategoryManager categoryManager = new CategoryManager(categoryService);
        categoryManager.add(programlama);
        categoryManager.delete(1);
        categoryManager.update(1,new Category(11,"deneme"));


        CourseService courseService = new CourseService(hibernateCourse, courses, loggers);
        CourseManager courseManager = new CourseManager(courseService);
        courseManager.add(python);

        InstructorService instructorService = new InstructorService(jdbcInstructor, instructors, loggers);
        InstructorManager instructorManager = new InstructorManager(instructorService);
        instructorManager.add(eyup);




    }
}
