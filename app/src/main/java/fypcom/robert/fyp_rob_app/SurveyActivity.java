package fypcom.robert.fyp_rob_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class SurveyActivity extends AppCompatActivity {

    RadioGroup rgDiet, rgActivity, rgFeel;
    RadioButton rbBad, rbVBad, rbMod, rbGood, rbVGood, rbBad2, rbVBad2, rbMod2, rbGood2, rbVGood2, rbBad3, rbVBad3, rbMod3, rbGood3, rbVGood3;

    Button btnSurvey;
    Spinner SMed,SNurseContact;
    DatabaseReference databasePatientSurveyResults;
    EditText txtNote;
    String Activity,Feel,Diet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);



        addListenerOnButtonFeel();
        addListenerOnButtonDiet();
        addListenerOnButtonActivity();




        databasePatientSurveyResults = FirebaseDatabase.getInstance().getReference("patientSurvey");
        rgFeel = (RadioGroup) findViewById(R.id.rgFeel);
        rgDiet = (RadioGroup) findViewById(R.id.rgDiet);
        SMed = (Spinner) findViewById(R.id.SMed);
        rgActivity = (RadioGroup) findViewById(R.id.rgActivity);
        btnSurvey = (Button) findViewById(R.id.btnSurvey);
        SNurseContact = (Spinner) findViewById(R.id.SNurseContact);
        txtNote  = (EditText) findViewById(R.id.txtNote);




        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addPatientSurveyResults();





            }
        });


    }


    public void addListenerOnButtonFeel() {


        btnSurvey = (Button) findViewById(R.id.btnSurvey);

        btnSurvey.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int SelectedIdFeel = rgFeel.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rbBad = (RadioButton) findViewById(SelectedIdFeel);

                Feel = rbBad.getText().toString();

            }

        });

    }
    public void addListenerOnButtonActivity() {

        btnSurvey = (Button) findViewById(R.id.btnSurvey);


        btnSurvey.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int SelectedIdActivity = rgActivity.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rbBad = (RadioButton) findViewById(SelectedIdActivity);

                Activity = rbBad.getText().toString();

            }

        });

    }    public void addListenerOnButtonDiet() {


        btnSurvey = (Button) findViewById(R.id.btnSurvey);

        btnSurvey.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int SelectedIdDiet = rgDiet.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rbBad = (RadioButton) findViewById(SelectedIdDiet);

                Diet = rbBad.getText().toString();

            }

        });

    }


    private void addPatientSurveyResults(){

        String Note = txtNote.getText().toString().trim();
        String Nurse = SNurseContact.getSelectedItem().toString();
        String Med = SMed.getSelectedItem().toString();
        String ActivityDB = Activity;
        String FeelDB = Feel;
        String DietDB = Diet;



        // if(!TextUtils.is(Feel)){
        String id = databasePatientSurveyResults.push().getKey();

        PatientSurveyResults patientSurvey = new PatientSurveyResults(id, ActivityDB, FeelDB, DietDB, Med, Note, Nurse);

        databasePatientSurveyResults.child(id).setValue(patientSurvey);
        Toast.makeText(this, "Survey Complete", Toast.LENGTH_LONG).show();



        //}else{
        //    Toast.makeText(this, "Please Fill out all forms", Toast.LENGTH_LONG).show();
        // }
    }


}