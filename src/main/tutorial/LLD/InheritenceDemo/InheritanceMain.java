package main.tutorial.LLD.InheritenceDemo;

public class InheritanceMain {
    public void execute() {
        System.out.println("----------------------2. INHERITANCE----------------------------");

        System.out.print("1. Basic Inheritance 1 => ");
        Student s1 = new Student("Indranil", "ib@gmail.com", "INT_NOV21", 73);
        System.out.print(String.format("Original => [ Name : %s, Email : %s, Batch : %s, PSP : %d ] ;", s1.getName(), s1.getEmail(), s1.getBatchName(), s1.getPsp()));
        s1.changeEmail("ib2@yahoo.com"); //Method in base class
        System.out.println(String.format(" Updated => [ Name : %s, Email : %s, Batch : %s, PSP : %d ]", s1.getName(), s1.getEmail(), s1.getBatchName(), s1.getPsp()));

        System.out.print("2. Basic Inheritance 2 (Other overloaded constructor) => ");
        Student s2 = new Student("Pradip", 83);
        System.out.print(String.format("Original => [ Name : %s, Email : %s, Batch : %s, PSP : %d ] ;", s2.getName(), s2.getEmail(), s2.getBatchName(), s2.getPsp()));
    }
}
