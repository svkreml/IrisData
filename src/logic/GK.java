package logic;

import Jama.Matrix;

import java.util.Vector;

/**
 * Created by svkreml on 05.10.2016.
 */
public class GK {

    public static void main(String[] args) {
        Vector<Iris> irises;
        FileManager file = new FileManager("iris.data.txt");
        irises = file.irisload();
        System.out.println("irises = " + irises);
        double[][] x = new double[irises.size()][4];
        for (int i = 0; i < irises.size(); i++) {
            x[i] = irises.get(i).getRow();
        }
        Matrix X = new Matrix(x);
        int m = X.getColumnDimension();
        int n = X.getRowDimension();
        int k = 2;
        Matrix q = new Matrix(m, 1, 1.0);
        double eps = 0.001;
        for (int j = 1; j <= k; j++) {
            q = q.arrayLeftDivide(q.transpose().times(q));
            double ind = 1;
            Matrix q0 = (Matrix) q.clone();
            while (ind > eps) {
                q0 = q;

            }
        }
    }

    double eps = 0.001;

    public Comp solve(Matrix X, int u, int k) {
        Comp comp = new Comp();
        int n = X.getRowDimension();
        int m = X.getColumnDimension();
        Matrix G;
        if (u == 1) G = X.transpose().times(X);
        else G = X; //(u==2)
        Vector<Double> L = new Vector<>();
        Vector<Vector<Double>> Q = new Vector<>();
        Matrix q;
        for (int j = 1; j <= k; j++) {
            q = new Matrix(m, 1, 1);
            q = q.solve(sqrt(q.transpose().times(q)));
            double ind = 1;
            Matrix s = new Matrix(0,0);
            while (ind > eps) {
                Matrix q0 = q;
                s = sqrt(q.transpose().times(G).times(G).times(q));//s=sqrt(q'*G*G*q);
                q = G.times(q).solve(s);
                ind=q0.minus(q).norm1();
            }
            Vector D= new Vector();
            for (Double d:
                    q.getArray()[0]) {
                    D.add(d);
            }
            Q.add(D);
           L.add(s.get(0,0));// L=[L,s];
            G=G.minus(s.times(q).times(q.transpose()));
        }
        int inf = 0;
        //for(int i=1;i<=k;i++)
        //    inf+=L.
        //inf=sum(L(1:k))/trace(X'*X);
        inf = 1;
        Matrix P;
        Matrix diag = new Matrix(0,0);
        diag.identity(L.size(),L.size());
     !!!   if(u==1) P=X*Q*diag(1./sqrt(L));
        else P=Q;
        return comp;
    }

    class Comp {
        public Matrix P;
        public Matrix Q;
        public Matrix L;
        public double inf;
    }
    static Matrix diag(Matrix A){

        return A;
    }
    static Matrix sqrt(Matrix A) {
        double[][] a = A.getArrayCopy();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = Math.sqrt(a[i][j]);
        A = new Matrix(a);
        return A;
    }
}
