/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinh_nhan;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class employeeList {
    private ArrayList<employee> list = new ArrayList<>();
    private int currentIndex = -1;
    public void first(){
        if(currentIndex>0){
            currentIndex =0;
        }
    }
    public void next(){
        if(currentIndex<list.size() -1){
            currentIndex ++;
    }
    }
    public void last(){
    if(currentIndex<list.size() -1){
            currentIndex =list.size() -1;}}
    public void previous(){
        if(currentIndex>0){
            currentIndex =0;
        }
    }
    
    public int getCurrentEmployeeIndex(){
    return currentIndex;
    }
    public employee getCurrentEmployee(){
    if(list.size()==0)
        return null;
    return list.get(currentIndex);}
    public void add(employee emp){
        list.add(emp);
    }
    public void renderToTable(DefaultTableModel tb1Model){
        tb1Model.setRowCount(0);
        for(employee employee: list){
            Object [] row = new Object[]{
                employee.getEmployeeId(),employee.getName(),employee.getAge(),employee.getEmail(),employee.getSalary()};
        tb1Model.addRow(row);    
        }
        tb1Model.fireTableDataChanged();
    }
    public employee findById(String employeeId){
       for(employee employee :list){
           if(employee.getEmployeeId().equals(employeeId)){
               return employee;
           }
           
       }
       return null;
    }
    public boolean update (employee emp){
        employee existedemp = findById(emp.getEmployeeId());
        boolean flag = false;
         if(existedemp!=null) {
            existedemp.setName(emp.getName());
            existedemp.setAge(emp.getAge());
            existedemp.setEmail(emp.getEmail());
            existedemp.setSalary(emp.getSalary());
            flag = true;
            
            
        }
        return flag;
    }
    
    public boolean deleteById(String employeeId){
        for(employee employee :list){
            if(employee.getEmployeeId().equals(employeeId)){
                list.remove(employee);
                return true;
            }
        }
        return false;
    }

  
        
            
    
}
