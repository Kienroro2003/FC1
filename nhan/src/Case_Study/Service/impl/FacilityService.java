package Case_Study.Service.impl;

import Case_Study.Repository.IFacilityRepository;
import Case_Study.Repository.impl.FacilityRepository;
import Case_Study.Service.IFacilityService;
import Case_Study.models.Facility;
import Case_Study.models.House;
import Case_Study.models.Room;
import Case_Study.models.Villa;
import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    IFacilityRepository iFacilityRepository = new FacilityRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addHouse() {
        House house = new House();
        house.input();
        iFacilityRepository.add(house);
    }

    @Override
    public void addRoom() {
        Room room = new Room();
        iFacilityRepository.add(room);
    }

    @Override
    public void addVilla() {
        Villa villa = new Villa();
        villa.input();
        iFacilityRepository.add(villa);
    }

    @Override
    public void add() {

    }

    @Override
    public void display(){
        Map<Facility, Integer> linkedHashMap = iFacilityRepository.findAll();
        for (Map.Entry<Facility,Integer> entry: linkedHashMap.entrySet()) {
            System.out.println(entry);
        }
    }

    @Override
    public void displayMaintenance() {
        Map<Facility, Integer> linkedHashMap = iFacilityRepository.findAll();
        for (Map.Entry<Facility, Integer> entry : linkedHashMap.entrySet()) {
            Room Room=null;
            linkedHashMap.computeIfPresent(Room,(k, v)->v+1);
            System.out.println(entry);
        }
    }
}
