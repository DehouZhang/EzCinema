package comp3350.ezcinema.business;

import android.util.Log;
import android.widget.EditText;
import java.util.Calendar;

public class ValidateInput {

    private boolean valid;
    private Calendar now;
    private int curMonth;
    private int curYear;

    public ValidateInput() {
        valid = true;
        now = Calendar.getInstance();
        curMonth = (now.get(Calendar.MONTH)+1);
        curYear = now.get(Calendar.YEAR);
    }

    public boolean isValidCredit(EditText credit, EditText date, EditText cvv){
        String creditText = credit.getText().toString().trim();
        String dateText = date.getText().toString().trim();
        String cvvText = cvv.getText().toString().trim();
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
        }

        if(dateText.length() != 4 || creditText.contains("[a-zA-Z]+") == true || !validDate)
        {
            valid = false;
        }

        if(cvvText.length() != 3 || creditText.contains("[a-zA-Z]+") == true)
        {
            valid = false;
        }

        return valid;
    }

    public boolean isValidPaypal(EditText email, EditText password){
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        valid = true;

        if(emailText.length() > 20 || emailText.length() < 3)
        {
            valid = false;
        }

        if(passwordText.length() < 5 || passwordText.length() > 20)
        {
            valid = false;
        }

        return valid;
    }

    public boolean isValidScene(EditText sceneNo, EditText pin) {
        String sceneNoText = sceneNo.getText().toString().trim();
        String pinText = pin.getText().toString().trim();
        valid = true;

        if(sceneNoText.length() != 9)
        {
            valid = false;
        }

        if(pinText.length() != 4)
        {
            valid = false;
        }

        return valid;
    }

    public boolean isValidDate(String month, String year) {

        boolean validDate = false;

        int lastTwoNumYear = (curYear % 100);
        int convertMonth = Integer.parseInt(month);
        int convertYear = Integer.parseInt(year);

        if(convertYear >= lastTwoNumYear)
        {
            if(convertMonth >= curMonth)
            {
                validDate = true;
            }
        }

        return validDate;

    }

}
