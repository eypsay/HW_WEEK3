package com.sayilir.coder.service;

import com.sayilir.coder.dataAccess.BaseDao;
import com.sayilir.coder.entities.Instructor;
import com.sayilir.coder.logging.Logger;

import java.util.List;

public class InstructorService {
    private final BaseDao<Instructor> instructorDao;
    private final List<Instructor> instructors;
    private final List<Logger> loggers;

    public InstructorService(BaseDao instructorDao, List<Instructor> instructors, List<Logger> loggers) {
        this.instructorDao = instructorDao;
        this.instructors = instructors;
        this.loggers = loggers;
    }


    public void add(Instructor instructor) {
        if (checkInstructorName(instructor)) {
            System.out.println("\nGirilen " + instructor.getName() + " Instructor ismi tekrar edemez!!!\n");
        } else {
            instructorDao.save(instructor);
            instructorDao.printAll();
            for (Logger logger : loggers
            ) {
                logger.log(instructor.getName());
            }

        }
    }


    private boolean checkInstructorName(Instructor instructor) {
        List<Instructor> categories = instructorDao.getAll();
        for (Instructor daoInstructor : categories
        ) {
            if (daoInstructor.getName().equals(instructor.getName())) return true;
        }
        return false;
    }
}
