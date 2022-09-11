package main.tutorial.oops;

public class Example {

    public void Main() {
        System.out.println("-----------OOPS Basics-------------");
        //1. Simplest
        Peacock p1 = new Peacock();
        p1.dance(); //Spread Wings
        p1.speak(); //Something

        //2.
        Tiger t1 = (Tiger) new Animal();
        t1.speak();

    }


    //------------------------------------------------------------------------------

    public class Animal {
        void speak() {
            System.out.println("Something");
        }
    }

    public class Tiger extends Animal {

    }

    public class Bird extends Animal {
        @Override
        void speak() {
            System.out.println("Something");
        }

        void fly() {
            System.out.println("Flap wings");
        }
    }

    public class Peacock extends Bird {
        void dance() {
            System.out.println("Spread Wings");
        }
    }

}

