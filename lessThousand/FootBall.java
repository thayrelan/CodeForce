

import java.util.Scanner;

public class FootBall{
    public static void main(String[] args){
        Scanner readVar = new Scanner(System.in);
        //Input
        int n, a, b;
        //Output
        int drawNumber;
        int[][] score;
        
        n = readVar.nextInt();
        a = readVar.nextInt();
        b = readVar.nextInt();


        drawNumber = minimumDraws(n, a, b);
        System.out.println(drawNumber);
        
        if(n == 1){
            System.out.println(a + ":" + b);
        }
        else{
            score = scoreMaker(a, b, n, drawNumber);
            for (int i = 0; i < n; i++) {
                System.out.println(score[0][i] + ":" + score[1][i]);
            }
        }
 
    }
 
    public static int minimumDraws(int n, int a, int b){
        int drawNumber = (n - (a+b));
        boolean isPossible = a + b >= n ? true : false;
        if ((n == 1 && a == b)) {
            return 1;
        }
        if (isPossible && n > 1 || drawNumber < 0){
            return 0;
        }
        return drawNumber;
    }

    public static int scoreFiller(int[]score, int goalScored){
        
        int i=0;
        while (goalScored != 0) {
            score[i] += 1;
            goalScored--;
            if(i+1 == score.length){
                i = 0;
            }
            else{
                i++;
            }
        }
        return goalScored;
    }
    public static boolean scoreRearranger(int[][] score, int i, boolean changeIt){

        if(i+1 == score[0].length){
            if(score[0][i] == score[1][i]){
                score[0][i]--;
                score[0][0]++;
            }
            if(score[0][0] == score[1][0]){
                score[1][0]--;
                score[1][i]++;
            }
            return changeIt;
        }
        if(score[0][i] == score[1][i]){
            score[0][i]--;
            score[0][i+1]++;
            changeIt = true;
        }
        if(score[0][i+1] == score[1][i+1] && changeIt == true){
            score[1][i+1]--;
            score[1][i]++;
        }
        changeIt = false;
        return changeIt;
    }
    public static int[][] scoreMaker(int a, int b, int n, int drawNumber){
        int [][] score = new int[2][n];
        int i=0;
        boolean changeIt;
        
        a = scoreFiller(score[0], a);

        //Fills the score of the opponent team starting from the unfilled scores of a
        while(b != 0){
            while(score[0][i] == score[1][i]){
                score[1][i] += 1;
                b--;
            }
            if(i+1 == n){
                break;
            }
            else{
                i++;
            }
        }
        
        b = scoreFiller(score[1], b);
        
        if(drawNumber == 0){
            for (i = 0; i < n; i++) {
                changeIt = scoreRearranger(score, i, false);
            }
        }
        return score;
    }
}