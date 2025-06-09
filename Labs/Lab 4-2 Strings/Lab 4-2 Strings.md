# Lab 4-2 Strings
---

## Lab Objectives

This lab explores some interesting features of Strings
---
<br/>
<br/>

## Part 1: String Definitions

Just like arrays, there are two different ways to create a String, using the shorthand form a String constructor.

```java
	public static void main(String[] args) {
		// This form
		String s1 = "Hello World";
		// is a shorthand for
        String s2 = new String("Hello World");
	}    
```
The literal "Hello World" is interned in the string literal pool
<br/>
<br/>

## Part 2: String Java Class Library

In this section, you will use the String library.
- Be sure and explore the documentation for it as well
- [Java String Library](https://docs.oracle.com/en/java/javase//20/docs/api/java.base/java/lang/String.html)

1. Declare a String variable named `name` and assign your first name to it.
2. Print the string in uppercase and lowercase.
3. Display the length of the string.
4. Print the first character of the string using charAt(0).
5. Use contains() to check if the name includes the letter "a".

Assign `name` to a new String variable
- See if they are equal (using `==`)
- See if they are equivalent using .equals()

Print "The names are the same" or "The names are different" based on the comparison.

Solution is in the Solution Directory

## Part 3: StringBuilder

In this section, you will create a string using a StringBuilder
- First note that the worst way to build up a string of numbers is like this.  (Why?)

```java
    public static void main(String[] args) {       
        String s = "";
        for (int i = 1 ; i <= 10; i++) {
        	s = s + " " + i;
        }
        System.out.println(s);
	}
   
```

Using a StringBuilder is a more efficient way to construct a String

Steps:
1. First, we load a string into the Stringbuilder object's buffer. 
2. Since we are creating a new String, we start with the empty string
3. Then we loop adding a space and value each iteration with the append() operations
4. Finally, we export the buffer to a standard String


```java
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= 10; i++) {
			sb.append(" ");
			sb.append(i);
		}
		String s = sb.toString();
		System.out.println(s);
	}
```


---

## End Lab