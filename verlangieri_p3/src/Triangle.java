public class Triangle extends Shape2D {

    protected double base, height;
    protected String name;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
        this.name = "triangle";
    }

    public double getArea(){
        return (base * height)/2;
    }

    public String getName(){
        return name;
    }

}
