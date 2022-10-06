package com.sayilir.coder.bussiness;

import com.sayilir.coder.entities.Course;
import com.sayilir.coder.service.CourseService;

public class CourseManager implements BaseManager<Course> {
    private final CourseService courseService;

    public CourseManager(CourseService courseService) {
        this.courseService = courseService;
    }

    public void add(Course course ) {
        courseService.add(course);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Course course) {

    }
}
