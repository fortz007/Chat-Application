package Services;

import interfaces.ApplicantInterface;

public class ApplicantServices implements ApplicantInterface {
    @Override
    public String apply() {
        return "I am applying for the job";
    }

    @Override
    public Boolean hasApplied() {
        if (this.apply().equals("I am applying for the job")){
            return true;
        }
        return false;
    }

}
