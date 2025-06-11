# Lab 7-5: The Object Class  

---

## Lab Objectives

This lab introduces Object Class

---
<br/>
<br/>

## Part 1: The Object Class

All classes in Java are subclasses of the `Object` class.  For example, the following is a definition for a person class where we explicitly state that `Object` is the superclass

You can, but don't have to, explicitly extend the Object class; it is always done invisibly and automatically

```java 
class person {  // the extends object is implied
    
	 private String name;
	 private int age;
	 
	 public String getName() {
		return name;
	}
	public int getAge() {
		return this.age;
	}
	public Person(String name, int age) {
		super();  //this is the constructor for the Object class.
		this.name = name;
		this.age = age;
	}

 }
```
The Object class provides a set of methods we can override. Because of inheritance, we can be sure that all of these methods are defined.  
- We can see this by invoking a couple of the `Object` methods and see their default implementation. 
- In particular, notice that the `toString()` method prints out the address of the object.

Test this with the following code

```java
	public static void main(String[] args) {
		Person [] people = { new Person("Raj", 42), new Person("Hani", 29), new Person("Raj",42)};
		for (Person person : people) {
			System.out.println("Hashcode = " + person.hashCode());
			System.out.println(person.toString());
		}
	}
```

```console
Hashcode = 1933863327
obj.Person@7344699f
Hashcode = 112810359
obj.Person@6b95977
Hashcode = 2124308362
obj.Person@7e9e5f8a
```

Override the default implementations as shown below.
- We typically don't use the `@Override` annotation when override `Object` methods

```java
	public String toString() {
		return "My name is " + this.getName() + " and I am " + this.getAge() + " years old";
	}
```

Running the code produces:

```console
Hashcode = 1933863327
My name is Raj and I am 42 years old
Hashcode = 112810359
My name is Hani and I am 29 years old
Hashcode = 2124308362
My name is Raj and I am 42 years old

```
<br/>
<br/>

## Part 2: Overriding methods

Previously, we mentioned the issues of whether two Java objects represented the same real world object. 
- The `equals()` method allows us to override the default behavior based on comparing addresses. 
- We define what it means for two `Person` objects to be equal.
- With real world domain objects, equality is in the eye of the beholder.

In this lab, we can say that the two `Person` objects represent the same person in the real world if they have the same `name` and `age`.

We can also use `clone()` to make a deep copy.

Write the code to override the `clone()` method as shown here

```java
	public boolean equals(Person otherGuy) {
		if (this.getName() != otherGuy.getName()) return false;
		if (this.getAge() != otherGuy.getAge()) return false;
		return true;	
	}

    public Person clone() {
		return new Person(this.getName(),this.getAge());
	}
```

Test it by cloning an object and see if it's the same as the original

```java
	public static void main(String[] args) {
		Person raj = new Person("Raj", 45);
		Person alsoRaj = raj.clone();
		System.out.println("Are the the same Java object? " + (raj == alsoRaj));
		System.out.println("Are the the same real life Person? " + raj.equals(alsoRaj));	
	}
```
And we see the result:

```console
Are the the same Java object? false
Are the the same real life Person? true
```

## End Lab