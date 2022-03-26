import java.util.Random;

public class Die {

    private Random random;

    public Die(){
        random = new Random();
    }


    public int rollDie6(){
        return random.nextInt(6)+1;
    }
}