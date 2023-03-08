package huawei.od;

import java.util.*;
import java.util.stream.Collectors;

public class HeightWeightSort {
    public static void main(String[] args) {

        List<Student> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(new Student(100 - i, i));
        }

//        Collections.sort(l);

//        Student[] arr = l.toArray(new Student[]{});
//
//        Arrays.sort(arr, (o1, o2) -> o1.getHeight() == o2.getHeight()
//                ? o1.getWeight() - o2.getHeight()
//                : o1.getHeight() - o2.getWeight());
//        Collections.sort(l, (o1, o2) -> o1.getHeight() == o2.getHeight()
//                ? o1.getWeight() - o2.getHeight()
//                : o1.getHeight() - o2.getWeight());

        l = l.stream().sorted(Comparator.comparing(Student::getHeight).thenComparing(Student::getWeight))
                .collect(Collectors.toList());

        for (Student s : l) {
            System.out.println(s);
        }

//        System.out.println("----");
//        for (Student s : arr) {
//            System.out.println(s);
//        }


    }
}

class Student
       // implements Comparable<Student>
{
    private int height;
    private int weight;


    Student(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    @Override
//    public int compareTo(Student s) {
//        return height == s.height
//                ? weight - s.weight
//                : height - s.height;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
