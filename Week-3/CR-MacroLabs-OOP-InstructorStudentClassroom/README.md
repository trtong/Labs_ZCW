# Leon's Lengthy Learner Lab 
* **Purpose** - to demonstrate the use of [Java interfaces](http://tutorials.jenkov.com/java/interfaces.html#java-interface-example)
* **Objective** - to implement a `ZipCodeWilmington` class which _mediates_ a _composite_ `Students` and `Instructors` _singleton_ reference.

---
### Part 1.0 - Test `Person`
* Create a `PersonTest` class.
	* Create a `testConstructor` method which ensures that a `Person` object's `id` field is being set upon construction. To check if the id has been set, call the `getId()` method of the person class which will return a long
        * Create a `Person` class.
        * In the `Person` class, declare a `final` field named `id` of type `long`.
        * Create a getter for the id field
	* Create a `testSetAndGetName` method which ensures that a `Person` object's `name` variable is being set by invoking the `.setName` method and when you call `getName()` it will return the name you set
        * In the `Person` class, declare a field named `name` of type `String`.
        * The `Person` class should define a `getName()` method which returns the `Person` object's `name` field.
        * The `Person` class should define a `setName()` method which sets the `Person` object's `name` field.

---
### Part 2.0 - Create `Learner` Interface
* Create a `Learner` interface.
	* `Learner` should declare one method signature:
		* Method name: `learn`
		* Method parameters: `double numberOfHours`
		* Method return-type: `void`

---
### Part 3.0 - Test `Student`
* Create a `StudentTest` class.
	* Create a `testImplementation` method that asserts that a `Student` is an `instanceof` a `Learner`.
        * Create a `Student` class
        * `Student` implements the `Learner` interface
        * Add a dummy implementation for the `learn` method
	* Create a `testInheritance` method that asserts that a `Student` is an `instanceof` a `Person`.
        * Make the `Student` class inherit from `Person`
	* Create a `testLearn` method that ensures a `Student`'s `totalStudyTime` instance variable is incremented by the specified `numberOfHours` by invoking the `.learn` method.
        * In the `Student` class, add a field called `totalStudyTime` of type `double`
        * In the `Student` class, implementate the `learn` method which increments the `totalStudyTime` variable by the specified `numberOfHours` argument.`
        * In the `Student` class, add a `getTotalStudyTime()` method which returns the `totalStudyTime` instance variable.

---
### Part 4.0 - Create `Teacher` Interface
* Create a `Teacher` interface.
	* `Teacher` should declare a `teach` method signature:
		* Method name: `teach`
		* Method parameters:
			* `Learner learner`
			* `double numberOfHours`
		* Method return-type: `void` 

	* `Teacher` should declare a `lecture` method signature:
		* Method name: `lecture`
		* Method parameters:
			* `Learner[] learners`
			* `double numberOfHours`
		* Method return-type: `void`

---
### Part 5.0 - Test `Instructor`
* Create a `InstructorTest` class.
	* Create a `testImplementation` method that asserts that an `Instructor` is an `instanceof` a `Teacher`.
        * Create an `Instructor` class such that:
            * `Instructor` implements the `Teacher` interface
            
	* Create a `testInheritance` method that asserts that a `Instructor` is an `instanceof` a `Person`.
        * Make the `Instructor` a subclass of `Person`
	* Create a `testTeach` method that ensures when an `Instructor` invokes the `teach` method, a respective student's `totalStudyTime` instance variable is incremented by the specified `numberOfHours`.
        * In the `Instructor` class, add a concrete implementation of the `teach` method which invokes the `learn` method on the specified `Learner` object.
	* Create a `testLecture` method that ensures when an `Instructor` invokes the `lecture` method, a respective array of students' `totalStudyTime` instance variables is incremented by `numberOfHours/students.length`.
        * `Instructor` should have a concrete implementation of the `lecture` method which invokes the `learn` method on each of the elements in the specified array of `Learner` objects.
            * `numberOfHours` should be evenly split amongst the learners.
                * `double numberOfHoursPerLearner = numberOfHours / learners.length;`

---
### Part 6.0 - Test `People`
* Create a `PeopleTest` class.
* Create a `testAdd` method which ensures that our `personList` in our `People` class populated with respective `Person` objects following invokation of the `add` method.
    * Create a `People` class.
	* The `People` class should instantiate an `ArrayList` field of `Person` objects named `personList`.
	* The `People` class should define a method named `add` which adds a `Person` to the `personList`.
	* The `People` class should define a method named `getCount` which returns the size of `personList`.
* Create a `testRemoveByPerson` method which ensures that the `personList` in a `People` object is **depopulated** with a respective `Person` object following the invokation of the `remove` method.
    * The class should define a method named `remove` which makes use of a `Person person` parameter to remove a respective `Person` object.
* Create a `testRemoveById` method which ensures that the `personList` in a `People` object is **depopulated** with a respective `Person` object following the invokation of the `remove` method.
	* The class should define a method named `remove` which makes use of a `long id` parameter to remove a `Person` object with the respective `id` field.
* Create a `testFindById` method which ensures that a respective `Person` object with a respective `id` field is returned upon invokation of the `findById` method on a respective `People` object.
    * The class should define a method named `findById` which makes use of a `long id` parameter to return a `Person` object with the respective `id` field.
*  Create a `testGetArray` which ensures the array has all the people added
    * In the `People` class, define a method named `getArray` which returns an array representation of the `personList` field.
*  Create a `testRemoveAll` method which ensures you remove all the person added
	* In the `People` class, define a method named `removeAll` which clears our `personList` field.


---
### Part 7.0 - Test `Students` singleton
* **Note:** The creation of the `Students` will demonstrate an implementation of [singleton design pattern](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#eager-initialization).
* Create a `StudentsTest` class.
* Create a `testSingletonInstance` method which ensures that calling `Students.getInstance()` twice will return the same instance. You can check if they are the same instance by calling the `Assert.assertSame(instance1, instance2)` method.
  * Create a `Students` class.
  	* The class should be an _unextendable_ subclass of the `People` class.
  	* The class should _statically instantiate_ a `final` field named `INSTANCE` of type `Students`.
    * The class should define a _private nullary constructor_
  	* The class should define a `getInstance` method which returns the `INSTANCE` field.
* Create a `testInitializationSetupStudents` method which ensures that each of the students in your current cohort are in your `Students` singleton when `getArray` is called.
  * In the constructor of the `Students` class, add all the students from your class so that calling `getArray` will return all the students from your cohort
    * Each student should have a _relatively_ unique `id` field.

---
### Part 8.0 - Create and Test `Instructors` singleton
* Use `Part 7` as a reference.
* Create a `InstructorsTest` class.
* Create a `Instructors` singleton which represents the set of instructors at ZipCodeWilmington.

---
### Part 9.0 - `ZipCodeWilmington`
* Create a `ZipCodeWilmingtonTest` class.
	* Create a `testHostLecture` method which ensures that each of the `Student`'s `totalStudyTime` instance variable is incremented by the specified `numberOfHours` upon invoking the `hostLecture` method.
    * Create a `ZipCodeWilmington` singleton.
    	* The class should declare a field that references the instance of `Students` called `students`.
    	* The class should declare a field that references the instance of `Instructors` called `instructors`.
    	* The class should define a method `hostLecture` which makes use of a `Teacher teacher, double numberOfHours` parameter to host a `lecture` to the composite `people` field in the `students` reference.
    	* The class should define a method `hostLecture` which makes use of a `long id, double numberOfHours` parameter to identify a respective `Instructor` to host a `lecture` to the composite `people` field in the `cohort` reference.

---
# Notice the Design Flaw - Odd Casting Issues
* You may have noticed that the `findById`, and `hostLecture` methods require an intermediate [casting trick](https://stackoverflow.com/questions/5289393/casting-variables-in-java).
* To remedy this issue, we can _generify_ the `People` class.

---
### Part 10.1 - Modify `People` class
* [Parameterize](https://stackoverflow.com/questions/12551674/what-is-meant-by-parameterized-type) the `People` signature to enforce that it is a container for objects of type `E` such that `E` is a subclass of `Person`.
* Modify the class signature to declare this class _abstract_.
	* An [abstract class](http://www.javacoffeebreak.com/faq/faq0084.html) cannot be instantiated; Its concrete implementation is deferred to its subclass.
* Modify `people` field to enforce that is a container of objects of type `E`.
* Modify the `add` method to ensure that it handles object of type `E`.
* Modify the `findById` method to ensure that it returns an object of type `E`.
* Modify the `getArray` method signature by declaring it `abstract` of return type `E`.
	* An abstract method is a subclass's contractual agreement to the deferment of an implementation of a respective method.
* You may need to create an [inner class](https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html) to test make the People class

-
### Part 10.2 - Modify `People` subclasses
* Modify the `Students` class signature to ensure that it is a subclass of `People` of parameterized type `Student`.
* Modify the `Instructors` class signature to ensure that it is a subclass of `People` of parameterized type `Instructor`.
* See if you can modify the `getArray` method in the `People` class to return the generic array back. Otherwise, add concrete implementations of the `getArray` method in each of these classes
    * HINT: To create a new generic array, you can use `E[] array = (E[]) Array.newInstance(Student[].class.getComponentType(), list.size());`. Note in this code, when I call newInstance, I give the Student[].class. Change it so it can be Student[] or Instructor[] or Person[].

-
### Part 10.3 - Refactor `ZipCodeWilmington` class
* Refactor the `hostLecture` method in the `ZipCodeWilmington` class by removing any intermediate _casting trick(s)_.

-
### Part 10.4 - Test refactored classes.
* Ensure that the `StudentsTest`, `InstructorsTest`, `PeopleTest`, `ZipCodeWilmingtonTest` classes were not affected by the refactor.






-
# Notice the Design Flaw - Non-Intuitive Orientation
* You may have noticed that `findById` makes it difficult to intuitively identify _which_ `Person` object is being returned. To remedy this issue, we can make use of an `enum` which manipulates a composite `instructor` object.

-
### Part 11.1 - Create `Educator` enum
* Create an enum named `Educator`.
	* The enum should implement `Teacher`.
	* The enum should have an enumeration for each of the instructors represented in the `Instructors` class.
	* Calls to the `teach` and `lecture` method should be differed to the composite `instructor` reference.
	* The enum should have a `double timeWorked` field which keeps track of the hours that the `Educator` has taught.
* In the constuctor of the `Instructors` class, get all the `Educator` by calling `Educator.values()`, add all the instructor to   Upon construction each enumeration of the enum should instantiate a respective `Instructor` and assign it to a final `instructor` field upon construction. The `instructor` should be added to the `Instructors` singleton.



-
### Part 11.0 - Test `Educator`
* Use `Part 5` as a reference.


-
### Part 12.0 - Test `ZipCodeWilmington`
* Ensure the `hostLecture` method can handle objects of type `Educator`.