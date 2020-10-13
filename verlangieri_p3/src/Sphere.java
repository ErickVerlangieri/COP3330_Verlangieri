import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class Sphere extends Shape3D{

    protected double radius;
    protected String name;

    public Sphere(double radius){
        this.radius = radius;
        this.name = "sphere";
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return (double) 4 * Math.PI * Math.pow(radius,2);
    }

    public double getVolume(){
        return (double) ((double)(4.0/3.0) * Math.PI * Math.pow(radius,3));
    }

}
