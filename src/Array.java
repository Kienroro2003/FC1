import java.util.Scanner;

public class Array {
    private int[] array;
    private int n;
    private Scanner scanner = new Scanner(System.in);

    public Array() {
    }

    public void inputArray(){
        System.out.println("Enter n: ");
        this.n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter array["+i+"]: ");
            array[i] = scanner.nextInt();
        }
    }

    public void outputArray(){
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if(i != array.length - 1){
                System.out.print(", ");
            }
        }
    }

    public int findMax(){
        int max = this.array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public int findMin(){
        int min = this.array[0];
        for(int i = 1 ; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public int threeMultiple(){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 3 == 0){
                count++;
            }
        }
        return count;
    }

    public boolean find(int x){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == x){
                return true;
            }
        }
        return false;
    }

    public int findMinSecond(){
        int min = findMin();
        int minSecond = findMax();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == min){
                continue;
            }else if(minSecond > array[i]){
                minSecond = array[i];
            }
        }
        return minSecond;
    }

    public int multiplyTwoNumbersMax(){
        int max = array[0] * array[1];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(max < array[i] * array[j]){
                    max = array[i] * array[j];
                }
            }
        }
        return max;

    }

    public void reverseArray(){
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[array.length - 1 - i];
        }
    }

    public boolean isGraduationArray(){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetricalArray(){
        for (int i = 0 ; i < array.length / 2 ; i++){
            if(array[i] != array[array.length - 1 - i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
