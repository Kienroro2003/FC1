package equation;

public class QuadraticEquation extends SimpleEquation {
    private int numberA;

    public QuadraticEquation() {
    }

    public QuadraticEquation(int numberA, int numberB, int numberC) {
        super(numberB, numberC);
        this.numberA = numberA;
    }

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    private int calDental() {
        int dental = (int) (Math.pow(this.numberA, 2) - 4 * this.numberA * this.numberA);
        return dental;
    }

    private void findTwoRootEquation(int dental) {
        float x1 = (-this.numberA - (float) Math.sqrt(dental)) / (2 * this.numberA);
        float x2 = (-this.numberA + (float) Math.sqrt(dental)) / (2 * this.numberA);
        System.out.println("Phuong trinh co 2 nghiem la: " + x1 + " " + x2);
    }

    private void findDoubleRoot(int dental) {
        float x = -this.numberA / (float) this.numberA * 2;
        System.out.println("Nghiem kep phuong trinh la: " + x);
    }


    public void calQuadraticEquation() {
        if (this.numberA == 0) {
            super.solveSimpleEquation();
        } else {
            int dental = calDental();
            if (dental > 0) {
                findTwoRootEquation(dental);
            } else if (dental == 0) {
                findDoubleRoot(dental);
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}
