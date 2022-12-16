import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args){
        Scanner readVar = new Scanner(System.in);
        int Number = readVar.nextInt();
        boolean isEven = Number%2 == 0 ? true : false;

        if (isEven) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
