public class Square extends Shape2D{

    protected double base;
    protected String name;

    public Square(double b){
        this.base = b;
        this.name = "square";
    }

    public double getArea(){
        return base*base;
    }

    public String getName(){
        return name;
    }

}
