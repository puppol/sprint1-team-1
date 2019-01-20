package cs361.battleships.models;

import org.junit.Test;

import javax.validation.constraints.AssertTrue;

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

    @Test
    public void squaresEqual() {
        Square square1 = new Square(2, 'B');
        Square square2 = new Square(2, 'B');
        Square square3 = new Square(1, 'A');
        assertTrue(square1.isEqual(square2));
        assertTrue(square2.isEqual(square1));
        assertFalse(square1.isEqual(square3));
    }

    @Test
    public void shipOccupiesSpace() {
        Board board = new Board();
        Square occupiedSquare = new Square(1, 'A');
        Ship placedShip = new Ship("MINESWEEPER");
        board.placeShip(placedShip, occupiedSquare.getRow(), occupiedSquare.getColumn(), true);
        assertTrue(occupiedSquare.isEqual(board.getShips().get(0).getOccupiedSquares().get(0)));
    }
}
