package com.siva.mircoservice.limitservice.bean;

public class Limits {
	private int mininum;
	private int maximum;
	
	public Limits() {
		// TODO Auto-generated constructor stub
	}

	public int getMininum() {
		return mininum;
	}

	public void setMininum(int mininum) {
		this.mininum = mininum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

	public Limits(int mininum, int maximum) {
		super();
		this.mininum = mininum;
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return "Limits [mininum=" + mininum + ", maximum=" + maximum + "]";
	}
	
	
	
}
