package logic;

/**
 * Created by svkreml on 05.10.2016.
 */
public class Iris {
    double sepalLength;
    double sepalWidth;
    double petalLength;
    double petalWidth;
    String name;
    Iris(){
        sepalLength =0;
        sepalWidth = 0;
        petalLength = 0;
        petalWidth = 0;
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String name) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.name = name;
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.name= "undefined";
    }
    public Iris(String line) {
        if(line.length()>15) {
            this.sepalLength = new Double(line.substring(0, 3));
            this.sepalWidth = new Double(line.substring(4, 7));
            this.petalLength = new Double(line.substring(8, 11));
            this.petalWidth = new Double(line.substring(12, 15));
            this.name = line.substring(16, line.length());
        }
        else ;
    }
    @Override
    public String toString() {
        return "Iris{"
                 + sepalLength +
                ", " + sepalWidth +
                ", " + petalLength +
                ", " + petalWidth +
                ", '" + name + '\'' +
                '}';
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getName() {
        return name;
    }
    public double[] getRow() {
        return new double[]{sepalLength, sepalWidth, petalLength, petalWidth};
    }
}
