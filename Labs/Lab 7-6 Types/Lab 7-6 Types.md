# Lab 7-6: Types  


## Lab Objectives

This lab introduced the Java Interface construct

---
<br/>
<br/>

## Part 1: Setup

We are going to start with the code that finished lab 7-4 with. It is available in the solutions folder for that lab

```java
abstract class Pet {
	abstract public void speak();
}

class Dog extends Pet {
	
	@Override
	public void speak() {
		System.out.println("Bark");
	}

	public void walk() {
		System.out.println("Walking");
	}
}

class Cat extends Pet {
	@Override
	public void speak() {
		System.out.println("Meow");
	}

	public void walk() {
		System.out.println("Walking");
	}
}

class Fish extends Pet {
	@Override
	public void speak() {
		System.out.println(".....");
	}

	public void swim() {
		System.out.println("Swimming");
	}
}

class Bird extends Pet {
	@Override
	public void speak() {
		System.out.println("tweet");
	}

	public void fly() {
		System.out.println("Flying");
	}
}

```
<br/>
<br/>

## Part 2: The Inheritance problem

It turns out that not every sort of grouping we do at an abstract level fits nicely into an inheritance hierarchy. The common aspect that we captured in the abstract `Pet` class is that they all have a `speak()` method.

But what if we wanted to generalize all the pets that could walk? We could create a class like this:

```java
 abstract class Walker {
	 abstract void walk();
 }
```
The problem is that both `Dog` and `Cat` would have to extend both the `Pet` class and the `Walker` class. 

The more modern approach is to define a type in terms of the interface it presents for the role that it plays. A Java interface is just a list of methods that have to implement (the contract) for an object to be of that type.

Remove the abstract class Pet and create new types in terms of thse three interfaces.

```java
interface Pet {
	public void speak();
}
interface Walker {
	public void walk();
}
interface Flyer {
    public void fly();
}
```
Replace the extends in the code with each class implementing the interfaces that are appropriate as shown

```java
class Dog implements Pet, Walker {
	
	@Override
	public void speak() {
		System.out.println("Bark");
	}
    @Override
	public void walk() {
		System.out.println("Walking");
	}
}

class Cat implements Pet, Walker{
	@Override
	public void speak() {
		System.out.println("Meow");
	}
   @Override
	public void walk() {
		System.out.println("Walking");
	}
}

class Fish implements Pet {
	@Override
	public void speak() {
		System.out.println(".....");
	}
	public void swim() {
		System.out.println("Swimming");
	}
}

class Bird implements Pet, Flyer {
	@Override
	public void speak() {
		System.out.println("tweet");
	}
	public void fly() {
		System.out.println("Flying");
	}
}
```
However, we can use interfaces as types in exactly the same what that we use abstract classes or regular classes.  In fact, the mainline code from the previous lab works without modification.

```java
	public static void main(String[] args) {
		Pet[] critters = { new Dog(), new Cat(), new Fish(), new Bird() };
		for(Pet critter : critters) {
			System.out.println(critter); 
			critter.speak(); 
		}
	}
```
```console
lab8_1.Dog@18b4aac2
Bark
lab8_1.Cat@764c12b6
Meow
lab8_1.Fish@c387f44
.....
lab8_1.Bird@4e0e2f2a
tweet
```

## End Lab