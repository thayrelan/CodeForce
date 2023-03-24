import java.util.Scanner;
/**
 * Team
 */
public class Team {
    private int Petya;
    private int Vasya;
    private int Tonya;

    public int getTonya() {
        return Tonya;
    }
    public int getVasya() {
        return Vasya;
    }
    public int getPetya() {
        return Petya;
    }

    static Scanner scanner = new Scanner(System.in);

    public Team(int petya, int vasya, int tonya){
        this.Petya = petya;
        this.Vasya = vasya;
        this.Tonya = tonya;
    }
    public static boolean compSolutions(Team team){
        int count = 0;

        if(team.getPetya() == 1){
            count++;
        } 
        if(team.getVasya() == 1){
            count++;
        } 
        if(team.getTonya() == 1){
            count++;
        } 

        if(count >= 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int numProblems, totalSolutions = 0;
        boolean willSend;
        numProblems = scanner.nextInt();

        for (int i = 0; i < numProblems; i++) {
            willSend = compSolutions(new Team(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            if(willSend){
                totalSolutions++;
            }
        }
        System.out.println(totalSolutions);
    }
}