package resources;


public enum APIResources {


    AddAssociateAPI("/members/00002922/programmes/BAEC/associates"),
    RetrieveAssociateAPI("/members/00002922/programmes/BAEC/associates/" + Utils.associateID + ""),
    DeleteAssociateAPI("/members/00002922/programmes/BAEC/associates/" + Utils.associateID + "");


    String resource;

    //constructor for enum methods access
    APIResources(String resource) {
        this.resource = resource;
    }

    //get the resource from constructore
    public String getResource() {
        return resource;
    }

}
