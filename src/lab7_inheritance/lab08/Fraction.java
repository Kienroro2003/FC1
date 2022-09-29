package lab7_inheritance.lab08;

public class Fraction extends Number<Fraction>{
	private int tu;
	private int mau;
	
	public Fraction() {
	}

	public Fraction(int tu, int mau) {
		this.tu = tu;
		this.mau = mau;
	}

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public int getMau() {
		return mau;
	}

	public void setMau(int mau) {
		this.mau = mau;
	}


	@Override
	public Fraction add(Fraction param) {
		Fraction fraction = new Fraction();
		fraction.tu = this.tu * param.mau + param.tu * this.mau;
		fraction.mau = this.mau * param.mau;
		return fraction;
	}

	@Override
	public Fraction multify(Fraction param) {
		Fraction fraction = new Fraction();
		fraction.tu = this.tu * param.tu;
		fraction.mau = this.mau * param.mau;
		return fraction;
	}

	@Override
	public Fraction subtract(Fraction param) {
		Fraction fraction = new Fraction();
		fraction.tu = this.tu * param.mau - param.tu * this.mau;
		fraction.mau = this.mau * param.mau;
		return fraction;
	}

	@Override
	public Fraction divide(Fraction param) {
		Fraction fraction = new Fraction();
		fraction.tu = this.tu * param.mau;
		fraction.mau = this.mau * param.tu;
		return fraction;
	}

	@Override
	public String toString() {
		return this.tu + "/" + this.mau;
	}
	
	

	

}
