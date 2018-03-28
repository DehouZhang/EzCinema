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

    public void testIsValidPaypal() throws Exception
    {
        testText1 = "";
        testText2 = "";
        valid = isValid.isValidPaypal(testText1,testText2);
        assertFalse(valid);

        testText1 = "abc@";
        valid = isValid.isValidPaypal(testText1,testText2);
        assertFalse(valid);

        testText1 = "";
        testText2 = "abcde";
        assertFalse(valid);

        testText1 = "123414";
        testText2 = "abcde";
        assertFalse(valid);

        testText1 = "abc";
        testText2 = "abcde";
        assertFalse(valid);

    }

}