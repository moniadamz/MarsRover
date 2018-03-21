package common;

public class Rover {
	private char direction;
	private int positionX;
	private int positionY;
	private int lowerLimitPositionX;
	private int lowerLimitPositionY;
	private int upperLimitPositionY;
	private int upperLimitPositionX;

	public Rover(int inicialPositionX, int inicialPositionY, int lowerLimitPositionX, int lowerLimitPositionY, char inicialDirection, int upperLimitPositionX, int upperLimitPositionY) {
		positionX = inicialPositionX;
		positionY = inicialPositionY;
		direction = inicialDirection;
		this.lowerLimitPositionX = lowerLimitPositionX;
		this.lowerLimitPositionY = lowerLimitPositionY;
		this.upperLimitPositionX = upperLimitPositionX;
		this.upperLimitPositionY = upperLimitPositionY;
	}

	public void control(char command) throws Exception{
		if (command == 'M') {
			move();
			return;
		} 
		if (command  == 'L') {
			turnLeft();
			return;
		} 
		if (command  == 'R') {
			turnRight();
			return;
		} 
		throw new MinhaException("Command is not valid!");
	}

	private void turnLeft() {
		if (this.direction == 'N') {
			this.direction = 'W';
			return;
		} 
		if (this.direction == 'W') {
			this.direction = 'S';
			return;
		} 
		if (this.direction == 'S') {
			this.direction = 'E';
			return;
		} 
		if(this.direction == 'E'){
			this.direction = 'N';
			return;
		}
	}

	private void turnRight() {
		if (this.direction == 'N') {
			this.direction = 'E';
			return;
		} 
		if (this.direction == 'E') {
			this.direction = 'S';
			return;
		}
		if (this.direction == 'S') {
			this.direction = 'W';
			return;
		}
		if (this.direction == 'W'){
			this.direction = 'N';
			return;
		}
	}

	private void move() {
		if (euConsigoIrParaONorte()) {
			this.positionY += 1;
			return;
		} 
		if (this.direction == 'E' && positionX < upperLimitPositionX) {
			this.positionX += 1;
			return;
		}
		if (this.direction == 'S' && positionY > lowerLimitPositionY) {
			this.positionY -= 1;
			return;
		} 
		if (this.direction == 'W' && positionX > lowerLimitPositionX){
			this.positionX -= 1;
			return;
		} 
	}

	public boolean euConsigoIrParaONorte() {
		return this.direction == 'N' && positionY < upperLimitPositionY;
	}

	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public char getDirection() {
		return this.direction;
	}

	public String toString() {
		return ("(" + getPositionX() + ", " + getPositionY() + ", " + getDirection() + ")");
	}
}
