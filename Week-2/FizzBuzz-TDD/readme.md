## Objectives

1. Understand test driven development process

# What is Test Driven Development?

Test Driven Development, or TDD, is a method for approaching a problem not through the implementation of the solution, but rather, through the expectations of a working solution. What that means is, instead of trying to write the code that solves the problem, you first define what the working code will do when it works, and then you write the implementation to make it work.

# Test Driving FizzBuzz

A classic programming problem is [FizzBuzz](http://c2.com/cgi/wiki?FizzBuzzTest). It is considered the [Stairway to Heaven](http://www.codinghorror.com/blog/2007/02/fizzbuzz-the-programmers-stairway-to-heaven.html) of programming because there are so many different ways to play it and everyone plays it.

The goal of FizzBuzz is to build a program that can take a number:
- if the number is evenly divisible by 3, it should return "Fizz"
- if it's divisible by 5, it should return "Buzz"
- if it's divisible by both 3 and 5, it should return "FizzBuzz"
- otherwise it should print the number

## Defining Our Expectations

Let's approach solving this problem from a TDD approach. That means that we don't care about "how", but rather, we care about "what". What should the program do if it works correctly, not how it does it. We are going to write our expectations first, then our implementation.

Before we look at the RSpec syntax, let's just express our tests in plain English (also sometimes referred to as "pseudo-code").

1. We expect FizzBuzz.of(3) to return "Fizz"
2. We expect FizzBuzz.of(5) to return "Buzz"
3. We expect FizzBuzz.of(15) to return "FizzBuzz"
4. Anything else will return the number FizzBuzz.of(2) returns "2"

We don't care how that `#fizzbuzz` method works, nor how it's defined, *we are just stating our expectations*. And we're doing that first. When coding, it's important to have a target to shoot for; by writing your test first and stating your expectations of your code, you know your goal. You get to use your entire brain to think about just your goals, not how you'll get there, which adds clarity and focus to the problem.

> The competent programmer is fully aware of the strictly limited size of his own skull; therefore he approaches the programming task in full humility.
>
> — <cite>Edsger W. Dijkstra</cite>

Test-Driven Development allows us to fully utilize our mental capacity to clearly state the problem we're solving and then to 100% focus on implementing a solution. When you are just coding, you're actually focusing on stating the problem and the solution at the same time. You are thereby splitting your thinking in two, making you less effective at both.

> It's the exact same reason you make a todo list. Also testing is not for present you, it's for future you.
>
> — <cite>Joe M Burgess</cite>

# Instruction
Given a number, your method should return a string:
- "Fizz" if it's divisible by 3
- "Buzz" if it's divisible by 5
- "FizzBuzz" if it's divisible by 15
- the number in string format otherwise

## Todo
1. For this repo
2. Clone your fork
3. Solve the problem using TDD
4. Create a pull request
