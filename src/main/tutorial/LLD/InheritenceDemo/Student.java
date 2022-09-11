package main.tutorial.LLD.InheritenceDemo;

import lombok.Getter;
import lombok.Setter;

//@Data //NOTE : @Data needs default constructor in base class
@Getter
@Setter
public class Student extends User {
    private String batchName;
    private int psp;

    public Student(String name, String email, String batch, int psp) {
        super(name, email); //Call base class constructor => Parent has @AllArgsConstructor
        this.batchName = batch;

        if (psp < 0 || psp > 100) {
            throw new RuntimeException("Invalid PSP !");
        }
        this.psp = psp;
    }

    public Student(String name, int psp) {
        super(name, null); //Call base class constructor
        this.batchName = null;

        if (psp < 0 || psp > 100) {
            throw new RuntimeException("Invalid PSP !");
        }
        this.psp = psp;
    }

    //    public void display() {
    //        System.out.println(String.format("Name: %s, Batch: %s, PSP(int): %d, PSP(Integer): %d", this.name, this.batch, this.psp, this.psp2));
    //    }
}
