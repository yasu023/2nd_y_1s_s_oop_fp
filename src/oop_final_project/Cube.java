package oop_final_project;

public class Cube extends ThreeDshape {
	
	private double side;
	
	public Cube(double side) {
		this.side = side;
	}
	
	public Cube(double side, String Color) {
		super(Color);
		this.side = side;
	}
	
	@Override
	public String toString() {
		return "Cube{" + "side=" + side +'j';
	}

	@Override
	public String HowToPaint() {
		return "cube";
	}

	@Override
	public double getVolume() {
		return Math.pow(side, 3);
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(side, 2);
	}

	@Override
	public double getPeremiter() {
		return 12 * side;
	}

}
