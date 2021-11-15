package src;

import java.util.ArrayList;

public class ParkingLot {
    private int noOfFloors;
    private int noOfSlots;
    private String parkingLotId;
    private Vechile[][] parkedVechiles;

    public ParkingLot(String parkingLotId, int noOfFloors,int noOfSlots){
        this.noOfFloors=noOfFloors;
        this.noOfSlots=noOfSlots;
        this.parkedVechiles= new Vechile[noOfFloors][noOfSlots];
        this.parkingLotId=parkingLotId;
    }
    
    public void parkVechile(Vechile vechile){
        int[] freeSlot=this.getAvailableFreeSlotFor(vechile.getType());
        int floorNumber=freeSlot[0];
        int slotNumber=freeSlot[1];
        if(floorNumber>=1)
        {   
            this.parkedVechiles[floorNumber-1][slotNumber-1]=vechile;
            System.out.println("Parked vehicle. Ticket ID: PR1234_"+floorNumber+"_"+slotNumber);
        }
        else if (floorNumber==-1){
            System.out.println("Parking Lot Full");
        }
        else{
            System.out.println("Parking is not availabe for"+vechile.getType());
        }
    }
    
    private int[] getAvailableFreeSlotFor(String vechileType){
        switch (vechileType) {
            case "CAR":
                if(noOfSlots>3){
                    return findFreeSlotIn(3, noOfSlots);
                }
                return new int[] {0,0};
            case "BIKE":
                if(noOfSlots>1){
                    return findFreeSlotIn(1, 3);
                }
                return new int[] {0,0};
            case "TRUCK" :
                return findFreeSlotIn(0, 1);
            default:
                return new int[] {-1,-1};
        }
    }
    private int[] findFreeSlotIn(int start,int end){
        for (int i = 0; i < noOfFloors; i++) {
            for (int j = start; j < end; j++) {
                if(parkedVechiles[i][j]== null){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public void unparkVehicle(String ticketId){

        if(isTicketValid(ticketId)){
            int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1]);
            int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2]);
            Vechile vechile= parkedVechiles[floorNumber][slotNumber];
            parkedVechiles[floorNumber][slotNumber]=null;
            System.out.println("Unparked vehicle with Registration Number:"+vechile.getRegistrationNumber()+" and Color:"+vechile.getColour());
            
        }
        else{
            System.out.println("Invalid Ticket");
        }
    }

    public boolean isTicketValid(String ticketId){
        int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1]);
        int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2]);
        return parkedVechiles[floorNumber-1][slotNumber-1]!=null;
    }
    public void displayFreeCountOf(String vechileType){
        ArrayList<ArrayList<Integer>> freeSlots;
        switch (vechileType) {
            case "CAR":
                if(noOfSlots>3){
                  freeSlots = findAllFreeSlotIn(3,noOfSlots);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for CAR on Floor"+(i+1)+" : "+freeSlots.get(i).size());
                    }
                }
                else{
                    System.out.println("Parking is not availabe for Car");
                }
                break;
            case "BIKE":
                if(noOfSlots>1){
                  freeSlots = findAllFreeSlotIn(1,3);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for BIKE on Floor"+(i+1)+" : "+freeSlots.get(i).size());
                    }
                }
                else{
                    System.out.println("Parking is not availabe for BIKE");
                }
                break;
            case "TRUCK" :
                    freeSlots = findAllFreeSlotIn(0,1);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for TRUCK on Floor"+(i+1)+" : "+freeSlots.get(i).size());
                    }
                break;
            default:
                System.out.println("incorrect input");
        }
    }

    private ArrayList<ArrayList<Integer>> findAllFreeSlotIn(int start,int end){
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
    public void displayFreeSlotsOf(String vechileType){
        ArrayList<ArrayList<Integer>> freeSlots;
        switch (vechileType) {
            case "CAR":
                if(noOfSlots>3){
                  freeSlots = findAllFreeSlotIn(3,noOfSlots);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for CAR on Floor"+(i+1)+" : "+freeSlots.get(i).toString());
                    }
                }
                else{
                    System.out.println("Parking is not availabe for Car");
                }
                break;
            case "BIKE":
                if(noOfSlots>1){
                  freeSlots = findAllFreeSlotIn(1,3);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for BIKE on Floor"+(i+1)+" : "+freeSlots.get(i).toString());
                    }
                }
                else{
                    System.out.println("Parking is not availabe for BIKE");
                }
                break;
            case "TRUCK" :
                    freeSlots = findAllFreeSlotIn(0,1);
                  for (int i = 0; i < noOfFloors; i++) {
                        System.out.println("No. of free slots for TRUCK on Floor"+(i+1)+" : "+freeSlots.get(i).toString());
                    }
                    break;
            default:
                System.out.println("incorrect input");
        }
    }


}
