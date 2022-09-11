package com.tutorial.LLD.ConstructorDemo;

public class Student3 {
    private String name;
    private String batch;
    private int psp;
    private Integer psp2;

    /**
     * Private 0 arg constructor
     */
    private Student3() {
    }

    /**
     * Not allowed to have same signature constructor [Access modifier doesn't matter for signature]
     */
    //    public Student3() {
    //    }

    /**
     * Public param constructor
     * @param name
     */
    public Student3(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(String.format("Name: %s, Batch: %s, PSP(int): %d, PSP(Integer): %d", this.name, this.batch, this.psp, this.psp2));
    }
}
