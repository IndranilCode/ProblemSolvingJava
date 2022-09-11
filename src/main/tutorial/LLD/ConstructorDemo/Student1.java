package main.tutorial.LLD.ConstructorDemo;

public class Student1 {
    private String name;
    private String batch;
    private int psp;
    private Integer psp2;

    public void display() {
        System.out.println(String.format("Name: %s, Batch: %s, PSP(int): %d, PSP(Integer): %d", this.name, this.batch, this.psp, this.psp2));
    }
}
