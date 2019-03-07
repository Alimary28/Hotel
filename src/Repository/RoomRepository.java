package Repository;
import Domain.Room;
import Domain.RoomValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {
    private Map<Integer, Room> handling = new HashMap<>();
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
        if (handling.containsKey(room.getId())) {
            throw new RuntimeException("A room with this ID already exists!");
        }

        validator.validate(room);
        handling.put(room.getId(), room);
    }

    /**
     * validate the room to update
     * @param room
     */
    public void update(Room room){
        if(!handling.containsKey(room.getId())){
            throw new RuntimeException("The room with this ID can not be updated!");
        }
        validator.validate(room);
        handling.put(room.getId(), room);
    }
    /**
     * return a list of rooms
     */
    public List<Room> getAll(){
        return (List<Room>)handling.values();
    }

}
