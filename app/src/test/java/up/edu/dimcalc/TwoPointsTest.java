package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        //create the points to test
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure they're initialized as (0,0)
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // call the setPoint method
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);

        // get the coordinates
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // test them
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    @Test
    public void randomValue() {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // set the coordinates to something outside of the boundary
        testPoints.setPoint(0, 100, 100);
        testPoints.setPoint(1, 100, 100);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure the points were set to (100,100)
        assertEquals(100, p1.x);
        assertEquals(100, p1.y);
        assertEquals(100, p2.x);
        assertEquals(100, p2.y);

        // call the randomValue method
        testPoints.randomValue(0);
        testPoints.randomValue(1);

        // make sure the points are no longer (100,100)
        assertTrue(p1.x != 100);
        assertTrue(p1.y != 100);
        assertTrue(p2.x != 100);
        assertTrue(p2.y != 100);
    }

    @Test
    public void setOrigin() {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // set the coordinates to something besides the origin
        testPoints.setPoint(0, 10, 10);
        testPoints.setPoint(1, 10, 10);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure the points were set to (10,10)
        assertEquals(10, p1.x);
        assertEquals(10, p1.y);
        assertEquals(10, p2.x);
        assertEquals(10, p2.y);

        // call the setOrigin method
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);

        // make sure the points are now (0,0)
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    @Test
    public void copy() {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // set the coordinates of one point to (10,10) and the other to (0,0)
        testPoints.setPoint(0, 10, 10);
        testPoints.setPoint(1,0,0);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure the points were set to (10,10) and (0,0)
        assertEquals(10, p1.x);
        assertEquals(10, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);

        // call the copy method
        testPoints.copy(0,1);

        // make sure the points are now both (10,10)
        assertEquals(10, p1.x);
        assertEquals(10, p1.y);
        assertEquals(10, p2.x);
        assertEquals(10, p2.y);
    }

    @Test
    public void distance() {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // set the coordinates of one point to (0,0) and the other to (3,4)
        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1,3,4);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure the points were set to (0,0) and (3,4)
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(3, p2.x);
        assertEquals(4, p2.y);

        // call the distance method
        double distance = testPoints.distance();

        // make sure the length is 5
        assertEquals(5.0, distance, 0);
    }

    @Test
    public void slope() {
        // create the reference
        TwoPoints testPoints = new TwoPoints();

        // set the coordinates of one point to (0,0) and the other to (2,10)
        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1,2,10);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        // make sure the points were set to (0,0) and (2,10)
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(2, p2.x);
        assertEquals(10, p2.y);

        // call the slope method
        double slope = testPoints.slope();

        // make sure the slope is 5
        assertEquals(5.0, slope, 0);
    }
}