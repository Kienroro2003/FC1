package animal_house;


import java.util.*;

public class ManagerAnimal {
    private List<Animal> list = new ArrayList<>();

    public void add(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose cat/ dog/stop(c/d/s/): ");
            String choose = scanner.nextLine();
            if(choose.equals("c")){
                Animal employee = new Cat();
                employee.input();
                list.add(employee);
            }else if(choose.equals("d")){
                Animal manager = new Dog();
                manager.input();
                list.add(manager);
            }else{
                break;
            }
        }
    }
    public void display(){
        for(Animal e : list){
            e.output();
        }
    }

}
