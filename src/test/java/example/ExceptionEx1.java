package example;

import org.testng.annotations.Test;

public class ExceptionEx1 {


    @Test
    public void addition(){
        int a=5;
        int b=0;

        for(int i=1;i<5;i++) {
            try {
                int c = a / b;
                break;
            } catch (RuntimeException e) {
                System.out.println("Element is stale. retrying..");
                //throw new RuntimeException("Stale element exception throwed.");

            }
            System.out.println("i="+i);
        }

    }
}
