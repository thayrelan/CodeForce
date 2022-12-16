import java.util.Scanner;



public class CutTheTriangle {

    public static class Triangle{
        int[] x = new int[3];
        int[] y = new int[3];
    
        public int getX(int position) {
            return x[position];
        }
        public void setX(int position, int value) {
            this.x[position] = value;
        }
        public int getY(int position) {
            return y[position];
        }
        public void setY(int position, int value) {
            this.y[position] = value;
        }
    }

    public static void main(String[] args){
        Scanner readVar = new Scanner(System.in);
        int totalTests = readVar.nextInt();
        boolean cutIt = false;
        boolean factor = true;
        Triangle[] nonDegenerateTriangles = new Triangle[totalTests];
        String Trash;
    
        for (int i = 0; i < totalTests; i++) {
            nonDegenerateTriangles[i] = new Triangle();
            Trash = readVar.nextLine();
            nonDegenerateTriangles[i].setX(0, readVar.nextInt());;
            nonDegenerateTriangles[i].setY(0, readVar.nextInt());;
            nonDegenerateTriangles[i].setX(1, readVar.nextInt());;
            nonDegenerateTriangles[i].setY(1, readVar.nextInt());;
            nonDegenerateTriangles[i].setX(2, readVar.nextInt());;
            nonDegenerateTriangles[i].setY(2, readVar.nextInt());;
        }

        for (int i = 0; i < nonDegenerateTriangles.length; i++) {
            cutIt = cutTriangle(nonDegenerateTriangles[i], 0, 1, 2);
            if(cutIt == true && factor == true){
                System.out.println("YES");
                factor = false;
            }
            cutIt = cutTriangle(nonDegenerateTriangles[i], 1, 0, 2);
            if(cutIt == true && factor == true){
                System.out.println("YES");
                factor = false;
            }
            cutIt = cutTriangle(nonDegenerateTriangles[i], 2, 1, 0);
            if(cutIt == true && factor == true){
                System.out.println("YES");
            }
            else if(cutIt == false && factor == true){
                System.out.println("NO");
            }
            factor = true;
        }
    }
    public static boolean conditioningTriangleX(int comparer, int compared, boolean type, Triangle nonDegeneratTriangles){

        boolean isTrue = false;

        if(type == true){
            if(nonDegeneratTriangles.getX(comparer) < nonDegeneratTriangles.getX(compared)){
                isTrue = true;
                return isTrue;
            };
        }else{
            if(nonDegeneratTriangles.getX(comparer) > nonDegeneratTriangles.getX(compared)){
                isTrue = true;
                return isTrue;
            };
        }

        return isTrue;
    }
    public static boolean conditioningTriangleY(int comparer, int compared, boolean type, Triangle nonDegeneratTriangles){

        boolean isTrue = false;

        if(type == true){
            if(nonDegeneratTriangles.getY(comparer) < nonDegeneratTriangles.getY(compared)){
                isTrue = true;
                return isTrue;
            };
        }else{
            if(nonDegeneratTriangles.getY(comparer) > nonDegeneratTriangles.getY(compared)){
                isTrue = true;
                return isTrue;
            };
        }

        return isTrue;
    }
    public static boolean cutTriangle(Triangle nonDegeneratTriangles, int i, int j, int k){

        boolean isPossible = false;
        boolean isPossibleToo = false;

        isPossible = conditioningTriangleX(i, j, true, nonDegeneratTriangles);
        isPossibleToo = conditioningTriangleX(i, k, false, nonDegeneratTriangles);
        if(isPossible == true && isPossibleToo == true){
            return true;
        }

        isPossible = conditioningTriangleX(i, j, false, nonDegeneratTriangles);
        isPossibleToo = conditioningTriangleX(i, k, true, nonDegeneratTriangles);
        if(isPossible == true && isPossibleToo == true){
            return true;
        }

        isPossible = conditioningTriangleY(i, j, true, nonDegeneratTriangles);
        isPossibleToo = conditioningTriangleY(i, k, false, nonDegeneratTriangles);
        if(isPossible == true && isPossibleToo == true){
            return true;
        }

        isPossible = conditioningTriangleY(i, j, false, nonDegeneratTriangles);
        isPossibleToo = conditioningTriangleY(i, k, true, nonDegeneratTriangles);
        if(isPossible == true && isPossibleToo == true){
            return true;
        }

        return false;

    }
}
