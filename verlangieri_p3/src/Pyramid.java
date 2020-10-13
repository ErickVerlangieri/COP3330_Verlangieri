import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Pyramid extends Shape3D{

    protected double length, width, height;
    protected String name;

    public Pyramid(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = "pyramid";
    }

    public double getArea(){
        return (double) length*width + length * Math.sqrt(Math.pow((width/2), 2) + Math.pow(height,2)) + width * Math.sqrt(Math.pow((length/2), 2) + Math.pow(height,2));
    }

    public String getName(){
        return name;
    }

    public double getVolume(){
        return (double)(length * width * height)/3;
    }

}
