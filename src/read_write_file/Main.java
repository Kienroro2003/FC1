package read_write_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    int[] array;
    void read(String path){
        try {
            Scanner scanner = new Scanner(new File(path));
            int n = scanner.nextInt();
            this.array = new int[n];
            for (int i = 0; i < n; i++) {
                this.array[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void write(String path){
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if(max < array[i]){
                    max = array[i];
                }
            }
            String result = "Max: " + max;
            System.out.println(result);
            fileWriter.write(result);
            fileWriter.append('\n');
            fileWriter.append(""+100);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.read("/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC1/src/read_write_file/input");
        main.write("/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC1/src/read_write_file/output");
    }
}
