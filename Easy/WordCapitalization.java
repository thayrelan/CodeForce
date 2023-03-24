import java.util.Scanner;

public class WordCapitalization{

    static Scanner scanner = new Scanner(System.in);
    public static String WordCapitalization(String word){
        String capWord = word.substring(0, 1).toUpperCase() + word.substring(1);
        return capWord;
    }


    public static void main(String[] args) {
        String capWord;
        capWord = WordCapitalization(scanner.nextLine());
        System.out.println(capWord);
    }
}