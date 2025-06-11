# Lab 3-1: Operators


## Lab Objectives

This lab explores some of the Java operators. For this lab, all you need to do is create a project with a single `Runner` class with a `main()` method. We won't be using any classes since we are just doing some procedural code.


---
<br/>
<br/>

## Part 1: Basic Operations

Create a Java Class to perform basic arithmetic. The code is in the Solutions folder.

```java 
public class Runner {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));  // Integer division
        System.out.println("Modulus: " + (a % b));

        // Assignment
        a += 5;
        System.out.println("Updated a (a += 5): " + a);
    }
}

```

Experiment with different data types for `a` and `b` to see how mixed mode arithmetic
- Try with `a` as a float and `b` as an int
- Try with `a` as an int and `b` as a float
- Try with both as a float shown below

```java
float a = 10.0F;
float b = 3.0F;
```

With both floats, you should see output like this

```console
Addition: 13.0
Subtraction: 7.0
Multiplication: 30.0
Division: 3.3333333
Modulus: 1.0
Updated a (a += 5): 15.0
```

## Part 2: Logical Operators

Replace the previous code with the code from the `RelationalLogicLab` in the Solutions folder as shown

```java
public class Runner {
    public static void main(String[] args) {
        int x = 8, y = 12;

        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));

        // Logical
        boolean result = (x > 5 && y < 15);
        System.out.println("x > 5 && y < 15: " + result);
    }
}

```
 Experiment with different values and numeric types

## Part 3: Floating Point Operations

Experiment with division by zero with integers. No mater what the numerator is, if the denominator is `0` we get a divide by zero error because it is integer division

Replace the main method in the last lab with this one

```java
	public static void main(String[] args) {
		System.out.println(1/0);
	}
```

Produces

```console
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Runner.main(Runner.java:5)
```

Now try the same with floating point numbers.

```java
	public static void main(String[] args) {
		System.out.println(1.0/0.0);
		System.out.println(-1.0/0.0);
		System.out.println(0.0/0.0);
	}
```
Produces

```console
Infinity
-Infinity
NaN
```
<br/>

Explain what is happening in this code and why the final result is _not_ `.9999999`
- Hint: This has to do with the rounding of the result of the multiplication.
- Notice that we are dividing 1.0 by 9 and then multiplying it by nine.
  - Using fractions, this is 1/9 * 9 -> 1

```java
	public static void main(String[] args) {
		double r = (1.0/9);
        double s = r * 9;
	    System.out.printf("%10.8f\n", r);
	    System.out.printf("%10.8f\n", s);
    System.out.println("(r == s) is " + (r == s));
	}
```
```console
0.11111111
1.00000000
r == s is false
```

<br/>
<br/>

## Part 4: Mixed Mode Arithmetic

Explain the following result:

```java
	public static void main(String[] args) {
		System.out.println(0.0/(int) 0.09);
		System.out.println(Math.cos(45)/0);
	}
```
Produces

```console
NaN
Infinity
```

How would you fix the error in this code? Hint: there are multiple solutions.

```java
	public static void main(String[] args) {
		int i = 1;
		long j = 3L;
		int k = i + j;
	}

```
---

## Part 4: Increment operator

Now use the ecode from the `UnaryLab` from the Solutions folder

```java
public class Runner {
    public static void main(String[] args) {
        int a = 5;
        int pre = ++a; // increment a then assigne
        a = 5;         // reset a
        int post = a++; // assign a then increment
        System.out.println("post-increment: " + post);
        System.out.println("pre-increment:: " + pre);
    }
}

```

In the above code:
- `a` is set to 5
- `++a` sets `a` to 6 before assigning it to `pre`
- `a` is reset to 5
- `a++` assigns 5 to `post` the sets `a` to 6


## Part 5: Casting

Replace the code with the `CastingLab` code as shown

```java
public class Runner {
    public static void main(String[] args) {
        int a = 2;
        double b = 4.8;

        System.out.println("a + b = " + (a + b)); // implicit promotion
        System.out.println("a + (int)b = " + (a + (int)b));
        System.out.println("(int)(a + b) = " + (int)(a + b));
    }
}
```

Run the code and explain the results.

```console
a + b = 6.8
a + (int)b = 6
(int)(a + b) = 6
```

## End Lab
