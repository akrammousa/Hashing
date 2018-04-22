import java.util.Random;

public class MatrixMethod {
    int[][] h;
    int[][] k;
    int b;

    public MatrixMethod(int m) {
        this.b = (int) Math.ceil(Math.log(m));
        if(this.b == 0) {
            this.b = 1;
        }
        h = new int[b][32];
        k = new int[32][1];
        fillZeros(k);
        randomizeHashFunction();
    }

    public void randomizeHashFunction() {
        Random randomGenerator = new Random();
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 32; j++) {
                int randomInt = randomGenerator.nextInt(2);
                h[i][j] = randomInt;
            }
        }
    }

    public int getIndexOfKey(int key) {
        if(b==1) {
            return 0;
        }
        String index = "";
        String binaryRepres = Integer.toBinaryString(key);
        int indexInt = 0;
        int[][] ans = new int[b][1];
        int j = 31;
        int size = binaryRepres.length();
        fillZeros(k);
        for (int i = size - 1; i >= 0; i--) {
            String s = String.valueOf(binaryRepres.charAt(i));
            k[j][0] = Integer.parseInt(s);
            j--;
        }

        ans = multiplyMatricies(h, k);

        for (int i = 0; i < b; i++) {
            index += String.valueOf(ans[i][0]);
        }

        indexInt = Integer.parseInt(index, 2);
        return indexInt;
    }

    private int[][] multiplyMatricies(int[][] h2, int[][] k2) {
        // TODO Auto-generated method stub
        int[][] answer = new int[b][1];
        int ans = 0;
        int counter = 0;
        for (int i = 0; i < b; i++) {
            ans = 0;
            for (int j = 0; j < 32; j++) {
                ans = ans + h[i][j] * k[j][0];
            }
            answer[counter][0] = ans % 2;
            counter++;
        }
        return answer;
    }

    private void fillZeros(int[][] array) {
        for (int i = 0; i < 32; i++) {
            array[i][0] = 0;
        }
    }
}