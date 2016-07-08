package com.example.lalel.myfitkid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.content.Intent;
import android.widget.Toast;

/**
 *
 */
public class QuestPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest);
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

        // Take the fields and format the message contents
        String subject = formatFeedbackSubject(feedbackType);

        String message = formatFeedbackMessage(feedbackType, name,
                email, feedback, bRequiresResponse);

        // Create the message
        sendFeedbackMessage(subject, message);
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
            startActivity(Intent.createChooser(messageIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(QuestPage.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}


