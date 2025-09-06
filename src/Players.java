public class Players
{
    int number;



      int GuesNumber()
    {
        this.number = (int)( Math.random() * 10);
        return number;
    }

}
