package lab7_inheritance.lab08;

public class Main {
	public static void main(String[] args) {
		Complex complex = new Complex(2,1);
		Complex complex2 = new Complex(0,0);
		System.out.println("Add: " + complex.add(complex2));
		System.out.println("Subtract: " + complex.subtract(complex2));
		System.out.println("Multify: " + complex.multify(complex2));
		System.out.println("Divide: " + complex.divide(complex2));
	}
}
