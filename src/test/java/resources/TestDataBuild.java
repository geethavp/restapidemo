package resources;

import Pojo.addAssRequest;
import Pojo.email;
import Pojo.person;
import Pojo.personName;

public class TestDataBuild {


    public addAssRequest getAddAssociateData(String associateType, String memberIdentifier) {

        addAssRequest asr = new addAssRequest();
        asr.setAssociateType(associateType);
        asr.setMemberIdentifier(memberIdentifier);

        asr.setRelation("Brother");

        //creating objects of pojo child json classes to set values for them
        person p = new person();
        p.setDateOfBirth("1992-07-09");


        personName pn = new personName();
        pn.setFamilyName("familynae");
        pn.setFirstName("firstname");

        email e = new email();
        e.setEmail("ghtyyuuu@avios.com");

        p.setPersonName(pn);
        p.setEmailAddress(e);


        asr.setPerson(p);

        return asr;

    }
}
