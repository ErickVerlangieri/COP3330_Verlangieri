import java.lang.Math;
import java.util.ArrayList;

public class BodyMassIndex {

    double BMI;
    String response;

    public BodyMassIndex(double height, double weight) {

        math(height,weight);
        cat(BMI);

    }

    public double math(double height, double weight){

        BMI = (double) (703 * weight) / Math.pow(height,2);
        return Math.round(BMI * 100.0)/100.0;

    }

    public String cat(double BMI){

        if(BMI < 18.5){
            response = "Underweight";
        }
        if(BMI >= 18.5 && BMI < 24.9){
            response = "Normal weight";
        }
        if(BMI >= 25 && BMI < 29.9){
            response = "Overweight";
        }
        if(BMI >= 30){
            response = "Obesity";
        }

        return response;

    }
}
