/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii.paint;

import asciipaint.Circle;
import asciipaint.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author piotr
 */
public class CircleTest {

    public CircleTest() {
    }

    @Test
    public void testIsInside_Center() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(center));
    }

    @Test
    public void testInside_FarTop() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(10, 14)));
    }

    @Test
    public void testInside_FarBottom() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(10, 6)));
    }

    @Test
    public void testInside_FarBottomRight() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(13, 7)));
    }

    @Test
    public void testInside_FarBottomRight_upper() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(14, 8)));
    }

    @Test
    public void testInside_FarBottomRight_lower() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(12, 6)));
    }

    @Test
    public void testInside_FarTopLeft() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(7, 13)));
    }

    @Test
    public void testInside_FarTopLeft_lower() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(6, 12)));
    }

    @Test
    public void testInside_FarTopLeft_upper() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        assertTrue(c.isInside(new Point(8, 14)));
    }

    @Test
    public void testMove_moveThenCheckNewCenter() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        c.move(25, 25);
        assertTrue(c.isInside(new Point(25, 25)));

    }

    @Test
    public void testMove_moveThenCheckOldCenter() {
        Point center = new Point(10., 10.);
        Circle c = new Circle(center, 5., 'c');
        c.move(25, 25);
        assertFalse(c.isInside(center));
    }
}
