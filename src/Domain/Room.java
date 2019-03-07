package Domain;

public class Room {
    private int id, numberOfPersons, roomNumber, days;
    private boolean roomOut;
    private String feedback;
    private int rating;

    public Room(int id, int numberOfPersons, int roomNumber, int days){
        this.id = id;
        this.numberOfPersons = numberOfPersons;
        this.roomNumber = roomNumber;
        this.days = days;
    }
    public Room(boolean roomOut, String feedback, int rating){
        this.roomOut = roomOut;
        this.feedback = feedback;
        this.rating = rating;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isOutOfRoom() {
        return roomOut;
    }

    public void setOutOfRoom(boolean roomOut) {
        this.roomOut = roomOut;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
