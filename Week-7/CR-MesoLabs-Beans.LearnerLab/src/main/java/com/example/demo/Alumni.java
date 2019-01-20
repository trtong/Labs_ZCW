package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {

    private final Students previousStudents;
    private final Instructors instructors;

    public Alumni(@Autowired Students previousStudents, @Autowired Instructors instructors) {
        this.previousStudents = previousStudents;
        this.instructors = instructors;
    }

    @PostConstruct
    public void executeBootCamp() {
        int numbOfInstructors = instructors.size();
        double TOTAL_NUMBER_OF_HOURS = 1200;
        double numberOfHoursPerInstructor = TOTAL_NUMBER_OF_HOURS/numbOfInstructors;

        for (Instructor i: instructors) {
            i.lecture(previousStudents, numberOfHoursPerInstructor);
        }

    }

    public Students getPreviousStudents() {
        return previousStudents;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}
