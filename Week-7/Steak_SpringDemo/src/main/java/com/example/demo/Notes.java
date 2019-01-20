package com.example.demo;

public class Notes {
    /* start.spring.io
    - Easily starts up spring
    - Full version is more indepth and customizable (link on the bottom of the page)
    */


    /* from intelliJ
    "New Project -> Spring initilizer"
    - same fields as the start.spring.io
     */


    // Slides: https://zipcoder.github.io/reveal-slides/basic-anotations.html#/1

    /*
    @SpringBootApplication - Combines 3 different annotations into 1 (Enable auto config, ComponentScan, Config)
    (You can use multiple annotations, but stick to 1 kind throughout (ie, SpringBootApplication vs @AutoCongi, @ComponentScane, @Config)

    @Entity - Control for JPA (Java Persistence API)
    - Allows us to define a class that will be mapped to a relational database table
    - Lets JPA know to create a table based on this class

    @ID
    - Marks that field as the unique identifier
    - Typically type: Long in Java
    - But can be changed to whatever you'd like


    @Component - generic annotation
    - Means the class will be picked up during a component scan


    --------IMPORTANT ---------
    The order for the data process:
    BROWSER W/ DATA ->>>>>> Controller -sends to-> Service -gets data from-> Repo

    Then
    Repo -sends back data-> Service -takes data does something-> Controller -receives data, sends back to-> Browser

    The repo sends back a List of Users
    the service takes it and turns it into a jsonString
    then service sends that string to Controller to pretty print back to the browser

    ----------------------------


    @Repository
    - Type of component also discovered by the @ComponentScan
    - Responsible for interacting with the database to collect and store User objects
    ~ If declared as a repository, you can create your own special queries for database access
     -- Like the DAO from the ORM_LITE lab
        Ex:
            @Repository
            public interface UserRepository extends JpaRepository<User, Long> {
                // then can define a method to find all by a specific parameter of User
                // but there are methods that already belong to the JpaRepo class
            }

    @Service
    - Specialized component for bean(used inside another class, component is generic term)
    @Service & @Component are identical in terms of functionality
    - the service class accesses the repository and gets what we need. It does the heavy lifting for
    accessing the repository and manipulating the data (Conversion, etc)


    @Controller
    - For the ex: the browser is accessing the app and the controller takes that input and determines what to do
    - What determines how to send the data to the Service



    @RequestMapping
    - Tells Spring that this path implements some method and returns something
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Defaults to RequestMethod.GET for its verb, but can take any supported by HTTP
     - GET, PUT, POST, DELETE (Main ones)
        - @GetMapping - getting records or something
        - @PutMapping - updating an entity
        - @PostMapping - creating an entity
        - @DeleteMapping - delete an entity


   [ If you have an entity, Spring will create the endpoints automatically ]

    @PathVariable
    // We wrap path pieces with `{}` to mark them as variables.
    // This path will match users/1 or users/328 or any Long value.
    @GetMapping("/users/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
    // The argument was marked with @PathVariabale so the id
    // within the method will be whatever was put into the
    // route by the client. e.g. users/1 will result in id
    // being equal to 1
    return new ResponseEntity<>(userService.findOne(id));


    @RequestBody
    Spring will map a response
    This is passed into the method parameter with the valid class model


    @AutoWired
    tells spring to inject a dependency
    directs to the ONLY repository
    for example:
    the user example~
    autowire one instance of usercontroller, userservice, userrepository
    now when we run that application, it'll only use those first instantiated instances

    @AutoWired
    MyService service;

    -- It'll initialize and declare a new dependency
    can be autowired on the field or the constructor

    and continue to use the SAME instance of that dependency





    */



}
