package model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteStudent {

    void writeFile(List<SinhVien> sinhVienList, String path) {
        File file = new File(path);
        FileOutputStream outputStream = null;
        PrintStream printStream = null;
        try {
            outputStream = new FileOutputStream(file);
            printStream = new PrintStream(file);
            SimpleDateFormat formatter = new SimpleDateFormat("yyy/MM/dd");
            for (int i = 0; i < sinhVienList.size(); i++) {
                printStream.print(
                        sinhVienList.get(i).getMaSV() + " "+
                                sinhVienList.get(i).getTenSV().replace(" ","_") + " " +
                                sinhVienList.get(i).getEmail().replace(".","_") + " " +
                                sinhVienList.get(i).getSDT() + " " +
                                (sinhVienList.get(i).isGioiTinh() ? "true" : "false") + " " +
                                sinhVienList.get(i).getCCCD() + " " +
                                formatter.format(sinhVienList.get(i).getNgaySinh()).replace("/","_") + " " +
                                sinhVienList.get(i).getQueQuan().replace(" ", "_") + " " +
                                sinhVienList.get(i).getDiaChi().replace(" ","_") + "\n"
                );

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                outputStream.close();
                printStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<SinhVien> readFile(String path) {
        File file = new File(path);
        List<SinhVien> list = new LinkedList<>();
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] strings = line.split(" ");
                    strings[6] = strings[6].replace("_", "/");
                    SinhVien sinhVien = new SinhVien(
                            strings[0],
                            strings[1].replace('_', ' '),
                            strings[2].replace('_', '.'),
                            strings[3],
                            strings[5],
                            Boolean.parseBoolean(strings[4]),
                            new SimpleDateFormat("yyyy/MM/dd").parse(strings[6]),
                            strings[7].replace('_', ' '),
                            strings[8].replace('_', ' '));
                    list.add(sinhVien);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File không tồn tại");
        }
        return list;
    }

    public static void main(String[] args) {
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        ReadAndWriteStudent readAndWriteStudent = new ReadAndWriteStudent();
        readAndWriteStudent.writeFile(sinhVienDAO.ls, "src/data/temp");
    }
}
