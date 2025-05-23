

# Grundlage

## Modifier

| Modifier  |      |                                                              |      |
| --------- | ---- | ------------------------------------------------------------ | ---- |
| public    | +    | class, method, variable                                      |      |
| private   | -    | class, method, variable                                      |      |
| protected | #    |                                                              |      |
| default   |      |                                                              |      |
| abstract  |      |                                                              |      |
| static    |      | Variablen und Methoden zu deklarieren, die zur Klasse selbst gehören, anstatt zu einer Instanz der Klasse |      |
| final     |      | ein Element kann nicht geändert werden                       |      |

- static
	statische Variablen (静态变量): oder Klassenvariable. **Alle Instanzen der Klasse teilen sich dieselbe statische Variable**
	statische Methoden (静态方法): können über den Klassennamen aufgerufen werden, **ohne eine Instanz der Klasse zu erstellen**
	
  **调用静态方法可以无需创建对象** `classname.methodname` oder `instanz.methodename`
  那么静态方法和实例方法有什么区别呢？

- final 

  final Variable: Ihr Wert kann nach der Initialisierung nicht geändert werden. `final int x = 10;`

  final Methode: kann in abgeleiteten Klassen nicht überschrieben werden. 

  final Klasse: kann nicht erweitert werden `public final class A` `public class B extends A // fehler`

# Datentypen

primitive Datentypen & Klasse Datentypen

|                      |                 |                        |            |                |                          |                                            |                        |                                   |
| -------------------- | --------------- | ---------------------- | ---------- | -------------- | ------------------------ | ------------------------------------------ | ---------------------- | --------------------------------- |
| primitive Datentypen | boolean         | char                   | byte       | short          | int                      | long                                       | float                  | double                            |
| Klasse (java.lang.)  | Boolean         | Character              | Byte       | Short          | Integer                  | Long                                       | Float                  | Double                            |
| Größe                | 1 Bit           | 16 Bit                 | 8 Bit      | 16 Bit         | 32 Bit                   | 64 Bit                                     | 32 Bit                 | 64 Bit                            |
| Wertebereich         | true oder false | 16-Bit-Unicode-Zeichen | -128 ~ 127 | -32768 ~ 32767 | -2147483648 ~ 2147483647 | -9223372036854775808 ~ 9223372036854775807 | 1.4E-45 ~ 3.4028235E38 | 4.9E-324 ~ 1.7976931348623157E308 |
| Standardwert         | false           | 'u0000'                | 0          | 0              | 0                        | 0L                                         | 0f                     | 0d                                |

byte < short < int < long

float < double

Was ist das Unterschied zwischen primitive Datentypen und Package Datentypen?

- Boxing & Unboxing

  Boxing: `Integer i = new Integer(5);` 

  Unboxing: `int j = i.intValue();`

## Typumwandlung (typecast)

1. Automatische(implizite) Typumwandlung: Daten eines kleineren Datentyps werden automatisch dem größeren angepasst.

   <img src="https://openbook.rheinwerk-verlag.de/javainsel/bilder/02_006.png" alt="img" style="zoom:70%;" />

2. Explizite Typumwandlung: Ein größerer Typ kann einem kleineren Typ mit möglichem Verlust von Informationen zugewiesen werden.

   `int pi = (int) 3.1415; // Ausgabe: 3` 

   `int n = (int) 3.1415 + 2.1; // Fehler` 
   `int n = (int) (3.1415 + 2.1); // Ausgabe: 5` 

# java.lang.Math

`public final class Math extends Object` 

was bedeutet hier final?

Math.PI, Math.sin, Math,cos

## Pseudo-Zufallszhalen

`Math.random()`  returns a random value that is greater than or equal to 0.0 and less than 1.0

generate a random number between 10 and 20: `int rNum = (int)(Math.random() * (max - min + 1)) + min);` 

# java.lang.Object

int hashCode( )

String toString( )



# Konstrollstrukturen

## Schleifen

continue, break, return, return value

- continue

  Das `continue`-Statement wird in Schleifen verwendet, um <u>den aktuellen Schleifendurchlauf</u> **vorzeitig zu beenden** und mit <u>dem nächsten Durchlauf</u> **fortzufahren**. 

  ```java
  for (int i = 0; i < 10; i++) {
      if (i == 5) {
          continue; // Beendet den aktuellen Durchlauf und springt zur nächsten Iteration
      }
      System.out.println(i);
  }
  // Ausgabe: 0, 1, 2, 3, 4, 6, 7, 8, 9
  ```

- break

  1. Wenn das `break`-Statement erreicht wird, wird die Ausführung <u>aus der Schleife oder dem Schalter</u> **herausgeführt**, und der Code wird mit der Anweisung <u>nach der Schleife oder dem Schalter fortgesetzt</u>.

  ```java
  for (int i = 0; i < 10; i++) {
      if (i == 5) {
          break; // Beendet die Schleife vorzeitig
      }
      System.out.println(i);
  }
  // Ausgabe: 0, 1, 2, 3, 4
  ```

  2. Das `break`-Statement kann auch verwendet werden, um <u>die Ausführung eines Schalters (switch) zu beenden</u>.

- return 

  用于跳出所在方法，结束该方法的运行。

  - den Wert einer Methode zurückzugeben
  - die Ausführung einer Methode frühzeitig zu beenden

Beispiel: 

```java
public static void main(String[] args) {
    boolean flag = false;
    for (int i = 0; i <= 3; i++) {
        if (i == 0) {
            System.out.println("0");
        } else if (i == 1) {
            System.out.println("1");
            continue;
        } else if (i == 2) {
            System.out.println("2");
            flag = true;
        } else if (i == 3) {
            System.out.println("3");
            break;
        } else if (i == 4) {
            System.out.println("4");
        }
        System.out.println("xixi");
    }
    if (flag) {
        System.out.println("haha");
        return;
    }
    System.out.println("heihei");
}

// Ausgabe: ?
```



# Erweitung

**keyword: extends**

Ist-Beziehung

体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有属性和方法。**特别的，<u>父类声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构</u>。只有因为封装性的影响，使得子类不能直接调用父类的结构而已。注意！继承性和封装性之间并不会互相矛盾的！！！**

## UML

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20230404004303609.png" alt="image-20230404004303609" style="zoom:50%;" />

## Code



- instanceof

```java
class Tier {}
class Hund extends Tier {}

public static void main (String [] args) {
  Tier tier = new Hund();	// Polymorphism
  // erstellt also ein neues Objekt der Klasse "Hund" und weist es der Variable "tier" zu, die als Variable der Klasse "Tier" deklariert wurde. Dadurch wird eine Polymorphie erreicht, die es ermöglicht, auf die gemeinsamen Eigenschaften und Methoden der Klasse "Tier" zuzugreifen, aber auch auf die speziellen Eigenschaften und Methoden der Klasse "Hund", wenn sie vorhanden sind.
  
  if (tier instanceof Hund) {
    System.out.println("Das Tier ist ein Hund.");
  }
  else if (tier instanceof Tier){
    System.out.println("Das Tier ist eine Instanz der Klasse Tier.");
  }
}
```

# Überladene Methoden

die Methoden, die mit den gleichen Namen, aber unterschiedlichen Parametern (Anzahl/Reihenfolgen/Typen)

# Aggregation

keyword: implements

hat-Beziehung

# Collections

## Generics - 泛型 

generics class <E>

Why use Generics? Why not just use Object?



## Liste (ArrayList)

initiate(list create): `List karten = new ArrayList<Karten>`

Was ist das Unterschied zwischen Array und List? Wann benutzt man List und wann Array?
z.B. oop23_aufgabe2.3_polyell

# Exception

try-catch-finally

throws

- werfen: Beispiel throw

  ```java
  private double myMethod (double a) throws MyException {
    if(a < 0){
      throw new MyException("Invalid Parameter; should be larger than zero but is + "a") // return?
    }
    else {
      return Math.sqrt(a);
    }
  }
  ```

- fangen: Beispiel try-catch-finally

  ```java
  private double myComputation(double b){
    double wurzel;
    try {
      wurzel = myMethod(b);
    }
    catch(MyException mex){
      wurzel = - Math.sqrt(-b);
    }
    return wurzel;
  }
  ```

  

# Besondere Thema

## Pack importieren

wann braucht man? was ist wichtig zu wissen? was ist wichtig in Klausur?
In IDE brauchen wir nix zu tun, weil IDE automatic Pack importieren wird.
aber das ist wichtig zu wissen, dass die Funktion der Pack, wann brauchen wir Pack zu importieren.



# Zeichenketten

## StringBuilder (Folie305) 

ist veränderlich, sollte für <u>Konstruktion und Veränderung</u> von Zeichenketten verwendet werden

- Veränderung
  - StringBuilder append (.)
  - StirngBuilder insert (int offset, .)
  - StringBuilder delete (int start, int end)  **// include start, exclude end**
  - StringBuilder replace (int start, int end, String str)  **// include start, exclude end**
- Länge 
  - int length ( )
- Suche
  - int indexOf (String str)  **//Returns the index within this string of the first occurrence of the specified substring.**
  - int lastIndexOf (String str) **//Returns the index within this string of the rightmost occurrence of the specified substring.**
  - int indexOf (String str, int fromIndex)  **// ... starting at the specified index**
  - int lastIndexof (String str, int fromIndex)  **// ... starting at the specified index** 
- Sonstige
  - StringBuilder reverse( )
  - String toString( )   **<font color = 'red'>for what? </font>**
  - String subString (int start, int end)  **// include star, exclude end**
  - String subString (int start)  **//Returns a string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string.**

Beispiel1

```java
StringBuilder ausgabe = new StringBuilder ("Dies ein Test.");
ausgabe.insert(ausgabe.indexOf("ein", "ist"));
// Ausgabe: Dies ist ein Test
```

Beispiel2

## String

Folie333



# Datenspeicherung

1. verschiedene Schreibweise bei verschieden OS
2. 

## java.io.File



## Read File

```java
import java.io.BufferedReader;

try( BufferedReader bufferedReader = new BufferedReader (new FileReader(datei))){
			
			/* BufferedReader Class, Methode readLine()
			public String readLine: 
			A String containing the contents of the line, not
			including any line-termination characters, or null if the end of the stream has
			been reached
			*/
			String line = bufferedReader.readLine();
			
			while(line != null) {
				System.out.println(reader.readLine());
				line = bufferedReader.readLine();	// 放的位置，如果放在if里面会发生什么
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace(System.err);
		} catch (IOException ioEx) {
			ioEx.printStackTrace(System.err);
		} 
```



# Rekursion

Rekursive Funktionen: Fakultät
Definition: $f(n) = n!$

- Berechnung iterativ: $\prod_{i=1}^n i$ 
  $f(5) = \prod_{i=1}^5 i$ 
  $= 5 * 4 * 3 * 3 * 1$ 

- Berechnung rekursiv:

# Trie

- Datenstruktur zur Speicherung von Worten

- Ergebnis: Baum

- Ein Knoten im Baum entspricht einem Zeichen des Wortes
- Alphabet: $\sum = \lbrace A, B, C, ..., Z \rbrace$ 

## Einfügen

# Threads



通知线程退出







