package test.LLD.InheritanceDemo;

import main.tutorial.LLD.InheritenceDemo.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StudentTest {

    @Test
    public void test_studentInstance_basic1() {
        Student s1 = new Student("Indranil", "ib@gmail.com", "INT_NOV21", 73);
        assertEquals("Indranil", s1.getName());
        assertEquals("ib@gmail.com", s1.getEmail());
        assertEquals("INT_NOV21", s1.getBatchName());
        assertEquals(73, s1.getPsp());

        //Update email
        s1.changeEmail("ib2@yahoo.com"); //Method in base class
        assertEquals("ib2@yahoo.com", s1.getEmail());
    }

    @Test
    public void test_studentInstance_basic2_overloadedConstructor() {
        Student s1 = new Student("Pradip", 83);
        assertEquals("Pradip", s1.getName());
        assertNull(s1.getEmail());
        assertNull(s1.getBatchName());
        assertEquals(83, s1.getPsp());
    }
}
