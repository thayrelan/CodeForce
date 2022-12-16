import java.util.Scanner;

public class WayTooManyWords {
    public static void main(String[] args){
        Scanner readVar = new Scanner(System.in);
        String[] words;
        String trash;
        int totalWords = readVar.nextInt();   
        trash = readVar.nextLine();     
        words = new String[totalWords];
        for (int i = 0; i < totalWords; i++) {
            words[i] = readVar.nextLine();
        }
        
        for (int i = 0; i < totalWords; i++) {
            if(words[i].length() > 10){
                System.out.print(words[i].charAt(0));
                System.out.print(words[i].length() - 2);
                System.out.print(words[i].charAt(words[i].length()-1));
                System.out.println();
            }
            else{
                System.out.println(words[i]);
            }
        }
        readVar.close();
    }
}
