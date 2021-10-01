
import java.util.ArrayList;
import java.util.Random;


public class Puzzling {
    public static void main(String[] args) {

        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
        for (int i = 0; i <= 20; i++) {
            randomRolls.add(i);
        }
        System.out.println(randomRolls);

        Random r = new Random();
        ArrayList<Integer> randomizer = new ArrayList<Integer>();
        for (int j = 1; j <= 10; j++) {
            int getRandom = r.nextInt(21);
            randomizer.add(getRandom);
        }

        System.out.println(randomizer);


        ArrayList<Character> letters = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            letters.add(ch);
        }

        System.out.println(letters);

        Random z = new Random();
        int getLetter = z.nextInt(26);
        System.out.println(letters.get(getLetter));

      
        
        for (int i = 1; i <= 8; i++) {
            int getLetters = z.nextInt(26);
            System.out.print(letters.get(getLetters));
        }
        

        ArrayList<Character> alphabet = new ArrayList<Character>();
        ArrayList<String> wordage = new ArrayList<String>();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }

        String s = "";
        Random a = new Random ();


        for(int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 8; i++) {
                int getword = a.nextInt(26);
                s = s + Integer.toString(alphabet.get(getword));
            }
            wordage.add(s);

        }
        System.out.println(wordage);
        
        


    }


}
