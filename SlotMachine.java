import java.util.*;
import java.util.concurrent.TimeUnit;

public class SlotMachine {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome... to the AmAzInG TrAsHy CaSiNo");
        System.out.println("Please Enter: Your Money, Bet Amount, and End Goal!");
        
        System.out.println();
        System.out.println();
        
        double pocketMoney = scanner.nextDouble();
        double roundBet = scanner.nextDouble();
        double goal = scanner.nextDouble();

        System.out.println();
        System.out.println();
        System.out.println("Welcome to The House Casino!");

        boolean canPlay = canPlay(pocketMoney, roundBet);	//1d

        if (canPlay == false) {

            System.out.println("Not enough money to play this slot machine! You have: " + formatMoney(pocketMoney) + " and the round bet is: " + formatMoney(roundBet) + " Come back later!");
            System.exit(0);
        }

        boolean goalReached = goalReached(pocketMoney, goal);	//1e

        if (goalReached == true)    {

            System.out.println("You have " + formatMoney(pocketMoney) + " and your goal was: " + formatMoney(goal) + ". You must stop playing!");
            System.exit(0);
        }

        int roundNumber = 1;
        double startPocketMoney = pocketMoney;
        
        for (int game = 0; game != 1000000; game++) {          //Operate Game

            
            if (goalReached == false) {

                System.out.println("You are playing round " + roundNumber);
                roundNumber++;
            }

            int[] Diceroll = new int[3];
            for (int i = 0; i <= 2; i++) {

                Diceroll[i] = diceRoll();

            }
            String[] Symbols = new String[3];
            for (int i = 0; i <= 2; i++) {

                Symbols[i] = getSymbol(Diceroll[i]);
            }

            System.out.println();
            System.out.println("| " + Symbols[0] + " || " + Symbols[1] + " || " + Symbols[2] + " |");
            System.out.println();
            
            int returnMultiplier = getMultiplier(Diceroll[0], Diceroll[1], Diceroll[2]);    //1c
            
            double currentPocketMoney = startPocketMoney - roundBet;

            double betResult = roundBet * returnMultiplier;

            currentPocketMoney = currentPocketMoney + betResult;

            System.out.println("You now have: " + formatMoney(currentPocketMoney));
            System.out.println();
            
            startPocketMoney = currentPocketMoney;
            
            if (currentPocketMoney < roundBet) {
            	
            	System.out.println("Sorry, you ran out of money! You end up with " + formatMoney(currentPocketMoney));
            	System.exit(0);
            }
            
            if (currentPocketMoney >= goal)	{
            	
            	System.out.println("Congratulations, you now have " + formatMoney(currentPocketMoney) + "! Time to celebrate!");
            	System.exit(0);
            }
            
            System.out.println("------------------------------------------------------------");
            
            TimeUnit.SECONDS.sleep(1);
        }


        
        
    }

static String getSymbol(int Diceroll) {

    String[] Fruits = new String[7];	//1b

    Fruits[0] = "Cherries";
    Fruits[1] = "Oranges";
    Fruits[2] = "Plums";
    Fruits[3] = "Bells";
    Fruits[4] = "Melons";
    Fruits[5] = "Bars";
    Fruits[6] = "ERROR";

    String Symbol1 = Fruits[Diceroll];

    return (Symbol1);
}


	static String formatMoney(double value)   {

        String Num = String.format("$%.2f", value);

        return Num;

}

    static int diceRoll()	{	//1a

        int diceRoll = (int) (Math.random() *6);
        int rounded = (int) Math.floor(diceRoll);

        return rounded;

    }

    static boolean canPlay(double money, double bet)	{ //1d

        if (money >= bet)	{
            return true;
        } else {
            return false;
        }
    }

    static boolean goalReached(double pocket, double goal)	{	//1e

        if (pocket >= goal) {
            return true;
        } else	{
            return false;
        }
    }

    static int getMultiplier(int Num1, int Num2, int Num3) {

        int getMultiplier = 0;
        if (Num1 == Num2 || Num1 == Num3 || Num2 == Num3) {

            getMultiplier = 2;
        }
        if (Num1 == Num2 && Num1 == Num3){

            getMultiplier = 3;
        }
        if (Num1 == 3 && Num2 == 3 && Num3 == 3)	{

            getMultiplier = 5;
        }	
        

        return getMultiplier;
    }
    }