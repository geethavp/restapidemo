package StepDefinitions;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {


    @Before("@DeleteAssociate")
    public void beforeDeleteAss() throws IOException {

        StepDefinition steps = new StepDefinition();


        if (steps.associateID == null) {
            steps.the_add_associate_payload_is_given_with("GUARDIAN", "00003456");
            steps.for_method_is_used("AddAssociateAPI", "POST");
            steps.verify_using_and_method("00003456", "RetrieveAssociateAPI", "GET");
        }
    }


}
