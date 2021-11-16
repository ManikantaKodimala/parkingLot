import java.util.Scanner;

import src.ParkingLot;
import src.Vechile;

class App{
    public  enum InputCommands{
        create_parking_lot,display,park_vehicle,unpark_vehicle,free_count,free_slots,occupied_slots
    }
    public static ParkingLot parkingLot;
    public static void main(String[] args) {
        System.out.println("Parking Lot");
        
        Scanner sc = new Scanner(System.in);

        String input = "input" ;
        String[] splitInput;
        
        while(true){

            input=sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            // System.out.println("hi");
            splitInput=input.split(" ",-1);
            handler(splitInput);
        }
    }
    public static void handler(String[] splitInput){
        String type;
        String registration;
        String colour;
        switch (InputCommands.valueOf(splitInput[0])) {
            case create_parking_lot:

                parkingLot= new ParkingLot(splitInput[1],Integer.parseInt(splitInput[2]),Integer.parseInt(splitInput[3]));
                System.out.println("Created parking lot with "+splitInput[2]+" floors and " +splitInput[3]+" slots per floor");
                break;
            case park_vehicle:
                type=splitInput[1];
                registration=splitInput[2];
                colour=splitInput[3];
                Vechile vechile= new Vechile(type, registration, colour);
                parkingLot.parkVechile(vechile);
                break;
        
            case display:
                switch(InputCommands.valueOf(splitInput[1])){
                    case free_count:
                    parkingLot.displayFreeCountOf(splitInput[2]);
                    break;
                    case free_slots:
                    parkingLot.displayFreeSlotsOf(splitInput[2]);
                    break;
                    case occupied_slots:
                    parkingLot.displayOccuipiedSlotsOf(splitInput[2]);
                    break;
                }
                break;
            case unpark_vehicle:
                parkingLot.unparkVehicle(splitInput[1]);
            break;
            
        }
    }
}