package cs361.battleships.models;

import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testInvalidPlacement() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 11, 'C', true));
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 1, 'J', false));
    }


    @Test
    public void testShipInBoard() {
        Board board = new Board();
        Ship placedShip = new Ship("MINESWEEPER");
        board.placeShip(placedShip, 1, 'A', true);
        assertTrue(board.getShips().size() == 1);
    }

    @Test
    public void testSquaresEqual() {
        Square square1 = new Square(2, 'B');
        Square square2 = new Square(2, 'B');
        Square square3 = new Square(1, 'A');
        assertTrue(square1.isEqual(square2));
        assertTrue(square2.isEqual(square1));
        assertFalse(square1.isEqual(square3));
    }

    @Test
    public void testShipOccupiesSpace() {
        Board board = new Board();
        Square occupiedSquare = new Square(1, 'A');
        Ship placedShip = new Ship("MINESWEEPER");
        board.placeShip(placedShip, occupiedSquare.getRow(), occupiedSquare.getColumn(), true);
        assertTrue(occupiedSquare.isEqual(board.getShips().get(0).getOccupiedSquares().get(0)));
    }

    @Test
    public void testShipHasLength() {
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");
        Ship battleship = new Ship("BATTLESHIP");
        assertTrue(minesweeper.getLength() == 2);
        assertTrue(destroyer.getLength() == 3);
        assertTrue(battleship.getLength() == 4);
    }

    @Test
    public void testShipOccupiesMultipleSpaces() {
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
    public void testShipDirection() {
        Board board = new Board();
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");

        board.placeShip(minesweeper, 1, 'A', true);
        board.placeShip(destroyer, 2, 'B', false);

        assertTrue(board.getShips().get(0).getOccupiedSquares().get(1).isEqual(new Square(2, 'A')));
        assertTrue(board.getShips().get(1).getOccupiedSquares().get(2).isEqual(new Square(2, 'D')));
    }

    @Test
    public void testShipsOverlap() {
        Board board = new Board();
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");
        Ship battleship = new Ship("BATTLESHIP");

        assertTrue(board.placeShip(minesweeper, 1, 'B', true));
        assertFalse(board.placeShip(destroyer, 1, 'B', false));
        assertFalse(board.placeShip(battleship, 1, 'A', false));
    }

    @Test
    public void testHitShip() {
        Board board = new Board();
        Ship destroyer = new Ship("MINESWEEPER");
        board.placeShip(destroyer, 1, 'B', false);

        Result result = board.attack(1, 'B');
        assertTrue(result.getResult() == AtackStatus.HIT);
    }

    @Test
    public void testMissShip() {
        Board board = new Board();
        Ship destroyer = new Ship("MINESWEEPER");
        board.placeShip(destroyer, 1, 'B', false);

        Result result1 = board.attack(1, 'A');
        Result result2 = board.attack(1, 'D');
        assertTrue(result1.getResult() == AtackStatus.MISS && result2.getResult() == AtackStatus.MISS);
    }

    @Test
    public void testSinkShip() {
        Board board = new Board();
        Ship minesweeper = new Ship("MINESWEEPER");
        Ship destroyer = new Ship("DESTROYER");
        board.placeShip(minesweeper, 1, 'B', false);
        board.placeShip(destroyer, 3, 'A', false);

        board.attack(1, 'B');
        Result result = board.attack(1, 'C');
        assertTrue(result.getResult() == AtackStatus.SUNK);
    }

    @Test
    public void testSurrender() {
        Board board = new Board();
        Ship destroyer = new Ship("MINESWEEPER");
        board.placeShip(destroyer, 1, 'B', false);

        board.attack(1, 'C');
        Result result = board.attack(1, 'B');
        assertTrue(result.getResult() == AtackStatus.SURRENDER);
    }

}
