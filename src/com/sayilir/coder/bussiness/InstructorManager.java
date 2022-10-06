package com.sayilir.coder.bussiness;

import com.sayilir.coder.entities.Instructor;
import com.sayilir.coder.service.InstructorService;

public class InstructorManager implements BaseManager<Instructor> {
    private final InstructorService instructorService;

    public InstructorManager(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public void add(Instructor instructor) {
        instructorService.add(instructor);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Instructor instructor) {

    }
}
