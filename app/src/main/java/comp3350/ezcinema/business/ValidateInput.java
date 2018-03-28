package comp3350.ezcinema.business;

import android.util.Log;
import android.widget.EditText;
import java.util.Calendar;

public class ValidateInput {

    private boolean valid;
    private Calendar now;
    private int curMonth;
    private int curYear;
    private String message;

    public ValidateInput() {
        valid = true;
        now = Calendar.getInstance();
        curMonth = (now.get(Calendar.MONTH)+1);
        curYear = now.get(Calendar.YEAR);
    }

    public boolean isValidCredit(String creditText, String dateText, String cvvText){
        boolean validDate = false;
        valid = true;

        if(dateText.length() == 4) {
            String month = dateText.charAt(0) + "" + dateText.charAt(1);
            String year = dateText.charAt(2) + "" + dateText.charAt(3);

            validDate = isValidDate(month, year);
        }

        if(creditText.length() != 9 || creditText.contains("[a-zA-Z]+") == true)
        {
            valid = false;
            message = "credit card number must be 9 digits";
        }

        if(dateText.length() != 4 || creditText.contains("[a-zA-Z]+") == true || !validDate)
        {
            valid = false;
            message = "credit card expired or date invalid";
        }

        if(cvvText.length() != 3 || creditText.contains("[a-zA-Z]+") == true)
        {
            valid = false;
            message = "cvv must be 3 digits";
        }

        return valid;
    }

    public boolean isValidPaypal(EditText email, EditText password){
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        valid = true;

        if(emailText.length() > 20 || emailText.length() < 3 || !emailText.contains("@"))
        {
            valid = false;
            message = "email must be valid and at least 3 and no longer than 20 characters";
        }

        if(passwordText.length() < 5 || passwordText.length() > 20)
        {
            valid = false;
            message = "password must be at least 5 and no longer than 20 characters";
        }

        return valid;
    }

    public boolean isValidScene(EditText sceneNo, EditText pin) {
        String sceneNoText = sceneNo.getText().toString().trim();
        String pinText = pin.getText().toString().trim();
        valid = true;

        if(sceneNoText.length() != 9 || sceneNoText.contains("[a-zA-Z]+") == true)
        {
            valid = false;
            message = "Scene Card number must be 9 Digits";
        }

        if(pinText.length() != 4 || sceneNoText.contains("[a-zA-Z]+") == true)
        {
            valid = false;
            message = "Pin must be 4 Digits";
        }

        return valid;
    }

    public boolean isValidDate(String month, String year) {

        boolean validDate = false;

        int lastTwoNumYear = (curYear % 100);
        int convertMonth = Integer.parseInt(month);
        int convertYear = Integer.parseInt(year);

        if(convertYear > lastTwoNumYear)
        {
            validDate = true;
        }

        if(convertYear == lastTwoNumYear)
        {
            if(convertMonth > curMonth && convertMonth < 13)
            {
                validDate = true;
            }
        }

        return validDate;
    }

    public String specificMessage()
    {
        return message;
    }



}
