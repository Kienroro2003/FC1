package lab7_inheritance.lab08;

import java.util.Scanner;

public class Complex extends Number<Complex>{
	private float thuc;
	private float ao;
	
	public Complex() {
	}

	public Complex(float thuc, float ao) {
		super();
		this.thuc = thuc;
		this.ao = ao;
	}
	
	

	public float getThuc() {
		return thuc;
	}

	public void setThuc(float thuc) {
		this.thuc = thuc;
	}

	public float getAo() {
		return ao;
	}

	public void setAo(float ao) {
		this.ao = ao;
	}

	@Override
	public Complex add(Complex param) {
		Complex complex = new Complex();
		complex.thuc = this.thuc + param.thuc;
		complex.ao = this.ao + param.ao;
		return complex;
	}

	@Override
	public Complex multify(Complex param) {
		Complex complex = new Complex();
		complex.thuc = this.thuc * param.thuc - this.ao * param.ao;
		complex.ao = this.thuc * param.ao - param.thuc * this.ao;
		return complex;
	}

	@Override
	public Complex subtract(Complex param) {
		Complex complex = new Complex();
		complex.thuc = this.thuc - param.thuc;
		complex.ao = this.ao - param.ao;
		return complex;
	}

	@Override
	public Complex divide(Complex param) {
		Complex complex = new Complex();
		complex.thuc = (float) ((this.thuc * param.thuc + this.ao * param.ao) / ((Math.pow(param.thuc, 2) + Math.pow(param.ao, 2))));
		if(param.thuc == 0 && param.ao == 0) {
			System.out.println("Vui long nhap lai so thuc: ");
			Scanner scanner = new Scanner(System.in);
			param.setAo(Float.parseFloat(scanner.nextLine()));
			param.setThuc(Float.parseFloat(scanner.nextLine()));
		}
		complex.ao = (float) ((this.ao * param.thuc - this.thuc * param.ao) / ((Math.pow(param.thuc, 2) + Math.pow(param.ao, 2))));
		return complex;
	}
	
	@Override
	public String toString() {
		return this.thuc + (this.ao < 0 ? " - " + Math.abs(this.ao) + "i":(this.ao == 0 ? "" : " + " +this.ao + "i"));
	}

	
}
