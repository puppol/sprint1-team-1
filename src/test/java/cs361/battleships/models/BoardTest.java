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
        Ship minesweeper = new Ship("MINESWEEPER");
        board.placeShip(minesweeper, 1, 'B', false);

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
