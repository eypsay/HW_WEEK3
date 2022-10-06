package com.sayilir.coder.dataAccess;

import com.sayilir.coder.entities.Category;
import com.sayilir.coder.entities.Instructor;

import java.util.List;

public class HibernateInstructor implements  BaseDao<Instructor> {
    private final List<Instructor> instructors  ;

    public HibernateInstructor(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public void save(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Saved " + instructor.getName() +" instructor into Hibernate." );
    }

    @Override
    public List<Instructor> getAll() {
        return instructors;
    }

    @Override
    public void printAll() {
        System.out.println("***All instructors*** \n -----------------");
        for (Instructor instructor:instructors
        ) {
            System.out.println(instructor.getName());
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Instructor update(int id, Instructor instructor) {
        return null;
    }
}
