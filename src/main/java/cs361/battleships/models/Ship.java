package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	@JsonProperty private List<Square> healthSquares;

	private boolean isAlive;

	private String kind;
	private int length;

	public Ship() {
		occupiedSquares = new ArrayList<>();
		healthSquares = new ArrayList<>();
		for(Square s : occupiedSquares) {
			healthSquares.add(s);
		}
		isAlive = true;
	}
	
	public Ship(String kind) {
		this.kind = kind;
		occupiedSquares = new ArrayList<>();
		if (kind.equals("MINESWEEPER")) {
			length = 2;
		} else if (kind.equals("DESTROYER")) {
			length = 3;
		} else if (kind.equals("BATTLESHIP")) {
			length = 4;
		}
		healthSquares = new ArrayList<>();
		for(Square s : occupiedSquares) {
			healthSquares.add(s);
		}
		isAlive = true;
		System.out.println("Creating ship...");
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}

	public void setLocation(List<Square> newOccupiedSquares) {
		if (! occupiedSquares.isEmpty()) {
			occupiedSquares.clear();
		}
		if (!healthSquares.isEmpty()) {
			healthSquares.clear();
		}

		for(int i = 0; i < newOccupiedSquares.size(); i++) {
			occupiedSquares.add(newOccupiedSquares.get(i));
			healthSquares.add(newOccupiedSquares.get(i));
		}
	}

	public int getLength() {
		return length;
	}

	public String getKind() {
		return kind;
	}


	public List<Square> getHealthSquares() {
		return healthSquares;
	}

	public void removeHealthSquare(Square hit) {
		if (healthSquares.size() == 0) {
			this.isAlive = false;
		}

		for (Square s : healthSquares) {
			if (s.isEqual(hit)) {
				healthSquares.remove(s);
			}
		}
	}

	public boolean isAlive() {
		return this.isAlive;
	}
}
