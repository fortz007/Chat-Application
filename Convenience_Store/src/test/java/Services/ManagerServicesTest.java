package Services;

import enums.Grade;
import model.Applicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServicesTest {
    Applicant applicant1 = new Applicant(1, "Faith", 'M', "Decagon", "Cashier", Grade.SECOND_CLASS_LOWER);

    Applicant applicant2 = new Applicant(4, "Osaze", 'M', "Decagon", "Cashier", Grade.FIRST_CLASS);
    ManagerServices managerServ = new ManagerServices();
    ApplicantServices applicantServ = new ApplicantServices();

    @Test
    void hireCashier() {
        String actual = managerServ.hireCashier(applicantServ, applicant2);
        String expected = "YOU ARE HIRED!";
        assertEquals(expected,actual);
    }
}