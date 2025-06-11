# Lab 6-1: Objects

---

## Lab Objectives

In this lab, you will work with instances of a class, also called objects

---
<br/>
<br/>


### _Step 1 - Heap Variables_

Create a `Runner` class with a main method just like we have been doing so far.

In the same file, create a `Student` class. There doesn't need to be anything in the class, we just want to declare a user defined type.

```java
public class Runner {
	public static void main(String[] args) {
	}
}

class Student {}
```

In the `main()` method, create two student objects and print them out. Java has no idea how to print out a `Student` object so it just prints out the address of the object on the heap instead.

```java
public static void main(String[] args) {
		
		Student plato = new Student();
		System.out.println("Plato is at " + plato);
		Student euclid = new Student();
		System.out.println("Euclid is at " + euclid);
	}
```
Which should produce output that looks similar to this:

```console 
Plato is at Student@4517d9a3
Euclid is at Student@372f7a8d
```
The output consists of the type of the object plus the memory location of the object on the heap.

Notice that the variables `plato` and `euclid` are automatic variables on the stack that contain the addresses of the corresponding objects on the heap.

The objects on the heap will exist until they can no longer be referenced.

### _Step 2 - Going out of scope_

Continuing from the code you have from part 1, you can delete the code relating to the variable `euclid`.

Add a new variable scope with a set of braces {} as shown.

Define a `Student` variable `pythagoras` at the start of the main method initialized to `null`. This variable _can_ point to a `Student` object but doesn't point to anything yet.

```java 
	public static void main(String[] args) {
		
		Student pythagoras = null;
		{
		}
	}
}
```
 Inside the scope you created, create the `plato` student like you did before. Assign `plato` to  `pythagoras` and then print out addresses. They should be the same because the assignment statement copied the contents of `plato` (the address below) to `pythagoras`.

 ```java
 
 public static void main(String[] args) {
		
		Student pythagoras = null;
		{
			Student plato = new Student();
			pythagoras = plato;
			System.out.println("Address of plato = " +  plato);
			System.out.println("Address of pythagoras = " +  pythagoras);
		}
	}
 ```

Which should look something like this:

```console
Address of plato = Student@4517d9a3
Address of pythagoras = Student@4517d9a3
```

The object `Student@4517d9a3` now has a reference count of 2 since there are two variables that know the memory address.

Outside the scope block, the variable `plato` is destroyed and can no longer be used.  
- However `pythagorus` still has the location so Java decrements the reference count of `Student@4517d9a3` to 1.

```java
public static void main(String[] args) {
		
		Student pythagoras = null;
		{
			Student plato = new Student();
			pythagoras = plato;
			System.out.println("Address of plato = " +  plato);
			System.out.println("Address of pythagoras = " +  pythagoras);
			
		}
		// plato is out of scope
		//System.out.println("Address of plato = " +  plato);
		System.out.println("Address of pythagoras = " +  pythagoras);
	}
```

Once the `main()` method exits, then `pythagoras` also goes out of scope, the reference count of `Student@4517d9a3` goes to zero and Java marks the object as no longer in use. The actual memory is reclaimed the next time the garbage collector runs.

---

## Null Pointer Exception

Create as String variable and set it to null.
- Call the `length()` method on your variable
- This method returns the length of a string
- But this method is not defined for `null`, which results in a null pointer exceptions

```java
public class Runner {
    public static void main(String[] args) {
        String text = null;  // text is not pointing to any object

        // Try to call a method on a null reference
        System.out.println("Length: " + text.length());  // 💥 This will throw NullPointerException
    }
}
```

Java does not flag this as an error because it doesn't know at compile time if you are going to assign a value to `text` later in the code.
- It only realized that `text` is `null` when it tries to access it producing.

```console
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "text" is null
	at Runner.main(Runner.java:10)
```

##  End Lab

