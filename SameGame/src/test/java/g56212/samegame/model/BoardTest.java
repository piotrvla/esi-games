package g56212.samegame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class BoardTest {

    public BoardTest() {
    }

    @Test
    public void gameOver_When_2_Same_Color_Same_Spot() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        assertFalse(board.isGameOver());
    }

    @Test
    public void gameOver_When_More_Than_2_Same_Color_Same_Spot() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        board.putAt(new Block(Colors.RED), new Position(0, 2));
        assertFalse(board.isGameOver());
    }

    @Test
    public void gameOver_When_More_Than2_Different_Color() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.BLUE), new Position(0, 1));
        board.putAt(new Block(Colors.GREEN), new Position(0, 2));
        assertTrue(board.isGameOver());
    }

    @Test
    public void gameOver_When_More_Than_2_Same_Color_Not_Same_Spot() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.BLUE), new Position(0, 1));
        board.putAt(new Block(Colors.RED), new Position(3, 3));
        board.putAt(new Block(Colors.RED), new Position(4, 4));
        assertTrue(board.isGameOver());
    }

    @Test
    public void remove_Spot_GameOver() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        board.putAt(new Block(Colors.RED), new Position(0, 2));
        board.putAt(new Block(Colors.RED), new Position(1, 0));
        board.putAt(new Block(Colors.RED), new Position(1, 1));
        board.putAt(new Block(Colors.RED), new Position(1, 2));
        board.removeSpot(new Position(0, 0));
        assertTrue(board.isGameOver());
    }

    @Test
    public void remove_Spot_When_Different_Colors_InSpot() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.BLUE), new Position(0, 1));
        board.putAt(new Block(Colors.YELLOW), new Position(1, 0));
        board.putAt(new Block(Colors.GREEN), new Position(0, 2));
        assertThrows(IllegalArgumentException.class,
                () -> board.removeSpot(new Position(0, 0)));
    }

    @Test
    public void remove_Spot_When_Exactly_2_Colors() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        board.removeSpot(new Position(0, 0));
        assertEquals(0, board.countColors(new Position(0, 0)));
    }

    @Test
    public void remove_A_ZigZag_Same_Color() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        board.putAt(new Block(Colors.RED), new Position(1, 1));
        board.putAt(new Block(Colors.RED), new Position(1, 2));
        board.putAt(new Block(Colors.RED), new Position(2, 2));
        board.putAt(new Block(Colors.RED), new Position(2, 3));
        board.putAt(new Block(Colors.RED), new Position(3, 3));
        board.putAt(new Block(Colors.RED), new Position(3, 4));
        board.putAt(new Block(Colors.RED), new Position(4, 4));
        board.removeSpot(new Position(2, 2));
        assertEquals(0, board.countColors(new Position(2, 2)));
    }

    @Test
    public void count_ZigZag_Same_Color() {
        Board board = new Board(5);
        board.putAt(new Block(Colors.RED), new Position(0, 0));
        board.putAt(new Block(Colors.RED), new Position(0, 1));
        board.putAt(new Block(Colors.RED), new Position(1, 1));
        board.putAt(new Block(Colors.RED), new Position(1, 2));
        board.putAt(new Block(Colors.RED), new Position(2, 2));
        board.putAt(new Block(Colors.RED), new Position(2, 3));
        board.putAt(new Block(Colors.RED), new Position(3, 3));
        board.putAt(new Block(Colors.RED), new Position(3, 4));
        board.putAt(new Block(Colors.RED), new Position(4, 4));
        assertEquals(9, board.countColors(new Position(4, 4)));
    }

    @Test
    public void refactorColumn() {
        Board board = new Board(5);
    }
}
