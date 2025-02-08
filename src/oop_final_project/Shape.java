package oop_final_project;

import java.util.Date;

public abstract class Shape implements Drawable {
	
	private Date dateCreated;
	private String Color;
	
	public Shape () {	
	}
	
	public Shape(String Color) {
		this.Color = Color;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getColor() {
		return Color;
	}
	
	public void setColor(String Color) {
		this.Color = Color;
	}
	
	public abstract double getArea();
	public abstract double getPeremiter();
	
}
