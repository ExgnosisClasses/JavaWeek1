# Lab 6-2: Visibility


## Lab Objectives

This lab explores how visibility works with Java classes. Save your code after the lab since you will be using it in the next lab too.

---
<br/>
<br/>

## Part 1: Different Packages

Create a `lab6` package. In that package, create a `Runner` class with a `main()` method.

Create a new package at the same level as the `lab6` package called `remote` and create a class in that package called `Student` with a `public` String instance variable called `name` that is initialized to whatever you want.

```java
package remote;

public class Student {
	public String name = "Marcus";
}
```
In the `main()` method in the `Runner`, create a student object and print out the name as shown here.
- If the IDE doesn't do it automatically, you will need to import the class.
- If you don't import the class, the Java compiler doesn't know where to find it

```java
package lab6;

import remote.Student;

public class Runner {
    public static void main(String[] args) {
        Student flamel = new Student();
        System.out.println(flamel.name);
    }
}
```
Now change the name variable in the `Student` class to `package` which means no modifier as shown here.

```java
public class Student {
	String name = "Marcus";
}
```

As soon as you save this change, there will be an error in the `Runner` class saying that the `Student.name` field is not visible.
- This is because the `Runner` class and `Student` class are in different packages and the `name` variable is only visible to other classes in the same package.
<br/>
<br/>

## Part 2: Same Package
Create a new `Student` class in the `lab6` package exactly like the one in the `remote` package. Make sure this class is _not_ `public`.

Remove the import from the `Runner` class file that accesses the `Student` class in the `remote`
package.

Your new `Student` looks like this

```java
package lab6;

class Student {
	String name = "Igor";
}
```
Your `Runner` class should look like this.

```java
package lab6;

public class Runner {

	public static void main(String[] args) {
		Student igor = new Student();
		System.out.println(igor.name);
	}
}
```
Because the two classes are in the same package. if you change the visibility of `Student.name` from `package` to `public`, nothing happens because `public` is also automatically `package`.

However, if you change the visibility to `private` then `Student.name` cannot be accessed anywhere except in the `Student` class definition.

```java
class Student {
	private String name = "Igor";
}
```
---

## End Lab
