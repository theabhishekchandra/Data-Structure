package queue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueBasic {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.add(new Student("A",4));
        priorityQueue.add(new Student("B",5));
        priorityQueue.add(new Student("C",2));
        priorityQueue.add(new Student("D",12));

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.peek().name + "-> " + priorityQueue.peek().rank);
            priorityQueue.remove();

        }
    }
}
