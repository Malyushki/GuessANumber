import java.util.Random;

public class RandomMassage {

    static void tooLow() {
        Random randomNumber = new Random();
        int randomMassageNumber = randomNumber.nextInt(5);
        String[] tooLow = {"Too Low.", "You need a bigger number", "If I was you I would pick a bigger number",
                "Number you pick is too damn low", "Go bigger or go home"};
        System.out.println(tooLow[randomMassageNumber]);
    }
    static void tooHigh() {
        Random randomNumber = new Random();
        int randomMassageNumber = randomNumber.nextInt(5);
        String[] tooHigh = {"Too High.", "You need a smaller number", "If I was you I would pick a smaller number",
                "Number you pick is too damn high", "Go smaller or go home"};
        System.out.println(tooHigh[randomMassageNumber]);
    }


    }


