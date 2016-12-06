package test;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import logic.Constant;

public class Prueba {
	private static Scanner scanner;
	static int numberMachine; 
	static double exponent;
	static double   iNumero;

	static int numeroAleatorio;
	public static final int  C=100;
	public static final int  O=1;
	public static ArrayList<Double> weighing(int numberMachine, double exponent){
		Random rnd = new Random();
		ArrayList<Double> arrayList = new ArrayList<Double>();
		for (int i = 0; i < numberMachine; i++) {
			numeroAleatorio= ((int)(Math.random()*100));
			numeroAleatorio =10;
			arrayList.add((double) numeroAleatorio);
		}
		//			  numeroAleatorio = Math.abs((10)+rnd.nextInt(100));
		//			double randNumber = Math.random();
		//			numeroAleatorio = (int) (randNumber * 100);

		//Type cast double to int
		//			int randomInt = numeroAleatorio;
		//			if (numeroAleatorio <= 100) {
		//				numeroAleatorio= (int) (Math.random()*C+O);
		//			}

		//			iNumero = 100;
		//			iNumero= (rnd.nextDouble()*exponent + numberMachine/100.0 );
		////			iNumero = (numberMachine*exponent / 100.0 )*100;
		////			double resultado=(numero*porcentaje)/100;
		////			iNumero= (int) (rnd.nextInt() * numberMachine + exponent);
		//		arrayList.add(3.2);
		//		arrayList.add(1.6);

		return arrayList;
	}


	public double cantidad;
	public double porciento;
	public static double resultado;
	public static void calcularPorcentaje(double porcent, double cant){
		resultado = (porcent / 100) * cant;
		System.out.println("Elrcent% de "+ cant+  " es: " +resultado);
	}
	public static void main(String[] args) {

		int limit=0,num=0,res=0,ciclo,rango=0;
        Random aleatorio=new Random();
        limit=Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el limite de los numeros a sumar:"));
        rango=Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el rango de numeros aleatorios a sumar:"));
        String imprimir="Suma de N numeros aleatorios: \n";
        for(ciclo=0;ciclo<limit;ciclo++){
            num=aleatorio.nextInt(rango);
            imprimir=imprimir+num+"\n";
            res=res+num;
        }
        imprimir=imprimir+"El resultado de la suma es:"+res;
        JOptionPane.showMessageDialog(null,imprimir);
    }
//		scanner = new Scanner(System.in);
//		System.out.print("Introduzca numero de maquinas: ");
//		numberMachine = scanner.nextInt();
//		System.out.print("Introduzca exponente: ");
//		exponent = scanner.nextInt();
//		System.out.println(weighing(numberMachine, exponent));

	

}
