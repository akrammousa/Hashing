import java.util.Random;

public class MatrixMethod {
    int[][] h;
    int b;
    public MatrixMethod (int m ){
        h = new int[(int) Math.ceil(Math.log(m))][32];
        this.b = (int) Math.ceil(Math.log(m));
    }

    public void randomizeHashFunction(){
        Random randomGenerator = new Random();
        for (int i = 0; i<b ; i++) {
            for (int j = 0; j <32 ; j++) {
                int randomInt = randomGenerator.nextInt(1);
                h[i][j] = randomInt;
            }
        }
    }

    public int getIndexOfKey(int key){
        return  0;
    }
}
