import static java.lang.Math.PI;

public class Circle extends Shape2D {

    protected double radius;
    protected String name;

    public Circle(double radius){
        this.radius = radius;
        this.name = "circle";
    }

    public double getArea(){
        return (double) radius*radius*Math.PI;
    }

    public String getName(){
        return name;
    }

}
