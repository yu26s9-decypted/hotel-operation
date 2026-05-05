package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_RoomIsNotOccupied() {
        Room room = new Room(2, 140.00, true, false);

        //act
        room.checkIn();

        //assert
       assertTrue(room.isOccupied());

    }

    @Test
    public void checkIn_RooomIsOccupied_RoomIsDirty(){
        Room room = new Room(2, 140.00, true, true);

        //act
        room.checkIn();

        //assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkOut_RoomIsCheckedOut_RoomEmptyButDirty() {
        Room room = new Room(2, 140.00, false, true);

        //act
        room.checkOut();

        //assert
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_RoomIsCheckedOut_RoomIsCleaned() {
        Room room = new Room(2, 140.00, false, true);

        // act
        room.cleanRoom();

        assertFalse(room.isDirty());
        assertFalse(room.isOccupied());
    }
}