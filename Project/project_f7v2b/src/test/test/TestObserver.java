package test;

import model.Flower;
import model.Plant;
import model.PlantList;
import model.Tree;
import observer.PlantObserver;
import observer.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestObserver {
    public PlantObserver po;
    public Subject subject;
    public Plant maple;

    @BeforeEach
    void runBefore() {
        po = new Flower("rose");
        subject = new PlantList();
        maple = new Tree("maple");
    }

    @Test
    void testAddObserver() {
        subject.addObserver(po);
        assertTrue(subject.observers.contains(po));
    }

    @Test
    void testNotifyObservers() {
        assertFalse(subject.observers.contains(po));
        subject.addObserver(po);
        assertTrue(subject.observers.contains(po));
        subject.notifyObservers(maple);
    }

    @Test
    void testUpdate() {
        subject.addObserver(po);
        assertTrue(subject.observers.contains(po));
        po.update(maple);
    }
}
