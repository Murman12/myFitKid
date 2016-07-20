package com.example.lalel.myfitkid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.content.Intent;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 *
 */
public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
    }

    public void sendFeedback(View button) {
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditTextEmail);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String feedback = feedbackField.getText().toString();

        final Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String feedbackType = feedbackSpinner.getSelectedItem().toString();

        final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean bRequiresResponse = responseCheckbox.isChecked();

        if(!checkEmail(email)) {
            emailField.setError("Invalid Email Address");
        } else if (TextUtils.isEmpty(name)) {
            nameField.setError("Please enter your name");
        } else if (TextUtils.isEmpty(feedback)) {
            feedbackField.setError("Please enter your feedback");
        } else {
            // Take the fields and format the message contents
            String subject = formatFeedbackSubject(feedbackType);
            String message = formatFeedbackMessage(feedbackType, name, email, feedback,
                    bRequiresResponse);
            // Create the message
            sendFeedbackMessage(subject, message);
        }
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" +
                    "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    protected String formatFeedbackSubject(String feedbackType) {
        String strFeedbackSubjectFormat = getResources().getString(
                R.string.feedbackmessagesubject_format);
        String strFeedbackSubject = String.format(strFeedbackSubjectFormat, feedbackType);
        return strFeedbackSubject;
    }

    protected String formatFeedbackMessage(String feedbackType, String name,
                                           String email, String feedback, boolean bRequiresResponse) {
        String strFeedbackFormatMsg = getResources().getString(
                R.string.feedbackmessagebody_format);
        String strRequiresResponse = getResponseString(bRequiresResponse);
        String strFeedbackMsg = String.format(strFeedbackFormatMsg,
                feedbackType, feedback, name, email, strRequiresResponse);
        return strFeedbackMsg;
    }

    protected String getResponseString(boolean bRequiresResponse) {
        if (bRequiresResponse == true) {
            return getResources().getString(R.string.feedbackmessagebody_responseyes);
        } else {
            return getResources().getString(R.string.feedbackmessagebody_responseno);
        }
    }

    public void sendFeedbackMessage(String subject, String message) {
        Intent messageIntent = new Intent(android.content.Intent.ACTION_SEND);
        messageIntent.setType("message/rfc822");
        messageIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"pmurray1991@hotmail.co.uk"});

        messageIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        messageIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(messageIntent, "Please choose an email app to send this with."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Feedback.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}


