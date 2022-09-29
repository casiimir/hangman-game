import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = {"ant", "badger", "bat", "bear", "beaver", "camel",
                "cat", "clam", "cobra", "cougar", "coyote", "crow",
                "dog", "donkey", "duck", "eagle", "fox", "frog", "goat",
                "hawk", "lion", "lizard", "mole", "monkey",
                "mouse", "mule", "newt", "owl", "panda", "pigeon",
                "python", "ram", "rat", "raven","rhino", "salmon", "seal",
                "shark", "skunk", "sloth", "snake", "spider", "stork", "swan",
                "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                "wombat", "zebra"};

        String[] gallows = {"+---+\n" +
                "|   |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "=========\n",

                "+---+\n" +
                        "|   |\n" +
                        "O   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n",

                "+---+\n" +
                        "|   |\n" +
                        "O   |\n" +
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n",

                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|   |\n" +
                        "     |\n" +
                        "     |\n" +
                        " =========\n",

                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                        "     |\n" +
                        "     |\n" +
                        " =========\n",

                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +
                        "/    |\n" +
                        "     |\n" +
                        " =========\n",

                " +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +
                        "/ \\  |\n" +
                        "     |\n" +
                        " =========\n"};

        int gallowsIndex = 0;
        String userLetter = "";
        String randomWord = words[(int)(Math.random() * (words.length - 2))];
        String[] wordWas = new String[randomWord.length()];
        System.out.println("Welcome gamer! Put your first choice... be careful!");

        do {
            System.out.print("\nGuess:\t");
            userLetter = scan.next();

            if (searchIn(randomWord, userLetter) >= 0) {
                System.out.println(gallows[gallowsIndex]);
                wordWas[searchIn(randomWord, userLetter)] = userLetter;
            } else {
                gallowsIndex++;
                System.out.println(gallows[gallowsIndex]);
            }

            System.out.print("\nWord:\t");
            System.out.print(arrToStr(wordWas).replace("", " "));

            if (gallowsIndex == 6) {
                System.out.println("\nRIP");
                System.out.println("The word was " + randomWord);
                break;
            }

            if (arrToStr(wordWas).equals(randomWord)) {
                System.out.println("\nGOOD WORK");
                System.out.println("The word was " + randomWord);
                break;
            }
        } while (true);

        scan.close();
    }
    public static int searchIn(String string, String letter) {
        for (int i = 0; i < string.length(); i++) {
            if (String.valueOf(string.charAt(i)).equals(letter))
                return i;
        }
        return -1;
    }
    public static String arrToStr(String[] arr) {
        return Arrays.toString(arr)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .replace("null", "_");
    }
}
