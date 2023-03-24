import java.util.Scanner;

public class Translation {
    public static String reverseWord(String word){

        StringBuilder revWord = new StringBuilder(word);
        revWord.reverse();
        return revWord.toString();
    }
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String revWord = reverseWord(scanner.nextLine());
        String wort_t = scanner.nextLine();
        
        if(wort_t.equals(revWord)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
