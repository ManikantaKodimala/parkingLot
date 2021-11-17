package src;

import java.util.ArrayList;

public class Display {
    private final ParkingLot parkingLot;
    public Display(){
        parkingLot=ParkingLot.getInstance("PR_123",2,6);
    }

    private void logFreeCount(ArrayList<ArrayList<Integer>> freeSlots,String vehicleType){
        for (int i = 0; i < parkingLot.getNoOfFloors(); i++) {
            System.out.println("No. of free slots for "+vehicleType+" on Floor"+(i+1)+" : "+freeSlots.get(i).size());
        }

    }

    public void displayFreeCountOf(String vehicleType){
        ArrayList<ArrayList<Integer>> freeSlots;
        String output="Parking is not available for";
        switch (vehicleType) {
            case "CAR":
                if(parkingLot.getNoOfSlots()>3){
                  freeSlots = parkingLot.findAllFreeSlotIn(3, parkingLot.getNoOfSlots());
                    logFreeCount(freeSlots,vehicleType);
                }
                else
                    System.out.println(output+" Car");
                break;
            case "BIKE":
                if(parkingLot.getNoOfSlots()>1){
                  freeSlots = parkingLot.findAllFreeSlotIn(1,3);
                  logFreeCount(freeSlots,vehicleType);
                }
                else
                    System.out.println(output+" BIKE");
                break;
            case "TRUCK" :
                    freeSlots = parkingLot.findAllFreeSlotIn(0,1);
                  logFreeCount(freeSlots,vehicleType);
                break;
            default:
                System.out.println("incorrect input");
        }
    }
    
    private void logFreeSlots(ArrayList<ArrayList<Integer>> freeSlots,String vehicleType){
        for (int i = 0; i < parkingLot.getNoOfFloors(); i++) {
          System.out.println("Free slots for "+vehicleType+" on Floor"+(i+1)+" : "+freeSlots.get(i).toString());
        }
    }
    
    public void displayFreeSlotsOf(String vehicleType){
        ArrayList<ArrayList<Integer>> freeSlots;
        String output="Parking is not available for";
        switch (vehicleType) {
            case "CAR":
                if(parkingLot.getNoOfSlots()>3){
                  freeSlots = parkingLot.findAllFreeSlotIn(3, parkingLot.getNoOfSlots());
                  logFreeSlots(freeSlots,vehicleType);
                }
                return;
            case "BIKE":
                if(parkingLot.getNoOfSlots()>1){
                  freeSlots = parkingLot.findAllFreeSlotIn(1, 3);
                  logFreeSlots(freeSlots,vehicleType);
                }
                return;
            case "TRUCK" :
                    freeSlots = parkingLot.findAllFreeSlotIn(0, 1);
                    logFreeSlots(freeSlots,vehicleType);
                    return;
            default:
                System.out.println("incorrect input");
        }
        System.out.println(output+vehicleType);
    }
    
    private void logOccupiedSlots(ArrayList<ArrayList<Integer>> occupiedSlots, String vehicleType){
        for (int i = 0; i < parkingLot.getNoOfFloors(); i++) {
          System.out.println("Occupied slots for "+vehicleType +" on Floor"+(i+1)+" : "+occupiedSlots.get(i).toString());
        }
    }
    
    public void displayOccupiedSlotsOf(String vehicleType){
        ArrayList<ArrayList<Integer>> occupiedSlots;
        String output="Parking is not available for ";
        switch (vehicleType) {
            case "CAR":
                if(parkingLot.getNoOfSlots()>3){
                  occupiedSlots = parkingLot.findAllOccuipiedSlotIn(3, parkingLot.getNoOfSlots());
                  logOccupiedSlots(occupiedSlots,vehicleType);
                }
                return;
            case "BIKE":
                if(parkingLot.getNoOfSlots()>1){
                  occupiedSlots = parkingLot.findAllOccuipiedSlotIn(1, 3);
                  logOccupiedSlots(occupiedSlots,vehicleType);
                }
                return;
            case "TRUCK" :
                    occupiedSlots = parkingLot.findAllOccuipiedSlotIn(0, 1);
                    logOccupiedSlots(occupiedSlots,vehicleType);
                    return;
            default:
                System.out.println("incorrect input");
        }
        System.out.println(output+vehicleType);
    }
}
