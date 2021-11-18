package src;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot= ParkingLot.getInstance("PR123",2,6);
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