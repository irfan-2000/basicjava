package Streams;

import java.util.ArrayList;
import java.util.List;

public class Demo
{

    public static  void main (String args[])
    {
        List<String> names = List.of("Alice","bob","Anna","Brian","Alex");
        List<String >result = new ArrayList<>();

        for(String name : names)
        {
            if(name.charAt(0) == 'A')
            {
                result.add(name);
            }
        }

        System.out.println("Before sort" + result);

        result.sort((String n1,String n2) -> n1.compareTo(n2));
        result.sort(String::compareTo);

        System.out.println("After sort" + result);

        //using streams

        List<String> result1 = names.stream()
                        .filter((String val) -> val.charAt(0) == 'A')
                         .sorted(String::compareTo)
                            .toList();


    }


}
