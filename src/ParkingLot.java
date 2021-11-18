package src;

import java.util.ArrayList;

public final class  ParkingLot {
    private int noOfFloors;
    private int noOfSlots;
    private String parkingLotId;
    private Vechile[][] parkedVechiles;
    private static ParkingLot parkingLot;


    private ParkingLot(String parkingLotId, int noOfFloors,int noOfSlots){
        this.noOfFloors=noOfFloors;
        this.noOfSlots=noOfSlots;
        this.parkedVechiles= new Vechile[noOfFloors][noOfSlots];
        this.parkingLotId=parkingLotId;
    }

    public static ParkingLot getInstance(String parkingLotId, int noOfFloors,int noOfSlots){
        if(parkingLot == null)
            parkingLot=new ParkingLot(parkingLotId,noOfFloors,noOfSlots);
        return parkingLot;

    }
    public void parkVechile(Vechile vechile){
        int[] freeSlot=this.getAFreeSlotFor(vechile.getType());
        int floorNumber=freeSlot[0];
        int slotNumber=freeSlot[1];
        System.out.println("flornumber"+floorNumber+"slotNumber"+slotNumber);
        if(floorNumber>=1)
        {   
            this.parkedVechiles[floorNumber-1][slotNumber-1]=vechile;
            System.out.println("Parked vehicle. Ticket ID: PR1234_"+floorNumber+"_"+slotNumber);
        }
        else if (floorNumber==-1){
            System.out.println("Parking Lot Full");
        }
        else{
            System.out.println("Parking is not available for"+vechile.getType());
        }
    }
    
    private int[] getAFreeSlotFor(String vechileType){
        int floorNumber=-1;
        ArrayList<ArrayList<Integer>> freeSlots;
        switch (vechileType) {
            case "CAR":
                if(noOfSlots>3){
                    freeSlots=findAllFreeSlotIn(3, noOfSlots);
                    floorNumber=getFreeSlotFloorNumber(freeSlots);
                    return new int[]{floorNumber,freeSlots.get(floorNumber-1).get(0)};
                }
                return new int[] {0,0};

            case "BIKE":
                if(noOfSlots>1){
                    freeSlots=findAllFreeSlotIn(1, 3);
                    floorNumber=getFreeSlotFloorNumber(freeSlots);
                    return new int[]{floorNumber,freeSlots.get(floorNumber-1).get(0)};
                }
                return new int[] {0,0};
            case "TRUCK" :
                freeSlots=findAllFreeSlotIn(0, 1);
                floorNumber=getFreeSlotFloorNumber(freeSlots);
                return new int[]{floorNumber,freeSlots.get(floorNumber-1).get(0)};
            default:
                return new int[] {-1,-1};
        }
    }
    
    public int getFreeSlotFloorNumber(ArrayList<ArrayList<Integer>> freeSlot){
        int floorNumber=-1;
        for(int i=0;i<noOfFloors;i++){
            if(!freeSlot.get(i).isEmpty()){
                floorNumber=i+1;
                break;
                }
        }
        return floorNumber;
    }
    
    public void unparkVehicle(String ticketId){

        if(isTicketValid(ticketId)){
            int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1])-1;
            int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2])-1;
            Vechile vechile= parkedVechiles[floorNumber][slotNumber];
            parkedVechiles[floorNumber][slotNumber]=null;
            System.out.println("Unparked vehicle with Registration Number:"+vechile.getRegistrationNumber()+" and Color:"+vechile.getColour());
            
        }
        else{
            System.out.println("Invalid Ticket");
        }
    }

    private boolean isTicketValid(String ticketId){
        int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1])-1;
        int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2])-1;
        return floorNumber<noOfFloors && slotNumber<noOfSlots && parkedVechiles[floorNumber][slotNumber]!=null;
    }
    

    public ArrayList<ArrayList<Integer>> findAllFreeSlotIn(int start,int end){
        ArrayList<ArrayList<Integer>> freeSlots =new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < noOfFloors; i++) {
            ArrayList<Integer> slots = new ArrayList<Integer>();
            for (int j = start; j < end; j++) {
                if(parkedVechiles[i][j]== null){
                    slots.add(j+1);
                }
            }
            freeSlots.add(slots);
        }
        return freeSlots;
    }



    public ArrayList<ArrayList<Integer>> findAllOccuipiedSlotIn(int start,int end){
        ArrayList<ArrayList<Integer>> freeSlots =new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < noOfFloors; i++) {
            ArrayList<Integer> slots = new ArrayList<Integer>();
            for (int j = start; j < end; j++) {
                if(parkedVechiles[i][j]!= null){
                    slots.add(j+1);
                }
            }
            freeSlots.add(slots);
        }
        return freeSlots;
    }

    public int getNoOfSlots() {
    return this.noOfSlots;
    }

    public int getNoOfFloors() {
        return this.noOfFloors;
    }
}
