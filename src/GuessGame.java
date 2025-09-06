public class GuessGame
{

    public void StartGame()
    {

        Players p1  = new Players();
        Players p2 = new Players();
        Players p3 = new Players();

        int guessp1 =0 ;
        int guessp2 =0 ;
        int guessp3 =0 ;


        boolean p1isright = false;
        boolean p2isright = false;
        boolean p3isright = false;

        int Target = (int) (Math.random()*10);
        System.out.println("I'm thinking of a number between 0 and 9...");

        while(true)
        {
            System.out.println("Number to guess is " + Target);

            p1.GuesNumber();
            p2.GuesNumber();
            p3.GuesNumber();

            guessp1 = p1.number;
            System.out.println("PLayer one guesssed" + guessp1);

            guessp2 = p2.number;
            System.out.println("Player two guesed" +guessp2);

            guessp3= p3.number;
            System.out.println("Player 3 guessed" + guessp3);



            if(guessp1 == Target)
            {
                p1isright = true;
            }

            if(guessp2 == Target)
            {
                p2isright = true;
            }

            if(guessp3  == Target)
            {
                p3isright = true;
            }


            if(p1isright || p2isright || p3isright)
            {
                System.out.println("We have a winner!");

                System.out.println("Player one got it right? " + p1isright);

                System.out.println("Player two got it right? " + p2isright);

                System.out.println("Player three got it right? " + p3isright);
                System.out.println("We have a winner!");
                System.out.println("Game is over.");
                break;
            }else
            {
                System.out.println("Players will have to try again.");
            }


        }





    }




}
