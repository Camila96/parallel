package task;

public class Potencia {

	public double base;
	public double exponent;

	public double elv(){
//		double result=0;
		double resultaux = Math.pow(base, exponent);
//		for (int i = 0; i < resultaux; i++) {
//			result+=1;
//		}
		return resultaux;
	}
	
	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		Potencia potencia = new Potencia();
		double result = 0;
		
			potencia.setBase(2);
			potencia.setExponent(1.6);
			result = potencia.elv();
		
		long t2 = System.currentTimeMillis();
		System.out.println(result + ";" + (t2-t1));
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getExponent() {
		return exponent;
	}

	public void setExponent(double exponent) {
		this.exponent = exponent;
	}

	}