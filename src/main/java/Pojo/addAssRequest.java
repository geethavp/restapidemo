package Pojo;

public class addAssRequest {

    private String memberIdentifier;
    private String programmeIdentifier;
    private String relation;
    private Pojo.person person;

    private String associateType;

    public String getAssociateType() {
        return associateType;
    }

    public void setAssociateType(String associateType) {
        this.associateType = associateType;
    }

    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(String memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public String getProgrammeIdentifier() {
        return programmeIdentifier;
    }

    public void setProgrammeIdentifier(String programmeIdentifier) {
        this.programmeIdentifier = programmeIdentifier;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Pojo.person getPerson() {
        return person;
    }

    public void setPerson(Pojo.person person) {
        this.person = person;
    }


}
