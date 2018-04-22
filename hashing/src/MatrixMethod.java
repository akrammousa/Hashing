import java.util.Random;

public class MatrixMethod {
    int[][] h;
    int[][] k;
    int b;

    public MatrixMethod(int m) {
        h = new int[(int) Math.ceil(Math.log(m))][32];
        k = new int[32][1];
        fillZeros(k);
        this.b = (int) Math.ceil(Math.log(m));

    }

    public void randomizeHashFunction() {
        Random randomGenerator = new Random();
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 32; j++) {
                int randomInt = randomGenerator.nextInt(1);
                h[i][j] = randomInt;
            }
        }
    }

    public int getIndexOfKey(int key) {
        String index = "";
        String binaryRepres = Integer.toBinaryString(key);
        int indexInt = 0;
        int[][] ans = new int[b][1];
        int j = 31;
        int size = binaryRepres.length();

        for (int i = size - 1; i >= 0; i--) {
            k[j][0] = binaryRepres.indexOf(i);
            j--;
        }

        ans = multiplyMatricies(h, k);

        for (int i = b - 1; i >= 0; i--) {
            index = ans[i] + index;
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
            for (int j = 0; j < 31; j++) {
                ans = ans + h[i][j] * k[j][0];
            }
            answer[counter][0] = ans;
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