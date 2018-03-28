package comp3350.ezcinema.business;

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
        String cvvText = date.getText().toString().trim();

        return valid;
    }

    public boolean isValidPaypal(EditText email, EditText password){
        String emailText = email.getText().toString().trim();
        return valid;
    }

    public boolean isValidScene(EditText sceneNo, EditText pin) {
        valid = false;
        return valid;
    }

}
