import java.util.*;

public class Player {

    private String name;
    private static Die die = new Die();

    public Player(String name){
        this.name = name;
    }

    public int takeTurn(){

        Scanner sc = new Scanner(System.in);
        System.out.println(name+"'s turn: ");
        System.out.println(name+" please click enter to roll the die");
        String input = sc.nextLine();

        int val = 0;
        for (int i = 0; i < input.length(); i++){
            val+= input.charAt(i);
        }
        val = val % 10;
        if (val == 0){
            val = 1;
        }

        for (int i = 0; i < val; i++){
            die.rollDie6();
        }

        int rolledValue = 0;
        rolledValue = die.rollDie6();

        System.out.println(name + " rolled " + rolledValue + ".");
        return rolledValue;
    }

    public String toString(){
        return name;
    }
}
