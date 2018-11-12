package fypcom.robert.fyp_rob_app;

public class Patient {
    String patientID;
    String patientName;
    String patientGender;
    String patientDOB;
    String patientDischargeDate;
    String patientPhone;


    public Patient(){

    }

    public Patient(String patientID, String patientName, String patientGender, String patientDOB, String patientDischargeDate,String patientPhone) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientDOB = patientDOB;
        this.patientDischargeDate = patientDischargeDate;
        this.patientPhone = patientPhone;
    }

    public String getPatientID() {
        return patientID;
    }
    public String getPatientName() {
        return patientName;
    }
    public String getPatientDOB() {
        return patientDOB;
    }
    public String getPatientDischargeDate() {
        return patientDischargeDate;
    }
    public String getPatientPhone() { return patientPhone;
    }
}
