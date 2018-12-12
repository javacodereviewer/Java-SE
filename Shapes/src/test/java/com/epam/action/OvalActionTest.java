package com.epam.action;

import com.epam.entity.Oval;
import com.epam.entity.Reader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class OvalActionTest {

    private static List<Oval> listOfOvals;

    private static OvalAction action;

    @BeforeClass
    public static void init() {
        Reader reader = new Reader();
        listOfOvals = reader.readLine();
        action = new OvalAction();
    }

    @Test
    public void testReadValidData() {
        assertEquals(listOfOvals.size(), 2);
    }

    @Test
    public void testGetArea() {
        Oval oval = listOfOvals.get(0);
        double area = action.getArea(oval);
        assertEquals(area, 18.849, 0.001);
    }

    @Test
    public void testGetPerimeter() {
        Oval oval = listOfOvals.get(0);
        double perimeter = action.getPerimeter(oval);
        assertEquals(perimeter, 16.019, 0.001);
    }

    @Test
    public void testIsCircle() {
        Oval oval = listOfOvals.get(1);
        assertFalse(action.isCircle(oval));
    }

    @Test
    public void testIsPointsBuildOval() {
        Oval oval = listOfOvals.get(1);
        assertTrue(action.isPointsBuildOval(oval));
    }
}


