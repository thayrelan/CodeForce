

import java.util.Scanner;

public class FootBall{
    public static void main(String[] args){
        Scanner readVar = new Scanner(System.in);
        //Input
        int n, a, b;
        //Output
        int d;
        int[][] score;

        n = readVar.nextInt();
        a = readVar.nextInt();
        b = readVar.nextInt();

        d = minimumDraws(n, a, b);
        if(d < 0){
            System.out.println("0");
        }
        else{
            System.out.println(d);
        }
        
        if(d == 1 && a == b){
            System.out.println(a + ":" + b);
        }
        else{
            score = scoreMaker(a, b, n, d);
            for (int i = 0; i < n; i++) {
                System.out.println(score[0][i] + ":" + score[1][i]);
            }
        }

    }

    public static int minimumDraws(int n, int a, int b){
        int d;
        boolean totalGoals = a + b < n ? true : false;
        if ((n == 1 && a == b)) {
            return 1;
        }
        if (!totalGoals && n > 1){
            return 0;
        }
        return (n - (a+b));
    }

    public static int[][] scoreMaker(int a, int b, int n, int d){
        int [][] score = new int[2][n];
        int i =0;
        int factor =0;
        while (a != 0) {
            score[0][i] += 1;
            a--;
            if(i+1 == n){
                i = 0;
            }
            else{
                i++;
            }
        }
        i =0;
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
        i=0;
        while(b != 0){
            score[1][i] += 1;
            b--;
            if(i+1 == n){
                i = 0;
            }
            else{
                i++;
            }
        }
        
        if(d == 0){
            for (int j = 0; j < n; j++) {
                if(j+1 == n){
                    if(score[0][j] == score[1][j]){
                        score[0][j]--;
                        score[0][0]++;
                    }
                    if(score[0][0] == score[1][0]){
                        score[1][0]--;
                        score[1][j]++;
                    }
                    break;
                }
                if(score[0][j] == score[1][j]){
                    score[0][j]--;
                    score[0][j+1]++;
                    factor = 1;
                }
                if(score[0][j+1] == score[1][j+1] && factor == 1){
                    score[1][j+1]--;
                    score[1][j]++;
                }
                factor = 0;
            }
        }
        return score;
    }
}