package ProjectManager.src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteStudent {
    void writeFile(){

    }

    public List<SinhVien> readFile(String path){
        File file = new File(path);
        List<SinhVien> list = new LinkedList<>();
        if(file.exists()){
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()){
                    String line = scanner.nextLine();
                    String[] strings = line.split(" ");
                    strings[6] = strings[6].replace("_","/");
                    SinhVien sinhVien = new SinhVien(
                            strings[0],
                            strings[1],
                            strings[2],
                            strings[3],
                            strings[4],
                            Boolean.parseBoolean(strings[5]),
                            new SimpleDateFormat("yyyy/MM/dd").parse(strings[6]),
                            strings[7],
                            strings[8]);
                    list.add(sinhVien);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File không tồn tại");
        }
        return  list;
    }
}
