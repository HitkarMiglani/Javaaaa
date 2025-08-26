

// Write a custom comparator to sort Employees on the basis of their age.


import java.util.*;

class Employee {
    int age;
    String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


public class St2_codes {

    public static void sort(List<Employee> Employee ) {
        Collections.sort(Employee, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2){
                return e1.age - e2.age;
            }
        });
    }


    public static void main(String[] args) {
        Employee e1 = new Employee(20,"A");
        Employee e2 = new Employee(10,"B");
        Employee e3 = new Employee(30,"C");

        List<Employee> arr = new ArrayList<>(Arrays.asList(e1,e2,e3));
        sort(arr);
        System.out.println(arr.getFirst().name+ " " + arr.getFirst().age);
    }

}
