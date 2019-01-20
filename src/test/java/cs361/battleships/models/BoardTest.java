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

    @Test
    public void shipHasLength() {
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");
        Ship battleship = new Ship("BATTLESHIP");
        assertTrue(minesweeper.getLength() == 2);
        assertTrue(destroyer.getLength() == 3);
        assertTrue(battleship.getLength() == 4);
    }

    @Test
    public void shipOccupiesMultipleSpaces() {
        Board board = new Board();
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");
        Ship battleship = new Ship("BATTLESHIP");

        board.placeShip(minesweeper, 1, 'A', true);
        board.placeShip(destroyer, 1, 'B', true);
        board.placeShip(battleship, 1, 'C', true);

        assertTrue(board.getShips().get(0).getOccupiedSquares().get(1).isEqual(new Square(2, 'A')));
        assertTrue(board.getShips().get(1).getOccupiedSquares().get(2).isEqual(new Square(3, 'B')));
        assertTrue(board.getShips().get(2).getOccupiedSquares().get(3).isEqual(new Square(4, 'C')));
    }

    @Test
    public void shipDirection() {
        Board board = new Board();
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");

        board.placeShip(minesweeper, 1, 'A', true);
        board.placeShip(destroyer, 2, 'B', false);

        assertTrue(board.getShips().get(0).getOccupiedSquares().get(1).isEqual(new Square(2, 'A')));
        assertTrue(board.getShips().get(1).getOccupiedSquares().get(2).isEqual(new Square(2, 'D')));
    }
}
