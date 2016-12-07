package task;

public class Potencia {

	public int base;
	public Integer exponent;

	public Potencia(int base, Integer exponente) {
		this.base = base;
		this.exponent = exponente;
	}
	public Potencia() {
	}
	public int elv(){
		int result=0;
		double resultaux=Math.pow(base, exponent);
		for (int i = 0; i < resultaux; i++) {
			result+=1;
		}
		return result;
	}
	
	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		Potencia potencia = new Potencia();
		double result = 0;
		if(args.length == 2){
			potencia.setBase(Integer.parseInt(args[0]));
			potencia.setExponent(Integer.parseInt(args[1]));
			result = potencia.elv();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(result + ";" + (t2-t1));
	}
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public Integer getExponent() {
		return exponent;
	}
	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}

	

}