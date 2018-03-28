package comp3350.ezcinema.business;

public class CalculateTax {

    private double gst;
    private double pst;
    private double total;

    public CalculateTax() {
        gst = 0.05;
        pst = 0.08;
        total = 0;
    }


    public double priceWithTax(double value){
        
        this.total = value+((value*this.gst)+(value*this.pst));

        return total;
    }

    public double getGst()
    {
        return this.gst;
    }

    public double getPst()
    {
        return this.pst;
    }

}
