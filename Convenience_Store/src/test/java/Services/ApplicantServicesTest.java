package Services;

import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantServicesTest {
    ApplicantServices applicantServ = new ApplicantServices();

    @Test
    void apply() {
        String actual = applicantServ.apply();
        String expected = "I am applying for the job";
    }

    @Test
    void hasApplied() {
        Boolean actual = applicantServ.hasApplied();
        Boolean expected = true;

    }
}