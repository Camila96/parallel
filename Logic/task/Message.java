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
	private String result;
	private String type;

	public Message(String type, ArrayList<Double> exponent, double base) {
		this.type = type;
		this.exponent = exponent;
		this.base = base;
	}

	public Message(String type, String result) {
		this.type = type;
		this.result = result;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
