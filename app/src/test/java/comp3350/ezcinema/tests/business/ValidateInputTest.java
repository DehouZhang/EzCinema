package comp3350.ezcinema.tests.business;

import android.widget.EditText;

import junit.framework.TestCase;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.ValidateInput;


public class ValidateInputTest extends TestCase
{
    private boolean valid;
    String testText1;
    String testText2;
    String testText3;
    ValidateInput isValid;

    public void setUp() throws Exception {
        testText1 = "";
        testText2 = "";
        testText3 = "";
        valid = false;
        isValid = new ValidateInput();
    }

    public void testIsValidCredit() throws Exception
    {
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1 = "abcdefghij";
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1 = "abcdefghi";
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1 = "123456789";
        testText2 = "abcd";
        assertFalse(valid);

        testText1 = "123456789";
        testText2 = "0418";
        assertFalse(valid);

        testText1 = "123456789";
        testText2 = "0418";
        testText3 = "abcd";
        assertFalse(valid);

        testText1 = "123456789";
        testText2 = "0318";
        testText3 = "123";
        assertFalse(valid);

    }

  /*  public void testIsValidPaypal() throws Exception
    {
        testText1.setText("");
        testText2.setText("");
        valid = isValid.isValidPaypal(testText1,testText2);
        assertFalse(valid);

        testText1.setText("abc@");
        valid = isValid.isValidPaypal(testText1,testText2);
        assertFalse(valid);

        testText1.setText("");
        testText2.setText("abcde");
        assertFalse(valid);

        testText1.setText("123414");
        testText2.setText("abcde");
        assertFalse(valid);

        testText1.setText("abc");
        testText2.setText("abcde");
        assertFalse(valid);

        testText1.setText("abc@");
        testText2.setText("abcde");
        assertTrue(valid);
    }

    public void testIsValidScene() throws Exception
    {
        testText1.setText("");
        testText2.setText("");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("123456789");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("");
        testText2.setText("1234");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("abcdefghi");
        testText2.setText("1234");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("abcd");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText2.setText("12345");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("12345678910");
        testText2.setText("1234");
        valid = isValid.isValidScene(testText1,testText2);
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("1234");
        valid = isValid.isValidScene(testText1,testText2);
        assertTrue(valid);
    }

    public void testIsValidDate() throws Exception
    {
        String month;
        String year;

        month = "03";
        year = "18";
        valid = isValid.isValidDate(month,year);
        assertFalse(valid);

        month = "04";
        year = "17";
        valid = isValid.isValidDate(month,year);
        assertFalse(valid);

        month = "02";
        year = "18";
        valid = isValid.isValidDate(month,year);
        assertFalse(valid);

        month = "13";
        year = "18";
        valid = isValid.isValidDate(month,year);
        assertFalse(valid);

        month = "04";
        year = "18";
        valid = isValid.isValidDate(month,year);
        assertTrue(valid);

    }
    */

}