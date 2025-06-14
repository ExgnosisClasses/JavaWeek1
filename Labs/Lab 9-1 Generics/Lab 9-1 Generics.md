# Lab 9-1: Generics  


## Lab Objectives

This lab will build a generic box

---
<br/>
<br/>

## Part 1: Setup

Start a new project and create a `Runner` class with a main method as before.


<br/>
<br/>

## Part 2: Create a concrete implementation

Before we use any generics, we always try out the logic with some concrete implementation. In this case, we will use a non-generic version using inheritance and up casting.

We leverage the fact that all Java classes have the Object class as their first ancestor

```java
class Box {
	private Object value;

	public Object getValue() {
		return this.value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
```
Test this with a couple of types, and notice that because we are upcasting the value to `Object`, we have to down cast it when we remove it from the box.

```java
public class Runner {

	public static void main(String[] args) {
		Box b = new Box();
		
		b.insert(new Test());
		Test t = (Test)b.retrieve();
		System.out.println(t);
		
		b.insert(Integer.valueOf(6));
		int i = ((Integer)b.retrieve()).intValue();
        System.out.println(i);
	}
}
```
```console
Test@6b95977
6
```

This works, but there is a lot of code needed to downcast or convert the Object in the box to the right form.

<br/>
<br/>

## Part 3: Create a generic box
 
 We can create the generic box by just editing the concrete box to use the type variable `<T>`

This basically does exactly what you just did but uses `<T>` to do type checking to ensure there are no potential problems with casting errors in your code.

Once that is done, Java throws away the `<T>` type and just uses `Object` since type casting errors have been resolved at compile time. This is called type erasure.

```java
class GenBox <T> {
	private T value;

	public T retrieve() {
		return this.value;
	}
	public void insert(T value) {
		this.value = value;
	}
}
```
There is no up casting or down casting involved. Test it out

```java
	public static void main(String[] args) {
		GenBox<Test> TestBox = new GenBox<>();
		TestBox.insert(new Test());
		System.out.println(TestBox.retrieve());
		
		GenBox<Integer> IntBox = new GenBox<>();
		IntBox.insert(8);
		System.out.println(IntBox.retrieve());
	}
```
```console
Test@6b95977
8
```

---



## End Lab