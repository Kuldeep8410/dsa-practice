import java.util.Comparator;
import java.util.PriorityQueue;
public class priorityqueue{
    static class Student implements Comparable<Student>{              // it gives special power to compare the objects of the class
        String name;
        int rank;
        public Student(String name,int rank){
            this.name= name ;
            this.rank = rank;

        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args){
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());  
        pq.add(new Student("Ankit",4));
        pq.add(new Student("Gaurav",3));
        pq.add(new Student("Kuldeep",5));
        pq.add(new Student("Gagan",2));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +" ->" + pq.peek().rank);
            pq.remove();
        }

    }
}