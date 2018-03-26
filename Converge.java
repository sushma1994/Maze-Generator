package com.projectmaze.com;



public class Converge {
	int data;
	boolean leftWall;
	boolean bottomWall;
	//constructors created for all
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean islWall() {
		return leftWall;
	}
	public void setlWall(boolean lWall) {
		this.leftWall = lWall;
	}
	public boolean isbWall() {
		return bottomWall;
	}
	public void setbWall(boolean bWall) {
		this.bottomWall = bWall;
	}
	public Converge(int data, boolean lWall, boolean bWall) {
		super();
		this.data = data;
		this.leftWall = lWall;
		this.bottomWall = bWall;
	}
}

