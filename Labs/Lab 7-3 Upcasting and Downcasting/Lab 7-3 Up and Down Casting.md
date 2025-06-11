# Lab 7-3: Upcasting and Downcasting  



## Lab Objectives

This lab explores upcasting and downcasting in inheritance hierarchies

---
<br/>
<br/>

## Part 1: Continue from last lab.

The final version of the code at the end of the last lab was:

```java
public class Runner {

	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();
	}

}

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

class ServiceDog extends Dog {
	public ServiceDog(String name) {
		super(name);
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " Looks for permission to speak");
		super.speak();
	}

	public void work() {
		System.out.println(this.getName() + " is hard at work");
	}
}
```
<br/>
<br/>

## Part 2: Using a Dog Variable

In keeping with the idea of an inheritance relationship, a `ServiceDog` is a `Dog`, create both a `Dog` and `ServiceDog` object assigned the variables `fido` and `lassie` respectively.

Also create a new `Dog` variable `someDog` and a `ServiceDog` variable `workDog`

```java
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		Dog someDog = null;
		ServiceDog workDog = null;
	}
```

As expected, we can assign `fido` to `someDog` but we can't assign `fido` to `workDog`.

This is type safety because an arbitrary `Dog` is not a `ServiceDog`.


```java
	someDog = fido;  // ok since they are the same type
	//workDog = fido;  // error because an arbitrary dog is not a service dog
```

Assign a `ServiceDog` object to a `Dog` variable.  
- Why can we do this? 
- Because the inheritance relationship says that all service dogs are also dogs; service dogs are just a special type of dog. 

To assign an object to a variable that is the type of one of its superclasses is called _upcasting_ 
- It's called this because we are treating the object as a type higher in its inheritance hierarchy.

Try to assign `someDog` back to `workDog`, Java won't let you because of type safety

```java 
	someDog = lassie;  // Upcasting 
	//workDog = someDog; // error like before
```

Why block this? 
- Because we know that `someDog` contains a `ServiceDog` object because we put it there earlier
- But Java can't figure that out just by looking at the statement. 
- It might be that the object in `someDog` isn't really a `ServiceDog` at some point in the future while the code is running.
- It depends on what happened during execution before the flow of control gets to this statement.

Do the same sort of thing we did with primitive data types and _downcast_ the `Dog` to a `ServiceDog`

```java
	someDog = lassie; // Upcasting 
	workDog = (ServiceDog)someDog; // Downcasting
```

Just like casting with primitive types, this has the potential to go very wrong.  
- Suppose we have a cast a plain old `Dog` as a `ServiceDog`, then Java will allow us to call the `work()` method on it, which it doesn't have.
- And that will throw an exception.

```java
	workDog = (ServiceDog)fido;  // Fido is not a ServiceDog
	workDog.work();     // danger zone
```

The problem is that Java can't figure this out until runtime when it realized you lied about `fido` being a `ServiceDog`

```console
Exception in thread "main" java.lang.ClassCastException: 
class Dog cannot be cast to class ServiceDog 

```
<br/>
<br/>

## Part 3: Generic Arrays

This allows us to create collections of dogs whether they are service dogs or just plain old dogs.

We can tell which type of dog a generic dog entry is by using the `instanceof` binary operator. If we do have a `ServiceDog` then we can downcast safely and call the `work()` method

```java
	public static void main(String[] args) {
		Dog [] kennel = { new ServiceDog("Lassie"), new Dog("Fido"), new Dog("Rolf") };
		
		for(Dog puppy : kennel) {
			puppy.speak();
			if (puppy instanceof ServiceDog) {
				((ServiceDog) puppy).work();
			}
		}
	}
```

---

## End Lab