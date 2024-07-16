package com.project.mathlib;

import com.project.mathlib.Base;
import com.project.mathlib.Power;


public class Area {
	public Area() {
	}
	public static final double PI= 3.141592653589793;
	public static final String POSITIVE_RADIUS = "Value must be a positive radius.";
	public static final String POSITIVE_HEIGHT = "Value must be a positive height.";
	public static final String POSITIVE_BASE = "Value must be a positive base.";
	
	
	public int squareArea(int a) {
		if(a<0) {
			throw new IllegalArgumentException(POSITIVE_BASE);
		}
		return (int) Math.pow(a,2);
	}
	public int rectangleArea(int a,int b) {
		if(a<0 || b<0) {
			throw new IllegalArgumentException(POSITIVE_BASE+POSITIVE_HEIGHT);
		}
		return a*b;
	}
	
	public double circleArea(double r) {
		if(r<0) {
			throw new IllegalArgumentException(POSITIVE_RADIUS);
		}
		return(Math.pow(r, 2)*PI);
	}
	public double triangleArea(double height,double base) {
		if(height<0||base<0) {
			throw new IllegalArgumentException(POSITIVE_BASE+POSITIVE_HEIGHT);
		}
		return (base*height)/2;
	}
	public double parallelogramArea(double base,double height) {
		if(base<0||height<0) {
			throw new IllegalArgumentException(POSITIVE_BASE+POSITIVE_HEIGHT);
		}
		return base*height;
	}
	public double trapeziumArea(double upperBase,double lowerBase,double height) {
		if(upperBase<0 || lowerBase<0 || height<0) {
			throw new IllegalArgumentException(POSITIVE_BASE+POSITIVE_HEIGHT);
		}
		return ((lowerBase+upperBase)*height)/2;
	}
	

	
}
