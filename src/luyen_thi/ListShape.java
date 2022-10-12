package luyen_thi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListShape {
    private List<Shape> shapeList;

    public ListShape() {
        shapeList = new ArrayList<>();
    }

    public Shape findShapeByName(String name){
        boolean notExist = true;
        for (Shape shape : shapeList){
            if(name.equals(shape.name)){
                System.out.println(shape);
                notExist = false;
                return shape;
            }
        }
        if(notExist){
            System.out.println("Shape not found");
        }
        return null;
    }

    public void create(){
        System.out.println("Circle or Rectangle(C/R): ");
        Scanner scanner = new Scanner(System.in);
        String typeShape = scanner.next();
        Shape shape = null;
        if(typeShape.equalsIgnoreCase("C")){
            shape = new Circle();
            shape.input();

        }else if(typeShape.equalsIgnoreCase("R")){
            shape = new Rectangle();
            shape.input();
        }
        this.shapeList.add(shape);
    }

    public void add(){
        while(true){
            create();
            System.out.println("Them nua khong(0/1)?");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            if(choose == 0){
                return;
            }
        }
    }

    public void display(){
        for (Shape shape : shapeList){
            System.out.println(shape);
        }
    }

    public void removeShapeByName(String name){
        Shape shape = findShapeByName(name);
        if(shape == null){
            System.out.println("Not found");
        }else{
            shapeList.remove(shape);
        }
    }
}
