package com.projectmaze.com;


public class Wall {
	int leftcell;
	int rightcell;
	public int getLeftcell() {
		return leftcell;
	}
	public Wall(int leftcell, int rightcell) {
		super();
		this.leftcell = leftcell;
		this.rightcell = rightcell;
	}
	public void setLeftcell(int lcell) {
		this.leftcell = lcell;
	}
	public int getRightcell() {
		return rightcell;
	}
	public void setRightcell(int rightcell) {
		this.rightcell = rightcell;
	}
}
