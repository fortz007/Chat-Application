package Services;

import enums.Grade;
import interfaces.ManagerInterface;
import model.Applicant;

public class ManagerServices implements ManagerInterface {
    @Override
    public String hireCashier(ApplicantServices applicantServ, Applicant applicant) {
        String response = "";
        if (applicantServ.hasApplied()) {
            if (applicant.getGrade().equals(Grade.FIRST_CLASS) || applicant.getGrade().equals(Grade.SECOND_CLASS_UPPER)) {
                response = "YOU ARE HIRED!";
            } else {
                response = "SORRY, YOU ARE NOT QUALIFIED!";
            }
        }
        return response;
    }
}
