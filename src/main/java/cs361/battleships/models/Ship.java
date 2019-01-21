package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private String kind;
	private int length;

	public Ship() {
		occupiedSquares = new ArrayList<>();
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
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}

	public void setLocation(List<Square> newOccupiedSquares) {
		if (! occupiedSquares.isEmpty()) {
			occupiedSquares.clear();
		}
		for(int i = 0; i < newOccupiedSquares.size(); i++) {
			occupiedSquares.add(newOccupiedSquares.get(i));
		}
	}

	public int getLength() {
		return length;
	}

	public String getKind() {
		return kind;
	}
}
