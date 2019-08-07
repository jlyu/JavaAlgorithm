package CodingRush._47_Array2D_GetGiftMaxValue;

public class GetGiftMaxValueFrom2DArray {

    public int getGiftMaxValue(int[][] a) {

        final int rows = a.length;
        if (rows <= 0) { return 0; }

        final int cols = a[0].length;
        if (cols <= 0) { return 0; }

        int[][] values = new int[rows][cols]; //使用相同行列的二维数组

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int down = 0;

                if (i > 0) { down = values[i-1][j]; }
                if (j > 0) { left = values[i][j-1]; }

                values[i][j] = Math.max(down, left) + a[i][j];

            }
        }
        int maxValue = values[rows - 1][cols - 1];
        return maxValue;
    }
    public int getGiftMaxValueV2(int[][] a) {
        final int rows = a.length;
        if (rows <= 0) { return 0; }

        final int cols = a[0].length;
        if (cols <= 0) { return 0; }

        int[] values = new int[cols]; //辅助数组只用一行的
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int down = 0;

                if (i > 0) { down = values[j]; }
                if (j > 0) { left = values[j-1]; }

                values[j] = Math.max(down, left) + a[i][j];
            }
        }
        return values[cols-1];
    }


    void unitTest1() {
        int[][] a = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println( getGiftMaxValue(a) == getGiftMaxValueV2(a) );
    }

    public static void main(String[] args) {
        GetGiftMaxValueFrom2DArray g = new GetGiftMaxValueFrom2DArray();
        g.unitTest1();
    }
}
