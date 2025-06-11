# Lab 7-1: Specialization 



## Lab Objectives

In this lab, you will work with specializing a `Dog` class to create a `ServiceDog` class

---
<br/>
<br/>

## Part 1: Define the Dog Class

Create a basic `Dog` class as shown

```java
class Dog {
	 private String name;

	public Dog(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void speak() {
		System.out.println(this.getName() + " BARK!");
	}
 }
```

Test it to see it works.

```java
	public static void main(String[] args) {
	Dog fido = new Dog("Fido");
	fido.speak();
	}
```
<br/>
<br/>

## Part 2: Create a subclass without inheritance (optional)

This section shows how to do inheritance without `extends`. Read through it and try the code. Give it a try if you want to challenge yourself.

A `ServiceDog` does everything a dog does with the addition of adding a `work()` method.

We could construct our own `ServiceDog` class by wrapping a `Dog` object in this extra functionality. The code below does this, and is very similar to what Java actually does behind the scenes with inheritance.

The methods in the `Dog` class's interface are now hidden to the world, so we have to replicate them in the interface of the `ServiceDog` class and forward the messages to the embedded `Dog` class

```java 

class ServiceDog {
	 private Dog d;

	 ServiceDog(Dog d) { // dependency injection
		 this.d = d;
	 }
	 public String getName() {
		 return this.d.getName();
	 }
	 
	 public void speak() {
		 this.d.speak();
     } 
     	 
	 public void work() {
		 System.out.println(this.getName() + " is hard at work");
	 }
 }
```

Now we can test this class.

```java
	public static void main(String[] args) {
		ServiceDog lassie = new ServiceDog(new Dog("Lassie"));
		lassie.speak();
		lassie.work();
	}
```
<br/>
<br/>

## Part 3: Using `extends`

What we have done is use some rather standard methods for object construction. 
- In fact, this wrapping an object in another object to add functionality is called the Decorator Design Pattern.

The problem is that this is a solution that requires a LOT of work and boilerplate code.

Inheritance in Java leverages the intuitive type relationship between `Dog` and `ServiceDog` (specifically a service dog _is_ a dog).

So we let Java do the heavy lifting for us by using inheritance

Create the subclass ServiceDog from your Dog class by using `extends`

```java
class ServiceDog extends Dog {

	public ServiceDog(String name) {
		super(name);
	}
	public void work() {
		 System.out.println(this.getName() + " is hard at work");
	}
}
```

`ServiceDog` has access to all the non-private data and methods of `Dog`.

The only tweak we had to make is that we still have to set the name of the `Dog` with the `Dog` constructor. We do this in the constructor of the `ServiceDog` class by calling the constructor in the parent `Dog` class, where we use the `super()` construct to do this.

Now test it to see if it works

```java
	public static void main(String[] args) {
		
		ServiceDog lassie = new ServiceDog("Lassie");
		lassie.speak();
		lassie.work();
	}
```
**Save your work, you will add to it in the next lab**
---

## End Lab
