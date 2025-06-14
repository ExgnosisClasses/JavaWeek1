# Lab 9-2: Collections  


## Lab Objectives

This lab will implement an array of names in several different ways using collections

---
<br/>
<br/>

## Part 1: Setup

Start a new project and create a `Runner` class with a main method as before.


<br/>
<br/>

## Part 2: Create a list of names

We will start with an array of names

```java
 String[] nameArray = { "Alice", "Bob", "Alice", "Charlie", "Bob", "Diana" };
```

## Part 3: Create collections
 
 Now create a `List`, `Set` and `SortedSet` using some standard implementation classes.

Check the Java documentation to see what other classes you could use and, if you want, experiment with using some of those instead.

Note that we have to import `java.util.*`

```java
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        // Step 1: Create an array with duplicate names
        String[] nameArray = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Diana"};

        // Step 2: Initialize collections
        Set<String> nameSet = new HashSet<>();
        SortedSet<String> nameSortedSet = new TreeSet<>();
        LinkedList<String> nameLinkedList = new LinkedList<>();
    }
}
```

## Part 4: Add the names to the collections

Loop through the array and add each list name to the collection

```java
 import java.util.*;

public class Runner {
    public static void main(String[] args) {
        
        // Step 2: Create an array with duplicate names
        String[] nameArray = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Diana"};

        // Step 3: Initialize collections
        Set<String> nameSet = new HashSet<>();
        SortedSet<String> nameSortedSet = new TreeSet<>();
        LinkedList<String> nameLinkedList = new LinkedList<>();

        // Step 4: Loop through the array and add each name to the collections
        for (String name : nameArray) {
            nameSet.add(name);
            nameSortedSet.add(name);
            nameLinkedList.add(name);
        }
        
    }
}
```

## Part 5: Print out the values

Add in the code to print the contents of the collections


```java
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        
        // Step 2: Create an array with duplicate names
        String[] nameArray = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Diana"};

        // Step 3: Initialize collections
        Set<String> nameSet = new HashSet<>();
        SortedSet<String> nameSortedSet = new TreeSet<>();
        LinkedList<String> nameLinkedList = new LinkedList<>();

        // Step 4: Loop through the array and add each name to the collections
        for (String name : nameArray) {
            nameSet.add(name);
            nameSortedSet.add(name);
            nameLinkedList.add(name);
        }
        
        // Step 5: Print all collections
        System.out.println("Original array with duplicates:");
        System.out.println(Arrays.toString(nameArray));

        System.out.println("\nSet (HashSet) - no duplicates, unordered:");
        System.out.println(nameSet);

        System.out.println("\nSortedSet (TreeSet) - no duplicates, sorted:");
        System.out.println(nameSortedSet);

        System.out.println("\nLinkedList - duplicates allowed, preserves insertion order:");
        System.out.println(nameLinkedList);
        
    }
}
```
```console
Set (HashSet) - no duplicates, unordered:
[Diana, Bob, Alice, Charlie]

SortedSet (TreeSet) - no duplicates, sorted:
[Alice, Bob, Charlie, Diana]

LinkedList - duplicates allowed, preserves insertion order:
[Alice, Bob, Alice, Charlie, Bob, Diana]
```

---

## Part 6: Maps

In this section, you will create a map from an array of names and an array of ages. 
- The names will be the keys so they must be unique

#### Step 1: Create the arrays

```java
String[] names = { "Alice", "Bob", "Charlie", "Diana", "Eve" };
int[] ages =    {   30,     25,      35,       28,     22 };
```

#### Step 2: Create the map

- Note key the type is String and the value type is int.

```java
 Map<String, Integer> nameAgeMap = new HashMap<>();
```

#### Step 3: Populate the map

- Loop through the arrays and insert the values into the map

```java
for (int i = 0; i < names.length; i++) {
    nameAgeMap.put(names[i], ages[i]);
}
```

## Step 4: Print out the result

- Your code should look like this:

```java
import java.util.*;

public class Runner {
    public static void main(String[] args) {
      
        String[] names = { "Alice", "Bob", "Charlie", "Diana", "Eve" };
        int[] ages =    {   30,     25,      35,       28,     22 };
        
        Map<String, Integer> nameAgeMap = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            nameAgeMap.put(names[i], ages[i]);
        }
        
        System.out.println("Name to Age Map:");
        for (Map.Entry<String, Integer> entry : nameAgeMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
```

```conole
Name to Age Map:
Diana => 28
Bob => 25
Eve => 22
Alice => 30
Charlie => 35
```

### Extra

Try duplicating one of the names like this:

```java
String[] names = { "Alice", "Bob", "Bob", "Diana", "Eve" };
```

- The first time that Java encounters `Bob`, it will create an entry `(Bob, 25)`
- The second time it encounters `Bob`, since the entry exists, it treats is as an update to the existing entry and set the element to `(Bob,35)`

```console
Diana => 28
Bob => 35
Eve => 22
Alice => 30
```

## End Lab