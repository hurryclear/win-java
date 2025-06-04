
# 8 Generics

- most common used is in collection

  ```java
  ArrayList<String> arrayList = new ArrayList<String>();
  ```

  - <> means generics

- why do you use generics?

## Generics Class

## Generics Interface

## Generics Method

```java
public static void printList(List<?> list) {
  for (Object obj : list) {
    System.out.print(obj + " ");
  }
  System.out.println();
}
```

this method accepts any type of list, e.g. List<Integer>, List<String> and so on

## Parameterized types

- 

```java
// create a box which can contain any type of instance
public class Box<T> {
  private T value;
  public Box (T value) {
    this.value = value;
  }
  public T getValue() {
    return value;
  }
  public void setValue(T value) {
    this.value = value;
  }
}

// Box contains Integer
Box<Integer> intBox = new Box<>(123);
// Box contains String
Box<String> strBox = new Box<>("hello");
```

- <T> is Type Parameter

## Type erasure

Java generics work only at compile time, they do not retain generic type information at runtime

## Wildcards

- the question mark (?), represents an unknown type
- upper bounded wildcards
  - `<? extends T>`
  - `?` accept only `T` and the child class of `T` 
- lower bounded wildcards
