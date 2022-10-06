package com.sayilir.coder.service;

import com.sayilir.coder.dataAccess.BaseDao;
import com.sayilir.coder.entities.Course;
import com.sayilir.coder.logging.Logger;

import java.util.List;

public class CourseService {
    private final BaseDao<Course> courseDao;
    private final List<Course> courses;
    private final List<Logger> loggers;

    public CourseService(BaseDao courseDao, List<Course> courses, List<Logger> loggers) {
        this.courseDao = courseDao;
        this.courses = courses;
        this.loggers = loggers;
    }


    public void add(Course course) {
        if (checkCourseName(course)) {
            System.out.println("\nGirilen " + course.getName() + " course ismi tekrar edemez!!!\n");
        } else if (course.getPrice() < 0) {
            System.out.println("\nGirilen " + course.getName() + " course fiyatı: " + course.getPrice() + " Değer sıfırdan büyük olmalıdır!!! \n");
        } else {

            courseDao.save(course);
            courseDao.printAll();
            for (Logger logger : loggers
            ) {
                logger.log(course.getName());
            }

        }
    }

    private boolean checkCourseName(Course course) {
        List<Course> courses = courseDao.getAll();
        for (Course daoCourse : courses
        ) {
            if (daoCourse.getName().equals(course.getName())) return true;
        }
        return false;
    }


}
