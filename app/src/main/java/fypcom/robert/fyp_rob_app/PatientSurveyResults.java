package fypcom.robert.fyp_rob_app;

public class PatientSurveyResults {

//Declaring variables
    String patientID;
    String patientMood;
    String patientDiet;
    String patientPhysicalActivity;
    String patientMedication;
    String patientContact;
    String patientNote;



    //getters
    public String getPatientNote() { return patientNote; }

    public String getPatientContact() {
        return patientContact;
    }

    public String getPatientMood() { return patientMood; }

    public String getPatientDiet() {
        return patientDiet;
    }

    public String getPatientPhysicalActivity() { return patientPhysicalActivity; }

    public String getPatientMedication() {
        return patientMedication;
    }

    public String getPatientID() {
        return patientID;
    }

    public PatientSurveyResults(String patientID, String patientMood, String patientDiet, String patientMedication, String patientPhysicalActivity, String patientContact, String patientNote) {
        this.patientMood = patientMood;
        this.patientDiet = patientDiet;
        this.patientMedication = patientMedication;
        this.patientPhysicalActivity = patientPhysicalActivity;
        this.patientID = patientID;
        this.patientContact = patientContact;
        this.patientNote = patientNote;









    }

}
