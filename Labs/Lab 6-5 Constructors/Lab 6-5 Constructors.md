# Lab 6-5: Constructor


## Lab Objectives

In this lab, we add two constructors to our `Student` class

<br/>
<br/>

## Part 1: Set Up

Either start with your code from the last lab. The class as it was at the end of the last lab is in the folder Lab5-3 Solution.

Which is also here:

```java
package remote;

public class Student {
	     
private String name = "Marcus";
	
	public String getName() {
		return this.name;
	}
	public void printme() {
		System.out.println("Hi! My name - " + this.name);
	}
	private boolean nameValidator(String s) {
		if (s == null) return false;
		if (s == "") return false;
		return true;
	}
	public void setName(String name) {
		if (!this.nameValidator(name)) return;
		this.name = name;
	}
	// Static Section
    public static final int MAX_COUNT = 2;
    private static int count = 0; 
    public static int getCount() {
	    return Student.count;
    }
    public static void incrementCount() {
	    Student.count++;
    }
	
}
```

## Part 2: Add the constructor with a name parameter

The constructor does not return a type and has the same name as the class. Generally, the constructors we want clients to use are the same visibility of the class.  Since `Student` is `public`, we will make the constructor `public` as well. 

Set the `Student.name` instance variable to `null`.

Add the constructor as shown


```java
package remote;

public class Student {
	     
private String name = null;
	
	public Student(String name) { // <-------- Add this
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	/// and so on
}
```
As soon as you add this constructor, the code in the `Runner` class has an error since the constructor `Student()` no longer exists.
- The rule in Java is that if you don't provide any constructors, then Java will add an empty default constructor behind the scenes that looks like `Student(){}`
- As soon as you add _any_ constructor, Java no longer provides this behind the scene default constructor
- The reason for this is that many small classes don't need an explict constructor and making it necessary to code this over and over again is pointless. 
- However, Java needs a constructor to build objects correctly, so this is the compromise made in the language.

Use our new constructor, instead which produced the right result.

```java
public class Runner {

    public static void main(String[] args) {
        Student igor = new Student("Igor");
        igor.printme();
    }
}
```

	
The validator which we used in the `setName()` method should be used here to be consistent.

There are two ways we can do this, we can call it from the constructor directly, or we can call it via the `setter`

```java
	private String name = null;

	public Student(String name) {
		//if(this.nameValidator(name)) this.name = name;
		// or
		this.setName(name);
	}
```

<br/>
<br/>
It may be a domain rule that all students have names. 
- This introduces what we call a domain constraint, a rule about what a valid student object should like.

```java
	public static void main(String[] args) {
		Student igor = new Student("");
		igor.printme();
	}
```
Which gives us an _invalid_ object. 
- We can created it, but it's not quite right from the domain perspective.

There will be two ways we can approach this problem

1. In the exceptions section, we can throw an exception from the constructor that will roll back the creation of the object, including releasing all the memory allocated to it. We will see this in the exceptions section later in the course.

2. It might be that we can create a student object with a placeholder name "TBD" if we don't know the name at the time of creation and will be set later.

We can use the validator for both of these.

So now let's implement the constructor with no arguments and a default name value.

```java
private String name = "TBD";
	
	public Student() {
		
	}

```
It doesn't do anything because there is already a default value. And this works.

```java 
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
		igor.setName("Igor");
	    igor.printme();
	}
```
```console
Hi! My name - TBD
Hi! My name - Anish
Hi! My name - Igor
```

Now let's add that valid indicator

```java 

	private String name = "TBD";
	private boolean isValid = false;
	
	public boolean isValid() { return this.isValid;}
	
	public Student() {
		// creating a student with no name is invalid
		// so leave isvalid as false
	}
```

Thinking ahead we may have a number of validity checks if we add more data like GPA, birthdate, and we want to avoid students with `null` names, or GPAs of 897 or birthdays of January 78th 2323

We will often put a list of these rules, which we technically call specifications into a special method that runs all the checks after all the data has been input.

But for now, we will just use the one validator because we only have one data item. 

The place to do this is in the `setName()` method

```java
	public void setName(String name) {
		this.isValid = this.nameValidator(name);
		this.name = name;
	}
```

Let's also alter the `printme` method to show the validity of the object.

```java
public void printme() {
		System.out.println("Hi! My name - " + this.name +   " " + (this.isValid ? "Valid" : "Invalid"));
	}

```
Now test it

```java
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
		igor.setName("Igor");
	    igor.printme();
	    igor.setName(null);
	    igor.printme();

	}
```
And we get

```console
Hi! My name - TBD Invalid
Hi! My name - Anish Valid
Hi! My name - Igor Valid
Hi! My name - null Invalid
````

<br/>
<br/>

## Part 3: Fix the Static issue

Remember, we had a problem with where to increment the count for the class.

Now we can fix that by having the constructor responsible for doing that.

Start by making the increment function private and call it from the constructor.

To do this, we are going to use a trick where one constructor calls the other, so we don't repeat code.

First, refactor the static method to make it private.

```java
 private static void incrementCount() {
   Student.count++;
	}
```

Now add this call to the constructor with one parameter.
- Because the constructor is a member of the Student class, it can call any private method even if the method is static. Remember, being public or private is about visibility

```java
	public Student(String name) {
		this.setName(name);
		Student.incrementCount();
	}
```

Let's also modify `printme()` to print out the count as well

```java
public void printme() {
		System.out.println("Student #"+Student.getCount() +" Hi! My name - " + this.name +   " " + (this.isValid ? "Valid" : "Invalid"));
	}
```
Instead, initializing `Student.name` to "TBD" the constructor with no arguments will call the constructor with one argument passing null as the name. We really didn't need "TBD" as it turns out.

However, the syntax for one constructor calling another is weird, instead of the constructor name we use `this` as shown here. 
- Java can figure out which constructor by checking the signature (the number of parameters and their types) in the call to `this(...)`

```java

	private String name = null;
	private boolean isValid = false;
	
	public Student() {
		this("");
	}
	public Student(String name) {
		this.setName(name);
		Student.incrementCount();
	}
	
```

Check to make sure it's all working

```java
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
	    Student kyle = new Student("Kyle");
	    kyle.printme();

	}
```
```console
Student #1 Hi! My name -  Invalid
Student #2 Hi! My name - Anish Valid
Student #3 Hi! My name - Kyle Valid
```
---
**The final code is available Solutions Folder**

## End Lab
