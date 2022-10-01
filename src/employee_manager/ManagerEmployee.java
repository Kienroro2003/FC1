//package employee_manager;
//
//import java.util.*;
//
//public class ManagerEmployee {
//    private List<Employee> list = new ArrayList<>();
//
//    public void add(){
//        while(true){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Choose employee/ manager/stop(e/m/s/): ");
//            String choose = scanner.nextLine();
//            if(choose.equals("e")){
//                Employee employee = new Employee();
//                employee.input();
//                list.add(employee);
//            }else if(choose.equals("m")){
//                Manager manager = new Manager();
//                manager.input();
//                list.add(manager);
//            }else{
//                break;
//            }
//        }
//    }
//    public void display(){
//        for(Employee e : list){
//            System.out.println(e.getClass().getSimpleName());
//            e.output();
//        }
//    }
//
//    public void sortByName(){
//        Collections.sort(list,Comparator.comparing(Employee::getName));
//        display();
//    }
//
//    public void sortBySalary(){
//        Collections.sort(list,Comparator.comparing(Employee::calculateSalary));
//        display();
//    }
//
//    public void displayManager(){
//        for (Employee e : list){
//            if(e instanceof Manager){
//                e.output();
//            }
//        }
//    }
//}
