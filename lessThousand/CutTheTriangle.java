import java.util.Scanner;

public class CutTheTriangle {
 
    public static class Triangle{
        private int[] x = new int[3];
        private int[] y = new int[3];
    
        public int getX(int position) {
            return x[position];
        }
        public int getY(int position) {
            return y[position];
        }
        
        //Get the information regarding the points that make the triangle
        public void setDomains(Scanner readVar){     
            readVar.nextLine();
            this.x[0] = readVar.nextInt();
            this.y[0] = readVar.nextInt();
            this.x[1] = readVar.nextInt();
            this.y[1] = readVar.nextInt();
            this.x[2] = readVar.nextInt();
            this.y[2] = readVar.nextInt();
            
        }

        //Verify if one of the other points is lower or higher than the present one
        public boolean areDiffX(int i, int j, boolean isLower){
 
            if(isLower){
                if(this.getX(i) < this.getX(j)){
                    return true;
                }
            }else{
                if(this.getX(i) > this.getX(j)){
                    return true;
                }
            }
     
            return false;
        }
        //Verify if one of the other points is lower or higher than the present one
        public boolean areDiffY(int i, int j, boolean isLower){
     
            if(isLower){
                if(this.getY(i) < this.getY(j)){
                    return true;
                }
            }else{
                if(this.getY(i) > this.getY(j)){
                    return true;
                }
            }
     
            return false;
        }
    
        //Verify if from the X axes two new triangles can ensurge
        public boolean compareTriangleDomain(int i, int j, int k){
    
            boolean hasDomain = false;
            boolean hasCodomain = false;
    
            hasDomain = areDiffX(i, j, true);
            hasCodomain = areDiffX(i, k, false);
            if(hasDomain == true && hasCodomain == true){
                return true;
            }
     
            hasDomain = areDiffX(i, j, false);
            hasCodomain = areDiffX(i, k, true);
            if(hasDomain == true && hasCodomain == true){
                return true;
            }
    
            return false;
        }
        
        //Verify if from the Y axes two new triangles can ensurge
        public boolean compareTriangleCodomain(int i, int j, int k){
    
            boolean hasDomain = false;
            boolean hasCodomain = false;
    
            hasDomain = areDiffY(i, j, true);
            hasCodomain = areDiffY(i, k, false);
            if(hasDomain && hasCodomain){
                return true;
            }
     
            hasDomain = areDiffY(i, j, false);
            hasCodomain = areDiffY(i, k, true);
            if(hasDomain && hasCodomain){
                return true;
            }
     
            return false;
        }
        
        //Verify if from a certain point of a triangle can be produced two new triangles
        public boolean cutTriangle(int i, int j, int k){
     
           boolean halveTriangleX = compareTriangleDomain(i, j, k);
           boolean halveTriangleY = compareTriangleCodomain(i, j, k);
           if(halveTriangleX || halveTriangleY){
                return true;
           }
           return false;
     
        }

        //Verify if a triangle can produce two new triangles
        public void checkCut(){

            boolean canCut = false;
            boolean hasntCut = true;

            canCut = cutTriangle(0, 1, 2);
            if(canCut == true && hasntCut == true){
                System.out.println("YES");
                hasntCut = false;
            }
            canCut = cutTriangle(1, 0, 2);
            if(canCut == true && hasntCut == true){
                System.out.println("YES");
                hasntCut = false;
            }
            canCut = cutTriangle(2, 1, 0);
            if(canCut == true && hasntCut == true){
                System.out.println("YES");
            }
            else if(hasntCut == true){
                System.out.println("NO");
            }
           
        }
    }
 
    public static void main(String[] args){

        //Variables
        Scanner readVar = new Scanner(System.in);
        int totalTests = readVar.nextInt();
        Triangle[] nonDegenerateTriangles = new Triangle[totalTests];

        
        
        //Input
        for (int i = 0; i < totalTests; i++) {
            nonDegenerateTriangles[i] = new Triangle();
            nonDegenerateTriangles[i].setDomains(readVar);
        }
        
        //Output
        for (int i = 0; i < nonDegenerateTriangles.length; i++) {
            nonDegenerateTriangles[i].checkCut();
        }
    } 
    
}