package src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot;
    private Vechile car;
    private Vechile bike;
    private  Vechile truck;
    @BeforeEach
    public void beforeAll(){
         parkingLot= ParkingLot.getInstance("PR123",2,6);
         car = new Vechile("CAR","Ap-36-T234","blue");
         bike = new Vechile("BIKE","AAP-45-H-134","green");
         truck = new Vechile("TRUCK","TS03-09-ijn","green");

         parkingLot.parkVechile(car);
         parkingLot.parkVechile(bike);
         parkingLot.parkVechile(truck);

    }

    @Test
    @DisplayName("getting floor number of a free slot")
    void getFreeSlotFloorNumber() {
        ArrayList<ArrayList<Integer>> freeSlots= new ArrayList<>(){
            {
                add(new ArrayList<Integer>(){
                    {   add(1);
                        add(2);}
                });
            }
        };
        int expected = 1;
        int received= parkingLot.getFreeSlotFloorNumber(freeSlots);

        assertEquals(expected,received);

    }

    @Test
    void unparkVehicle() {
    }

    @Test
    void findAllFreeSlotIn() {
    }

    @Test
    void findAllOccuipiedSlotIn() {
    }

    @Test
    void getNoOfSlots() {
    }

    @Test
    void getNoOfFloors() {
    }
}