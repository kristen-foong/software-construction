import model.IntegerSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests for IntegerSet
public class IntegerSetTest {
  private static final int NUMITEMS = 5000;
  private IntegerSet set;
  
  @BeforeEach
  public void runBefore() {
    set = new IntegerSet();
  }
  
  @Test
  public void testSize() {
    assertEquals(0, set.size());
    
    for (int i = 0; i < NUMITEMS; i++) {
      set.insert(i);
    }
    
    assertEquals(NUMITEMS, set.size());
  }
  
  @Test
  public void testContainsOne() {
    assertFalse(set.contains(1));
    set.insert(1);
    assertTrue(set.contains(1));
  }

  // TODO: COMPLETE THIS
  // Test caseL test that the integerSet can contains one item,
  // if one item is inserted into the set, and check that the
  // thing it contains is the thing we inserted
  @Test
  public void testInsertOneContainsOne() {
    set.insert(1);
    assertEquals(1, set.size());
    assertTrue(set.contains(1));
  }
  
  @Test
  public void testContainsLots() {
    for (int i = 0; i < NUMITEMS; i++) {
      set.insert(i);
    }
    
    for (int i = 0; i < NUMITEMS; i++) {
      assertTrue(set.contains(i));
    }
  }
  
  @Test
  public void testInsert() {
    set.insert(1);
    
    assertTrue(set.contains(1));
    assertEquals(1, set.size());
  }


  // TODO: COMPLETE THIS
  // checks that if two of the same integer are inserted,
  // that the integer appears only once
  @Test
  public void testDuplicate() {
    set.insert(1);
    set.insert(1);
    
    assertTrue(set.contains(1));
    assertEquals(1, set.size());
  }
  
  @Test
  public void testInsertLots() {
    for (int i = 0; i < NUMITEMS; i++) {
      set.insert(i);
    }
    
    assertTrue(set.contains(0));
    assertTrue(set.contains(NUMITEMS / 2));
    assertTrue(set.contains(NUMITEMS - 1));
    assertEquals(NUMITEMS, set.size());
  }
  
  @Test
  public void testRemove() {
    set.insert(1);
    set.remove(1);
    assertFalse(set.contains(1));
    assertEquals(0, set.size());
  }
  
  @Test
  public void testRemoveLots() {
    for (int i = 0; i < NUMITEMS; i++) {
      set.insert(i);
    }
    
    for (int i = 0; i < NUMITEMS; i++) {
      set.remove(i);
    }
    
    assertFalse(set.contains(0));
    assertFalse(set.contains(NUMITEMS / 2));
    assertFalse(set.contains(NUMITEMS - 1));
    assertEquals(0, set.size());
  }

  // TODO: COMPLETE THIS
  // test the intersection method
  // TEST CASES:
  // empty sets could be passed in
  // lots lots, empty lots, lots empty
  // all in common, some in common, none in common
  @Test
  public void testIntersection() {
    IntegerSet set2 = new IntegerSet();
    set.insert(1);
    set.insert(2);
    set2.insert(2);
    set2.insert(3);
    IntegerSet setAB = set.intersection(set2);
    assertTrue(setAB.contains(2));
  }

  // getNumRegCreds
  // 0-50 full range of credits
  // student registered for no courses
  // student registered for all possible credits
  // student registered for n credits

  // dropCourse
  // check that student is registered for some course
  // check that student is registered for the course AND another course
  // make a new student and course(s). call the register method, then call drop.
}
