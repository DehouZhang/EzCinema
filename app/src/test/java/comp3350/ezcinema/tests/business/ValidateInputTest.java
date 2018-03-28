package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import android.widget.EditText;
import comp3350.ezcinema.business.ValidateInput;


public class ValidateInputTest extends TestCase
{
    EditText testText1;
    EditText testText2;
    EditText testText3;
    boolean valid;
    ValidateInput isValid;

    public void setUp() throws Exception {
        testText1.setText("");
        testText2.setText("");
        testText3.setText("");
        valid = false;
        isValid = new ValidateInput();
    }

    public void testIsValidCredit() throws Exception
    {
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1.setText("abcdefghij");
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1.setText("abcdefghi");
        valid = isValid.isValidCredit(testText1,testText2,testText3);
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("abcd");
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("0318");
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("0418");
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("0418");
        testText3.setText("abcd");
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("0318");
        testText3.setText("123");
        assertFalse(valid);

        testText1.setText("123456789");
        testText2.setText("0418");
        testText3.setText("123");
        assertTrue(valid);

    }
    

}