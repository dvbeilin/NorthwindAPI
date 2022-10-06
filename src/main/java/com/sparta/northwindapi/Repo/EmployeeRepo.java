package com.sparta.northwindapi.Repo;

import com.sparta.northwindapi.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private List<Employee> list = null;
    private static EmployeeRepo repo = null;
    public static EmployeeRepo getInstance(){
        if(repo == null) {
            repo = new EmployeeRepo();
            repo.list = new ArrayList<>();
        }
        return repo;
    }
    private EmployeeRepo(){}
    public void add(Employee e){
        list.add(e);
    }

    public Employee get(int index){
        try {
            return list.get(index);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    public String toString(){
        return list.toString();

    }
    public List<Employee> getList(){
        return list;
    }

}
