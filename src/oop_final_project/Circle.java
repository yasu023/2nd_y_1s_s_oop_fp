package oop_final_project;

public class Circle extends Shape {
	
	private double rad;
	
	public double getRad() {
		return rad;
	}
	
	public Circle(double rad, String Color) {
		super(Color);
		this.rad = rad;
	}
	
	public Circle(double rad) {
		super();
		this.rad = rad;
	}
	
	public void setRad(double rad) {
		this.rad = rad;
	}
	
	@Override
	public String toString() {
		return "Circle{ Color =" + super.getColor() + " date = "+ super.getDateCreated() + "rad=" + 'j';
	}

	@Override
	public String HowToPaint() {
		return "Circle";
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.rad, 2);
	}

	@Override
	public double getPeremiter() {
		return 2 * Math.PI * this.rad;
	}

}
