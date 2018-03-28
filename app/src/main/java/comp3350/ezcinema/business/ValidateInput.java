package comp3350.ezcinema.business;

import android.util.Log;
import android.widget.EditText;
import java.util.Calendar;

public class ValidateInput {

    private String input;
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
        String message = creditText;
        valid = true;

        //Log.i("tag", ""+creditText+":"+creditText.length());

        if(creditText.length() != 9)
        {
            valid = false;
        }

        if(dateText.length() != 4)
        {
            valid = false;
        }

        if(cvvText.length() != 3)
        {
            valid = false;
        }

        return valid;
    }

    public boolean isValidPaypal(EditText email, EditText password){
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        valid = true;


        return valid;
    }

    public boolean isValidScene(EditText sceneNo, EditText pin) {
        String sceneNoText = sceneNo.getText().toString().trim();
        String pinText = pin.getText().toString().trim();
        valid = true;

        return valid;
    }

}
