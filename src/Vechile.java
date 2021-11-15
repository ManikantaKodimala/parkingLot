package src;

public class Vechile {
    private String type;
    private String registrationNumber;
    private String colour;
    private String ticket;

    public Vechile(String type,String registration, String colour){
        this.type=type;
        this.registrationNumber=registration;
        this.colour=colour;
    }
    public String getType(){
        return this.type;
    }
    public String getTicket() {
        return this.ticket;
    }
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
    public String getColour() {
        return this.colour;
    }
}
