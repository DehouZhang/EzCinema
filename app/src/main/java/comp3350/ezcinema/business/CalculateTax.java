package comp3350.ezcinema.business;

public class CalculateTax {

    public static double calcTax(double value){

        double total;
        double gst = 0.05;
        double pst = 0.08;

        total = value+((value*gst)+(value*pst));

        return total;
    }

}
