package example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java03 {
String str="Hello world";
    public Java03(String str){
        this.str=str;
        System.out.println("This is super class constructor"+" "+this.str);
    }

    public static void main(String[] args) {
        //Delete the 3rd element and add 10 instead
        List<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
//        for(int i=0;i<list.size();i++){
//            if(list.get(i)==3){
//                list.remove(i);
//                list.add(i,10);
//
//            }
//        }

        Iterator<Integer> itr=list.iterator();
        while(itr.hasNext()){
            int a=(int)itr.next();
            if(a==3){
                itr.remove();
            }
        }

        System.out.println(list);
    }
}
