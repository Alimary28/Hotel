package Repository;
import Domain.Room;
import Domain.RoomValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {
    private Map<Integer, Room> hotel = new HashMap<>();
    private RoomValidator validator;

    /**
     * instantiates a validator for rooms
     * @validator is the validator used
     */

    public RoomRepository(RoomValidator validator){
        this.validator = validator;
    }
    /**
     * adding a room to handling
     */
    public void add(Room room) {
        if (hotel.containsKey(room.getId())) {
            throw new RuntimeException("A room with this ID already exists!");
        }

        validator.checkInValidator(room);
        hotel.put(room.getId(), room);
    }

    /**
     * checkInValidator the room to update
     * @param room
     */
    public void update(Room room){
        if(!hotel.containsKey(room.getId())){
            throw new RuntimeException("The room with this ID can not be updated!");
        }
        validator.checkOutValidator(room);
        hotel.put(room.getRating(), room);
    }
    /**
     * return a list of rooms
     */
    public List<Room> getAll(){
        return new ArrayList<>(hotel.values());
    }

}
