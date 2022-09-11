package com.tutorial.LLD.ConstructorDemo;

public class Student4 {
    public String name;
    public StringBuilder name2 = new StringBuilder();
    public int psp;
    public Integer psp2;

    public Student4(String name, int psp, Integer psp2) {
        this.name = name;
        this.name2.append(name);
        this.psp = psp;
        this.psp2 = psp2;
    }

    public Student4(Student4 st) {
        this.name = st.name;
        this.psp = st.psp;
        this.psp2 = st.psp2;
        this.name2.append(st.name);
    }

    public void display() {
        System.out.println(String.format("Name: %s, PSP(int): %d, PSP(Integer): %d, Name2 : %s", this.name, this.psp, this.psp2, this.name2.toString()));
    }
}
