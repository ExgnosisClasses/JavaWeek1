# Lab 4-1: Array Basics


## Lab Objectives

This lab explores some array basics. For this lab, you can just use a basic `Runner` class with a `main()` method. Do all of your work in the main method.

---
<br/>
<br/>

## Part One: Simple Arrays

Create two different arrays of integers each with a length of five with the same entries {10,11,12,14,15}. In the code below, these are creatively called `first` and `second`

The first array is created using the `new` operator and a loop to initialize the array.
- Note that we cannot use the compact form of the for loop because we need an explict value for the index, so we use the older form of the for loop

The second array is created using the static initialization syntax.

After you create each array, print out the address of the array and use the compact `for` loop to print out the values

```java
public class Runner {
    public static void main(String[] args) {

        int [] first = new int[5];

        for (int index = 0; index < first.length; index++) {
            first[index] = index + 11;
        }
        System.out.println("Address of first = " + first);
        for( int element: first) {
            System.out.println(element);
        }

        int [] second = {11,12,13,14,15};
        System.out.println("Address of second = " + second);
        for( int element: second) {
            System.out.println(element);
        }
    }
}
```
Now create a third array variable that is initialized to `null`. Assign `first` to `third`.

Compare the address `first` and `third` to confirm the point to the same memory location.  The `==` comparison operator only compares addresses. If the arrays are at the same address in memory, they are equal. 

Change one element of the `first` array and notice it also changed the corresponding element in `third`

But also note that `first` and `third` are still equal because they still point to the same memory location.


```java
public class Runner {
    public static void main(String[] args) {

        int[] first = new int[5];

        for (int index = 0; index < first.length; index++) {
            first[index] = index + 11;
        }

        int[] second = {11, 12, 13, 14, 15};
        System.out.println("Address of second = " + second);

        int[] third = null;
        third = first;
        System.out.println("Address of third = " + third);
        System.out.println("first == second " + (first == second));
        System.out.println("first == third " + (first == third));

        first[0] = -100;
        System.out.println("third[0]=" + third[0]);
        System.out.println("first == third " + (first == third));
    }
}
```

## Part Two: Copying Arrays

To deep copy an array, we have to create a new array and then copy each element from the old array to the new one.
- We also use the `length` property of the array to find out how long to make the new array
- Delete your previous arrays and create a new `first` arra like this 

```java 
int [] first = {11,12,13,14,15};
```

- Then create a new empty array the same size as the `first` array called `copy`
- Loop through the `first` array and assign each value to the corresponding position in the `copy` array

```java
int[] copy = new int[first.length];
for (int index = 0; index < first.length; index++) {
copy[index] = first[index];
```

Verify that they are equivalent but not equal.
- All steps shown below

```java
public class Runner {
    public static void main(String[] args) {

        int[] first = {11, 12, 13, 14, 15};

        int[] copy = new int[first.length];

        for (int index = 0; index < first.length; index++) {
            copy[index] = first[index];
        }

        System.out.println("Address of first = " + first);
        System.out.println("Address of copy = " + copy);
        for (int element : first) {
            System.out.println(element);
        }
        for (int element : copy) {
            System.out.println(element);
        }
    }
}
```

### Using The Utility Function

The key to programming effectively is not to write code that already exists and is usable. We can replace our method with a call to the `java.util.Arrays` library

```java
import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		 int [] first = {11,12,13,14,15};
		 int [] second = Arrays.copyOf(first, first.length);

		 System.out.println("Address of first = " + first);
		 System.out.println("Address of second = " + second);

		 System.out.println("Contents of first");
		 for (int element: first) System.out.println(element);

		 System.out.println("Contents of second");
		 for (int element: second) System.out.println(element);
	}
}
```

## Part Three Arrays of Objects

Create a `Coder` class under your `Runner` class. Make sure it is not `public` since you don't want to have to create a new file. A coder has a name which is assigned by the constructor and a `getName()` method.

```java
class Coder {
	private String name;

	public String getName() {
		return this.name;
	}

	public Coder(String name) {
		this.name = name;
	}
}
```

Create an array of `Coder` objects. Print out each object in the array and note that it is an address. We can also apply the `getName()` method to each object using the syntax shown.

```java
public class Runner {

	public static void main(String[] args) {
		Coder[] gurus = { new Coder("Kent Beck"), 
				          new Coder("Donald Knuth"), 
				          new Coder("Andrew Ng")};
       for (Coder guru : gurus) {
    	   System.out.println("Address of " + guru.getName() + " is " + guru);
       }
	}
}
```
```console
Address of Kent Beck is Coder@5caf905d
Address of Donald Knuth is Coder@2a84aee7
Address of Andrew Ng is Coder@a09ee92
```

Note that the reference to the object also describes what type of object is being referenced.


---

## End Lab
