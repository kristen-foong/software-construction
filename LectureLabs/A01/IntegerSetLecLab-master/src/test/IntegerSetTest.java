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
}
