# Lab 3-2: Flow Control

L
---
## Lab Objectives

This lab explores the basic flow control statements

Solutions are provided in the 'lab 3-2 Solutions' folder.

---
<br/>
<br/>

## Part 1: Problem Statement

Write a for loop that sums up the square of the even numbers between 1 and 20 inclusive. 

Then add a condition that halts the loop as soon as the sum is greater than 30.

### Part 2: Setup

- Create a runner class that you can work in that looks like this

```java
public class Runner {
    public static void main(String[] args) {

    }
}
```


### Part 3: For Loop

- First write the `for` loop to iterate over the numbers from 1 to 20 and print out each iteration so that you can see the loop works


```java
public class Runner {
    public static void main(String[] args) {
        for (int i =1 ; i <= 20; i++ ) {
            System.out.println(i);
        }
        // System.out.println(i); // i only exists in the loop

    }
}
```

Since we want to print out the sum, we have to use a variable `sum` defined outside the loop. If we try to define it inside the loop, it won't exist after the loop finishes

```java
public class Runner {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =1 ; i <= 20; i++ ) {
            sum = sum + i;
        }
        System.out.println(sum); 
    }
}
```

Each time through the loop, you have to check to see if the number is even. The following test will do that by seeing if there is a non-zero remainder on division by 2 and then skip that iteration if there is a non-zero remainder


```java
	if (0 != i % 2) continue;
```

Add a print statement to ensure only the even numbers are being added.

```java
public class Runner {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =1 ; i <= 20; i++ ) {
            if (0 != i % 2) continue;
            System.out.println(i);
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
```

Ihe number is even, add the square to the sum by adding the square instead of the number. 
- This code uses the more compact form `sum += (i * i);`

```java
public class Runner {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =1 ; i <= 20; i++ ) {
            if (0 != i % 2) continue;
            System.out.println(i);
            sum += (i * i);
        }
        System.out.println(sum);
    }
}
```

Check the condition for termination `if (sum > 30) break;` 
- Print out the sum on each iteration to make sure it is working

```java
public class Runner {
    public static void main(String[] args) {
        int sum = 0;
        for (int i =1 ; i <= 20; i++ ) {
            if (0 != i % 2) continue;
            System.out.println(sum);
            if (sum > 30) break;
            sum += (i * i);
        }
        System.out.println(sum);
    }
}

```


## Part 4: The while loop

As a bit of a challenge, rewrite what you just did as a `while` loop
- Hint: the test condition on the `while` statement should be: `sum < 30`
- The solution is in the Solution directory


## Part 5: Conditionals

This section requires you to write code from scratch. 
- You should be able to do this by now
- If you are struggling, consult the solution in the solutions folder

Write an if-else-if block that prints the name of the day based on a number between 1 and 5 (just the work week from Monday to Friday)
- Test it with different values
- Remember to test for invalid inputs

The solution is in Solutions folder

## Part 6: Switch Statement

Convert the conditional code you just wrote into a switch statement

The solution is in Solutions folder

## End Lab
