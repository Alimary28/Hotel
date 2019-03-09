package Domain;

public class RoomValidator {
    /**
     * Validates a room
     * @param room
     * throws Runtime Exception if there are validation errors
     */
    public void checkInValidator(Room room){
        if(room.getDays() <= 0){
            throw new RuntimeException("The number of days must be greater than 0!");
        }
        if(room.getRoomNumber() < 100 || room.getRoomNumber() > 999){
            throw new RuntimeException("The number of the room does not exists!");
        }
    }
    public  void checkOutValidator(Room room){
        if(room.getRating() < 1 || room.getRating() > 5){
            throw new RuntimeException("Ratingul must be a number between 1 and 5!");
        }
    }
}
