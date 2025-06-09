# Lab 7-2: Method Overriding 


## Lab Objectives

This lab builds on the last lab where we override a method to change the behaviour of the `ServiceDog` class
---
<br/>
<br/>

## Part 1: Override a method

We want `ServiceDog` objects to speak softly because they are working. 

Replace the original `Dog.speak()` with a new `ServiceDog.speak()` method. 

The `Dog.speak()` method is still there, but the `ServiceDog.speak()` method overrides it rather than replacing it.

It is important that the new method has exactly the same signature as the parent method, or else we are just overloading the method.

Use the `@Override` annotation to tell the compiler to check to make sure we are doing the override properly.

```java
class ServiceDog extends Dog {
	public ServiceDog(String name) {
		super(name);
	}

    @Override
    public void speak() {
    	System.out.println(this.getName() + " sits quietly");
    }

	public void work() {
		System.out.println(this.getName() + " is hard at work");
	}
}
```

Test it to see it works.

```java
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();
	}
```

The Liskov Substitution principle states (more or less) that overriding a method in a child class should not change the behavior of the parent class. You've just shown that your override satisfies the Liskov substitution principle. In other words, overriding in the `ServiceDog` class didn't alter the `Dog` class


<br/>
<br/>

## Part 2: Extending a method

Sometimes we just want to add to the functionality of the parent method. This is called extending a method.

We can access the parent method with `super.speak()` in our child `speak()` method.  

MMake the following change to your code

```java
   @Override
    public void speak() {
    	System.out.println(this.getName() + " Looks for permission to speak");
    	super.speak();
    }
```

Test this to see that it works. Notice that the behavior of the superclass or parent class is unaffected.


```java 
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();

	}
```

**Save your work, you will add to it in the next lab**

---

## End Lab