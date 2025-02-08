package oop_final_project;

public abstract class ThreeDshape extends Shape {
	public ThreeDshape() {
		
	}
	
	public ThreeDshape(String Color) {
		super(Color);
	}
	
	public abstract double getVolume();
}
