## Read-Eval-Print Loop: jshell (JEP 222)

- jshell
- Stream<Integer> s = Stream.ofNullable(1)
- s.forEach(System.out::println)

## Private methods in interface

```java
public interface Card{

    private Long createCardID(){
    // Method implementation goes here.
    }
    
    private static void displayCardDetails(){
    // Method implementation goes here.
    }

}
```

## Try with resources improvements

```java
public class Example {
    void testARM_Java9() throws IOException{
        BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
        try (reader1) {
          System.out.println(reader1.readLine());
        }
    }
}
```

## Diamond Operator for Anonymous Inner Class

```java
List<String> myList = new ArrayList<>() {
// Overridden methods
};
```