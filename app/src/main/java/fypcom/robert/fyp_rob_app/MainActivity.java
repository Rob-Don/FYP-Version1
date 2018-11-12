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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declaring
    EditText editTextName;
    Button btnData;
    Button btn;
    Spinner spinner;
    EditText txtPhone;
    EditText txtDischargeDate;
    EditText txtDOB;


    DatabaseReference databasePatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);


        databasePatients = FirebaseDatabase.getInstance().getReference("patient");

        editTextName = (EditText) findViewById(R.id.editTextName);
        btnData = (Button) findViewById(R.id.btnData);
        spinner = (Spinner) findViewById(R.id.spinner);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtDOB = (EditText) findViewById(R.id.txtDOB);
        txtDischargeDate = (EditText) findViewById(R.id.txtDischargeDate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( MainActivity.this,SurveyActivity.class);
                startActivity(intent);
            }
        });



        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addPatient();
            }
        });
    }

    private void addPatient(){
        String name = editTextName.getText().toString().trim();
        String DOB = txtDOB.getText().toString().trim();
        String Phone = txtPhone.getText().toString().trim();
        String DischargeDate = txtDischargeDate.getText().toString().trim();


        String gender = spinner.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){
            String id = databasePatients.push().getKey();

            Patient patient = new Patient(id, name, gender, DOB, Phone, DischargeDate);

            databasePatients.child(id).setValue(patient);
            Toast.makeText(this, "Patient Added", Toast.LENGTH_LONG).show();



        }else{
            Toast.makeText(this, "Please Fill out all forms", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent ( MainActivity.this,SurveyActivity.class);
        startActivity(intent);
    }

}
