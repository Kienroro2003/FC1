package Case_Study.util;

import Case_Study.models.Booking;
import Case_Study.models.Facility;

import java.io.*;
import java.util.*;

public class ReadAndWriteBooking {


    public Set<Booking> readBooking(String filePath) {
        Set<Booking> bookingSet = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            bookingSet = (Set<Booking>) ois.readObject();

        } catch (EOFException e) {
            bookingSet = new TreeSet<>();
        } catch (IOException e) {
            System.out.println("Loi file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
//                ois.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return bookingSet;
    }

    public void writeBooking(Set<Booking> bookingSet, String filePath) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookingSet);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
