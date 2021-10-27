/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii.paint;

import asciipaint.model.Rectangle;
import asciipaint.model.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author piotr
 */
public class RectangleTest {

    public RectangleTest() {
    }

    @Test
    public void testIsInside_upperLeft() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'g');
        assertTrue(r.isInside(new Point(10., 10.)));
    }

    @Test
    public void testIsInside_upperRight() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'f');
        assertTrue(r.isInside(new Point(19., 10.)));
    }

    @Test
    public void testIsInside_bottomLeft() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'e');
        assertTrue(r.isInside(new Point(10., 6.)));
    }

    @Test
    public void testIsInside_bottomRight() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'd');
        assertTrue(r.isInside(new Point(19., 6.)));
    }

    @Test
    public void testIsInside_somewhereInside() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 's');
        assertTrue(r.isInside(new Point(15., 8.)));
    }

    @Test
    public void testIsInside_notInsideAroungUpperLeft() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'b');
        assertFalse(r.isInside(new Point(9., 10.)));
    }

    @Test
    public void testIsInside_notInsideAroundBottomRight() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'a');
        assertFalse(r.isInside(new Point(20., 5.)));
    }

    @Test
    public void testIsInside_notInsideAroundUpperRight() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'd');
        assertFalse(r.isInside(new Point(20., 8.)));

    }

    @Test
    public void testMove_moveThenCheckNewUpperLeft() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'r');
        r.move(35, 85);
        assertTrue(r.isInside(new Point(35, 85)));
    }

    @Test
    public void testMove_moveThenCheckOldUpperLeft() {
        Point upperLeft = new Point(10., 10.);
        Rectangle r = new Rectangle(upperLeft, 10., 5., 'r');
        r.move(35, 85);
        assertFalse(r.isInside(upperLeft));
    }

}
