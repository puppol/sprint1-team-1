package cs361.battleships.models;

public class Result {
	private AtackStatus status;
	private Ship ship;
	private Square loc;

	public AtackStatus getResult() {
		return this.status;
	}

	public void setResult(AtackStatus result) {
		this.status = result;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Square getLocation() {
		return this.loc;
	}

	public void setLocation(Square square) {
		this.loc = square;
	}
}
