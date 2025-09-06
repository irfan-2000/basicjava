import static java.lang.System.out;

public class ConsumeFunctionalInterface
{
    public static  void main(String[] args)
    {
        FunctionInterface m =   (a,b) -> {
                    return a +b ;
         };


        FunctionInterface g = (a,b) ->{
            return a+b;
        };

        out.println( m.doSomething(3,4));
        g.doSomething(5,6);
    }
}
