package com.tutorial.LLD.ConstructorDemo;

public class Student2 {
    private String name;
    private String batch;
    private int psp;
    private Integer psp2;

    /**
     * NOTE: Forced to add this if using [ new Student() ] & if param constructor is added
     */
    public Student2() {
    }

    /**
     * NOTE : If explicit param constructor is defined + no explicit default constructor
     * Then Student s1 = new Student(); will not compile
     * @param name
     * @param batch
     * @param pspInt
     */
    public Student2(String name, String batch, int pspInt) {
        this.name = name;
        this.batch = batch;

        if (pspInt < 0 || pspInt > 100) {
            throw new RuntimeException("Invalid PSP");
        }
        this.psp = pspInt;
    }

    /**
     * Copy Constructor
     * @param original
     */
    public Student2(Student2 original) {
        this.name = original.name;
        this.batch = original.batch;
        this.psp = original.psp;
        this.psp2 = original.psp2;
    }

    /**
     * Static initializer
     * @param name
     * @param batch
     * @param pspInt
     * @return
     */
    public static Student2 staticInitialize(String name, String batch, int pspInt) {
        return new Student2(name, batch, pspInt);
    }

    public void display() {
        System.out.println(String.format("Name: %s, Batch: %s, PSP(int): %d, PSP(Integer): %d", this.name, this.batch, this.psp, this.psp2));
    }
}
