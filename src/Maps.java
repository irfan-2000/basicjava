import java.util.HashMap;
import java.util.Map;

public class Maps
{

    public static  void main(String args[])
    {
        Map<String,String> map = new HashMap<>();
       map.put("A1","deepak");
       map.put("A2","Shantanu");


       map.computeIfAbsent("A7",a->{
          return "Compute absent";
       });

        System.out.println(map);
        map.compute("A6", (key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Old Value: " + value);
            return "com";
        });

        System.out.println("last"+map);

        String s = "java";
        s.hashCode();
        System.out.println(s.hashCode());

        String s1 = "java";
        System.out.println(s1.hashCode());

        User u1 = new User("Mohd","irfan");
        User u2 = new User("Mohd","irfan");

        System.out.println( "frist instance"+u1.hashCode());
        System.out.println( "Second instance"+ u2.hashCode());


        System.out.println("last hascode of A1 "+  map.get("A1").hashCode());

    }
}


   class  User
{
    public String firstName;
    public String lastName;
    public User child;

        public User(String firstName,String lastName,User child)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.child = this.child;

        }

    public User(String firstName,String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
