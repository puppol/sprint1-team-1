package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

/*    @Test
    public void testInvalidPlacement() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 11, 'C', true));
    }
*/

    @Test
    public void shipInBoard() {
        Board board = new Board();
        Ship placedShip = new Ship("MINESWEEPER");
        board.placeShip(placedShip, 1, 'A', true);
        assertTrue(board.getShips().size() == 1);
    }
}
