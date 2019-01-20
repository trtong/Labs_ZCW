package io.zipcoder.interfaces;

public enum Educator implements Teacher {

    KRIS(100, "Kristofer Younger"),
    FROILAN (101, "Froilan Miranda"),
    DOLIO (102, "L. Dolio Durant"),
    LEON (103, "Leon Hunter"),
    NHU (104, "Nhu Nguyen"),
    DOMINIQUE (105, "Dominique Clarke"),
    WILHEM (106, "Wilhem Alcivar");

    private double timeWorked;
    private long id;
    private String name;
    private final Instructor instructor;

    Educator(long id, String name) {
        this.id = id;
        this.name = name;
        timeWorked = 0;

        this.instructor = new Instructor(id, name);

        Instructors instructors = Instructors.getInstance();
        instructors.add(this.instructor);
    }

    public double getTimeWorked() {
        return timeWorked;
    }

    public void teach(Learner learner, double numberOfHours) {

        learner.learn(numberOfHours);
        timeWorked += numberOfHours;

    }

    public void lecture(Learner[] learners, double numberOfHours) {

        for (Learner l : learners) {
            teach(l, numberOfHours/learners.length);
        }
    }
}
