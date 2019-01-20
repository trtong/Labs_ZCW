# Store Lab
* **Purpose** - to understand [HashMap](https://www.youtube.com/watch?v=shs0KM3wKv8), [objects](https://docs.oracle.com/javase/tutorial/java/concepts/object.html) and [data encapsulation](https://en.wikipedia.org/wiki/Data_encapsulation).

* **Objective** - A map/associative array is a data type that allow users to search for a value. The objective of this lab is to understand how to create map and see how we store data affects how its performance.


## Part 1 - Equals & HashCode
By default, every [Java object](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html) has an [equals](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals) and a [hashCode](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode) method. Java uses the object's address to calculate the [hashCode](https://en.wikipedia.org/wiki/Hash_function). By default, two objects are equal if they have the same address. We don't want this. Two objects are equal if they are the same class and have the same values. Your task is to add the `equals` and `hashCode` to the `User` and `Cart` class.

  1. User
    1. Add an `equals` method to the `User` class. The equal method should return true only if the `id` and `name` are the same. It return false otherwise.
    2. Add a `hashCode` method by calling `Objects.hash()` and gives it the `id` and `name` (e.g. `Objects.hash(id, name)`)
  2. Cart
    1. Add an `equals` and `hashCode` methods with IntelliJ shortcut
      1. Click `Command + N` and select `equals and hashCode`. Follow the wizard to generate the code.

## Map
Details instructions on what each method should do and return is in `MyMap` class.

### Part 2 - ListMap
A list map stores every entry in a list. Every time the user calls `put`, create a new `Entry` and add it to the list. Your task is to make all the tests in `test/java/org/zipcoder/store/ListMapTest.java` pass.
  1. Uncomment line 178 - 196. Notice how long the test takes to run.

**BONUS**: Uncomment the remove method and add the code to pass the tests.

### Part 3 - MyHashMap
If you still have no idea what a HashMap is, read this [article](https://medium.com/@nhu313/what-is-a-java-hashmap-83152fb632bb) or watch this [video](https://www.youtube.com/watch?v=shs0KM3wKv8). Notice I add the `bucketIndex` to help you determine where to store the entry. The `bucketIndex` uses the `hashCode` to try to evenly distribute the entries.
  1. `put` - find which bucket it belongs to, then add it to the list of that bucket
  2. `get` - find which bucket it belongs to, then loop through the list to find the entry corresponding to the key
  3. Uncomment line 178 - 196. Notice how fast it takes to run.

**BONUS**: Uncomment the remove method and add the code to pass the tests.

## Performance
Notice how long the ListMap takes to store and find 70,000 items. Notice how much faster a HashMap is. In the `MyHashMap` class, change the `BUCKET_SIZE` to `100`. Run the `MyHashMapTest` again. Notice how much faster it is. That's the power of designing and using a good data structure. It can speed up your program significantly.
