import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput() {

        boolean badinput = true;

        System.out.println("Enter Y or N");
        String response = in.nextLine();

        while(true){

            if(response.equalsIgnoreCase("Y")){
                return badinput;
            }
            else{
                return false;
            }


        }

    }


    private static double getUserHeight() {

        while(true){

            System.out.println("Enter User Height:");
            double response = in.nextDouble();
            in.nextLine();

            if(response < 0){
                System.out.println("Value cannot be negative");
            }
            else
                return response;

        }


    }

    private static double getUserWeight() {

        while(true){

            System.out.println("Enter User Weight:");
            double response = in.nextDouble();
            in.nextLine();

            if(response < 0){
                System.out.println("Value cannot be negative");
            }
            else
                return response;
        }

    }


    public static void displayBmiInfo(BodyMassIndex bmi){

        System.out.println("Bmi Info: " + bmi.BMI);
        System.out.println("Bmi Category: " + bmi.response);

    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

        double average, total = 0;

        for(int i = 0; i < bmiData.size(); i++){
            total += bmiData.get(i).BMI;
        }

        average = (double) total/bmiData.size();

        System.out.println("Average: " + average);

    }

}
