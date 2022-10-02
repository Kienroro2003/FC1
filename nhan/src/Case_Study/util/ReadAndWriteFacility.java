package Case_Study.util;

import Case_Study.Service.impl.FacilityService;
import Case_Study.models.Facility;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadAndWriteFacility {

    public Map<Facility, Integer> readFacility(String filePath) {
        Map<Facility, Integer> linkedHashMap = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            linkedHashMap = (Map<Facility, Integer>) ois.readObject();

        } catch (EOFException e) {
            linkedHashMap = new LinkedHashMap<>();
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
        return linkedHashMap;
    }

    public void writeFacility(Map<Facility, Integer> linkedHashMap, String filePath) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(linkedHashMap);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Loi file ghi");
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
