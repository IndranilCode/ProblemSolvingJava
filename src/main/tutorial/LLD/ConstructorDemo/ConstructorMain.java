package main.tutorial.LLD.ConstructorDemo;

public class ConstructorMain {
    public void execute() {
        System.out.println("--------------LLD : Day 115: OOP Design Principles--------------");
        System.out.println("----------------------1. CONSTRUCTORS---------------------------");


        //1. No explicit default constructor defined
        System.out.print("1. Student1 (No explicit constructor) default uninitialized values => ");
        Student1 s1_1 = new Student1(); s1_1.display(); //NOTE: If param constructor is defined + no explicit default constructor => this will have compilation error

        //2. Explicit param constructor defined
        //NOTE: Param constructor + No explicit default const => Fails [ new Student2() ]  => Forced to add explicit default const
        System.out.println("2. Student2 (Explicit param constructor) => Forces to add explicit default const [if using new Student2() =>");
        Student2 s2_1 = new Student2();
        //a> Explicit default const
        System.out.print("   a> Explicit default const called => "); s2_1.display();

        //b> Explicit param const
        Student2 s2_2 = new Student2("Indranil", "Nov Int 2021", 99);
        System.out.print("   b> Explicit param const called => "); s2_2.display();

        //c> Explicit param const (exception throw)
        System.out.print("   c> Explicit param const called (Invalid psp - throw exception) => ");
        try {
            Student2 s2_3 = new Student2("Indranil", "Nov Int 2021", 103);
            s2_3.display();
        } catch (Exception ex) {
            System.out.println("Initialization has failed !!");
        }

        //d> Copy Constructor
        System.out.print("   d> Copy constructor demo => ");
        Student2 s2_3 = new Student2("Somrita", "Oct Int 2021", 95);
        Student2 s2_3_copy = new Student2(s2_3); s2_3_copy.display();

        //e> Static Initializer
        Student2 s2_4 = Student2.staticInitialize("Sandeep", "Dec Int 2021", 55);
        System.out.print("   e> Static Initializer demo => "); s2_4.display();

        //3. Private constructor
        System.out.println("3. Student3 with private constructor => Compile error on new Student3()");
        //Student3 s3_1 = new Student3(); // NOT Allowed

        //a> Student3 = private 0 arg const + public param const
        System.out.print("   a> Student3 = private 0 arg const + public param const => ");
        Student3 s3_2 = new Student3("Tutu Basu"); s3_2.display();

        //4. Copying objects from other and manipulating original (Does values change)
        System.out.println("4. [Student4] Copying objects from other and manipulating original (Does values change)");
        //a> Demo copying value and manipulating original
        System.out.print("   a> Demo copying value and manipulating original => ");
        Student4 s4_1 = new Student4("Pradip Basu", 10, 12);
        Student4 s4_2 = new Student4(s4_1);
        s4_1.name = "Pradip Basu 2" ; System.out.print("Original => "); s4_1.display();
        System.out.print("      Duplicated => "); s4_2.display();

        //b> Demo copying value and manipulating original
        System.out.print("   b> Demo copying value and manipulating original [Unclear] => ");
        Student4 s4_3 = new Student4("Pradip Basu", 10, 12);
        Student4 s4_4 = new Student4(s4_3);
        s4_3.name2.append(" 3"); System.out.print("Original => "); s4_3.display();
        System.out.print("      Duplicated => "); s4_4.display();
    }
}
