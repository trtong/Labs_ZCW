# Kris-Tof Dice Toss

Create a `Dice` class that acts like a set of N random-tossed dies.
```
Dice dice = new Dice(2); // for craps
Dice dice = new Dice(5); // for yatzee

Integer toss = dice.tossAndSum();
```
make a couple unit tests for the Dice class. 

Create a tracking class `Bins` that can be used to track the results of dice tosses.

```
Bins results = new Bins(2, 12); // for bins from 2..12
Integer numberOfTens = results.getBin(10); // returns the number of tens in the 10 bin
results.incrementBin(10); // should increment bin # 10

```
make a couple unit tests for the Bins class. Your test methods should follow this template:

    in the tests
    Create a new Bin
    increment a bin some number of times in a for loop, say `max = 100;` times,
    then get the Bin value,
    compare the Bin value to `max`, they should be equal.
    
    

Create a `Simulation` class whose Constructor takes arguments:
    numberOfDies to throw
    numberOfTosses to run

Create a simulation where two dies are thrown *one million times*. 
Keep track of each roll by incrementing the correct Bin.

```
Simulation sim = new Simulation(2, 10000);

sim.runSimulation();

sim.printResults();
```

You can use a main() to run the simulations.

In your pull requests, create a new file with your unique name as the filename.
Paul's would be PaulResults.md

Paste a copy of your text results into that file and then submit your pull request.

the results of the sim.printResults() should be an output string that looks like this:

```
***
Simulation of 2 dice tossed for 1000000 times.
***

 2 :    27917: 0.03 **
 3 :    55422: 0.06 *****
 4 :    83457: 0.08 ********
 5 :   110961: 0.11 ***********
 6 :   139098: 0.14 *************
 7 :   166977: 0.17 ****************
 8 :   138386: 0.14 *************
 9 :   111102: 0.11 ***********
10 :    83367: 0.08 ********
11 :    55799: 0.06 *****
12 :    27514: 0.03 **
```

Since this is using random when running, your numbers for each Bin may vary.
