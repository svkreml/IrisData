package logic;

import Jama.Matrix;

/**
 * Created by svkreml on 17.10.2016.
 */
public class test {
    public static void main(String[] args) {
        double [][]x = new double[][]{{1,4,3},{4,5,6},{7,8,9}};
        Matrix X = new Matrix(x);
        X.print(3,3);
        Matrix Y;
              Y  = sqrt(X);
        Y.print(3,3);
    }
    static Matrix sqrt(Matrix A){
        double[][] a = A.getArrayCopy();
        for(int i=0;i<a.length;i++)
        for (int j=0;j<a[0].length;j++)
            a[i][j]=Math.sqrt(a[i][j]);
        A = new Matrix(a);
        return A;
    }
}
