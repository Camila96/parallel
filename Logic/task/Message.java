package task;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double base;
	private ArrayList<Double> exponent;

	public Message(ArrayList<Double> exponent, double base) {
		this.exponent = exponent;
		this.base = base;
	}

	@Override
	public String toString() {
		return "Base: "+ base+ " Exponent"+ exponent;
	}
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public ArrayList<Double> getExponent() {
		return exponent;
	}

	public void setExponent(ArrayList<Double> exponent) {
		this.exponent = exponent;
	}
}
