package io.zipcoder.interfaces;

public class Instructor extends Person implements Teacher {

    public Instructor(long id, String name) {
        super(id, name);
    }

    public void lecture(Learner[] learners, double numberOfHours) {

        for (Learner l : learners) {
            teach(l, numberOfHours/learners.length);
        }

    }

    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

}
