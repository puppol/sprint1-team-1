package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Ship> placedShips;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		placedShips = new ArrayList<>();
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		List<Square> occupiedSquares = new ArrayList<>();
		if (isVertical) {
			for (int i = 0; i < ship.getLength(); i++) {
				occupiedSquares.add(new Square(x + i, y));
			}
		} else {
			for (int i = 0; i < ship.getLength(); i++) {
				occupiedSquares.add(new Square(x, (char) ((int)y + i)));
			}
		}
		ship.setLocation(occupiedSquares);
		placedShips.add(ship);
		return true;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		//TODO Implement
		return null;
	}

	public List<Ship> getShips() {
		//TODO implement
		return placedShips;
	}

	public void setShips(List<Ship> ships) {
		//TODO implement
	}

	public List<Result> getAttacks() {
		//TODO implement
		return null;
	}

	public void setAttacks(List<Result> attacks) {
		//TODO implement
	}
}
