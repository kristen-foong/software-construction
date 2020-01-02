package model;

import java.util.ArrayList;
import java.util.List;

// Represents a set of integers
public class IntegerSet {
  private List<Integer> data;

  // EFFECTS: set is empty
  public IntegerSet() {
    data = new ArrayList<>();
  }

  // MODIFIES: this
  // EFFECTS: Integer i is added to the IntegerSet if it's not
  // already in the IntegerSet
  public void insert(Integer i) {
    if (!contains(i))
      data.add(i);
  }

  // REQUIRES: Integer i is an element of the IntegerSet
  // MODIFIES: this
  // EFFECTS: Integer i is removed from the IntegerSet
  public void remove(Integer i) {
    data.remove(i);
  }

  // EFFECTS: Returns true if Integer i is in the IntegerSet
  // and false otherwise
  public boolean contains(Integer i) {
    return data.contains(i);
  }

  // EFFECTS: Returns the number of items in the set
  public int size() {
    return data.size();
  }


  // REQUIRES: two integer sets
  // EFFECTS: returns a new set that contains the elements that are the same in both this set and the other set
  public IntegerSet intersection(IntegerSet other) {
    IntegerSet intersect = new IntegerSet();
    for(Integer i: data){
      if(other.contains(i)){
        intersect.insert(i);
      }
    }
    return intersect;
  }
}