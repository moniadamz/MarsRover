package common;

import java.util.ArrayList;

public class Plateau {

	private int upperRightX;
	private int upperRightY;
	private static int lowerLeftX = 0;
	private static int lowerLeftY = 0;
	private ArrayList<Rover> rovers;

	public Plateau(int x, int y) {
		rovers = new ArrayList<Rover>();
		this.upperRightX = x;
		this.upperRightY = y;
	}
	
	public void insertRover(Rover rover) {
		rovers.add(rover);
	}

	public static int getLowerLeftY() {
		return lowerLeftY;
	}

	public static int getLowerLeftX() {
		return lowerLeftX;
	}

	public int getupperRightX() {
		return upperRightX;
	}

	public int getupperRightY() {
		return upperRightY;
	}

	public void roverStatus() {
		String status = "";
		for (int i = 0; i < rovers.size(); i++) {
			status = rovers.toString() + "\n";
		}
		System.out.println(status);
	}

}
