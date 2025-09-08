import java.util.Arrays;

public class deepequalarray {
    //here we will be seeing the deepEquals method for 2d arrays 
    public static class Employee{
        int i;
        String n;

        public Employee(int i,String n){
            this.i=i;
            this.n=n;
        }

        @Override
        public boolean equals(Object obj){
            if(this== obj){
                return true;
            }
// getclass() method from object class
//int[] arr = new int[9]  arr.getclass() : class [I which means array of integer

            if(obj== null || getClass()!=obj.getClass()) return false;
            Employee e = (Employee) obj;
            return i == e.i && n.equals(e.n);
        }
    }
    public static void main(String[] args){
        Employee e1[][] = { { new Employee(10, "Geek1"),
                              new Employee(11, "Geek2") },
                            { new Employee(12, "Geek3"),
                              new Employee(13, "Geek4") } };

        Employee e2[][] = { { new Employee(10, "Geek1"),
                              new Employee(11, "Geek2") },
                            { new Employee(12, "Geek3"),
                              new Employee(13, "Geek4") } };

        Employee e3[][] = { { new Employee(12, "Geek2"),
                              new Employee(25, "Geek4") },
                            { new Employee(15, "Geek3"),
                              new Employee(30, "Geek1") } };
    System.out.println("e1 is equal to e2: " + Arrays.deepEquals(e1, e2));
    System.out.println("e2 is equal to e3: " + Arrays.deepEquals(e2, e3));
    System.out.println("e1 is equal to e3: " + Arrays.deepEquals(e1, e3));



    }
}
