# Lab 2-2: Variable Types


## Lab Objectives

Compares the use of different storage classes for Java variables, and their scope

---
<br/>
<br/>

## Part 1: Automatic Extent

Create a java project with a single class, in the demos this was called `Runner`, with a `main()` method. All of your work will be done in the main method.

Create a new lexical scope by adding a couple of {}.  The following code defines two integer variables. The first, `i1` has the lexical scope of the body of the `main()` method since those are the {} that enclose it directly

The second variable, `i2` has the lexical scope you defined since those are the {} that enclose it directly. Notice that `i1` is still defined since your {} scope is nested in the scope of `i1`

Your code should look like this

```java 
	public static void main(String[] args) {
		int i1 = 89;
		
		{ // Define a new scope
			int i2 = -112;
			System.out.println("Inner scope i1 " + i1);
			System.out.println("Inner scope i2 " + i2);
		} // end defined scope
		
		System.out.println("Outer scope i1 " + i1);
		//System.out.println("Outer scope  i2" + i2); // out of scope
	}
```

As soon as the flow of control passes through the closing } for the defined scope, `i2` is no longer in scope and automatically destroyed.

---

<br/>
<br/>

## Part 2: Static Extent and Scope

Create a class called `Runner` with a `main()` method as in past labs.
- Remember that it has to be declared in a file with the name `Runner.java`

Define a new class `Params` which will have a static variable `cpus`.

**Do not make the `Params` class pubic**

Make the variable `public` (we will discuss why later in the course) and initialize it using a static initialization block as shown.

```java
class Params {
	public static int cpus;
	
	static {
		Params.cpus = 42;
	}

}
```

Reference this variable in the main method of the `Runner` class. Notice that it is in lexical scope of the `main()` method only if the `Params` class can be seen.
- In this case, both classes are in the same package (more about packages later)
- `Params.cpus` exists because it has a static extent which means that it is created and initialized as soon and the JVM starts
- The `static` block in the `Params` class initializes the variable when it is created.

Later we will see an example using packages where the `main()` method can't see the static variable.

All the code should look like this

```java
public class Runner {

	public static void main(String[] args) {
		System.out.println(Params.cpus);
	}
}

class Params {
    public static int cpus;

    static {
        Params.cpus = 42;
    }

}
```

#### Some variations to try:

Instead of the static block, it is more common to just initialize static variables as follows:


```java
class Params {
    public static int cpus = 42;

}
```

The advantage to a static block is that we can compute the initial value of a static variable, which we can't do with a straight assignment. 
- The JVM looks for `static` blocks and executes them while loading the class.
- We are limited in types of operations we cn perform in a `static` block

Make the replacement in your code and run the code.

Now try with these this variation.

```java
class Params {
    public static int cpus;

    static {
        Params.cpus = 42 - 13;
    }

}

```

And this one that uses the default zero value


```java
class Params {
    public static int cpus;
}
```

Note that you cannot use default values for automatic variables; they MUST be initialized explicitly before using them

It will be left as an exercise for you to try to confirm that automatic variables must be initialized.

---
<br/>
<br/>

## Part 3: Final variables

Now change your code as described below to print out the value of the static variable.


```java
public class Runner {

    public static void main(String[] args) {
        Params.cpus = -134;
        System.out.println(Params.cpus);
    }
}

class Params {
    public static int cpus = 34;
    
}
```

Now make the variable final like this:

```java
public class Runner {

    public static void main(String[] args) {
        Params.cpus = -134;
        System.out.println(Params.cpus);
    }
}

class Params {
    public final static int cpus = 34;
    
}
```

This will produce a compiler error telling you that you can't change the value of a final variable.

A common use of final static variables is to declare constants that we want to be immutable,
in this case we often use all caps for the variable name with words separated by underscores
so it can be recognized as a constant 
- When use write a variable name in the form `THIS_IS_A_CONSTANT`, is is referred to as "screaming snake case"


```java
public class MyMath {
    public static final float PI = 3.14159F; 
}

```

---

##  End Lab

