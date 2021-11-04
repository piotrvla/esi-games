package ascii.paint;

import asciipaint.model.Line;
import asciipaint.model.Point;
import asciipaint.model.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {

    public LineTest() {


    }

    @Test
    public void testIsInside_PointA() {

        Line line = new Line(new Point(10, 10), new Point(25, 25), 'r');
        assertTrue(line.isInside(new Point(10, 10)));
    }

    @Test
    public void testIsInside_PointB() {

        Line line = new Line(new Point(80, 23), new Point(65, 23), 'r');
        assertTrue(line.isInside(new Point(65, 23)));
    }

    @Test
    public void testIsInside_between() {

        Line line = new Line(new Point(80, 80), new Point(90, 90), 'r');
        assertTrue(line.isInside(new Point(85, 85)));
    }

    @Test
    public void testMove_pointA_OK() {
        Line line = new Line(new Point(80, 80), new Point(90, 90), 'r');
        line.move(20, 30);
        assertTrue(line.isInside(new Point(100, 110)));
    }

    @Test
    public void testMove_pointB_OK() {
        Line line = new Line(new Point(80, 80), new Point(90, 90), 'r');
        line.move(20, 30);
        assertTrue(line.isInside(new Point(110, 120)));
    }

    @Test
    public void testMove_pointA_Old_Position() {
        Line line = new Line(new Point(80, 80), new Point(90, 90), 'r');
        line.move(20, 30);
        assertFalse(line.isInside(new Point(80, 80)));

    }

    @Test
    public void testMove_PointB_Old_Position() {
        Line line = new Line(new Point(80, 80), new Point(90, 90), 'r');
        line.move(20, 30);
        assertFalse(line.isInside(new Point(90, 90)));

    }

}
