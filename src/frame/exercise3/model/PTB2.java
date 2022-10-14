package frame.exercise3.model;

public class PTB2 {
    private double a, b, c, x1, x2;
    private String answer;

    public PTB2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void timNghiem(){
        if(a == 0 && b == 0 && c ==0 ){
            answer = "Phuong trinh vo so nghiem";
        }else{
            double delta = b * b - 4 * a * c;
            if(delta < 0){
                this.answer = "Phuong trinh vo nghiem";
            }else if(delta == 0){
                x1 = x2 = -b / 2 / a;
                this.answer = "Phuong trinh co nghiem kep x1 = x2 = " + x1;
            }else{
                x1 = -b - Math.sqrt(delta) / 2/ a;
                x2 = -b + Math.sqrt(delta) / 2/ a;
                this.answer = "x1 = " + x1 + "\nx2 = "  + x2;
            }
        }
    }

    public String getAnswer(){
        return this.answer;
    }
}
