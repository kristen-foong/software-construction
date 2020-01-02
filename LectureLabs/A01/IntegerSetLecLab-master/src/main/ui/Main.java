package ui;
import model.IntegerSet;

// simple application illustrating use of the IntegerSet class
public class Main {
  public static void main(String[] args) {
    IntegerSet setA = new IntegerSet();
    IntegerSet setB = new IntegerSet();
    setA.insert(1);
    setA.insert(2);
    setA.insert(3);
    setB.insert(2);
    setB.insert(3);
    setB.insert(4);
    IntegerSet intersectAB = setA.intersection(setB);
  }
}
