package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import comp3350.ezcinema.business.CalculateTax;


public class CalculateTaxTest extends TestCase
{
    private double total;
    private double price;
    private double tax;
    private double pst;
    private double gst;
    private CalculateTax CalcTax;

    public void setUp() throws Exception {
        total = 0.0;
        tax = 0.0;
        price = 0.0;
        CalcTax = new CalculateTax();
        pst = CalcTax.getPst();
        gst = CalcTax.getGst();
    }

    public void testCalculateTax() throws Exception
    {
        price = 100.0;
        total = CalcTax.priceWithTax(price);
        assertEquals(113.0, total);

        tax = total-price;
        assertEquals(13.0,tax);

        price = 0.0;
        total = CalcTax.priceWithTax(price);
        assertEquals(0.0,total);

        assertEquals(.08, pst);
        assertEquals(.05, gst);
    }

}