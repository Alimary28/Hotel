package Domain;

public class RoomValidator {
    /**
     * Validates a room
     * @param room
     * throws Runtime Exception if there are validation errors
     */
    public void validate(Room room){
        if(room.getDays() <= 0){
            throw new RuntimeException("The number of days must be greater than 0!");
        }
        if(room.getRoomNumber() < 100 || room.getRoomNumber() > 999){
            throw new RuntimeException("The number of the room does not exists!");
        }
        if(room.getRating() < 1 || room.getRating() > 5){
            throw new RuntimeException("Ratingul trebuie sa fie un numar intre 1 si 5!");
        }
    }
}
