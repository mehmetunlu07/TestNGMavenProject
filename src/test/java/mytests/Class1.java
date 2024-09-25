package mytests;

import org.testng.annotations.Test;

public class Class1 {
    @Test(priority=1)
    public void method1(){
        System.out.println("I am inside class1 - method1");
    }

    @Test(priority=2)
    public void method2(){
        System.out.println("I am inside class1 - method2");
    }
    //new line ---------------
    //next line
    //3rd line----------------
}
