package com.example.demo;

import java.util.stream.StreamSupport;

public class Instructor extends Person implements Teacher {

    public Instructor(long id, String name) {
        super(id, name);
    }

    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        for (Learner l : learners) {
            teach(l, numberOfHours/(StreamSupport.stream(learners.spliterator(), false).count()) /*What to put here??*/);
        }
    }
}
