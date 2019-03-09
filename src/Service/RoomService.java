package Service;
import Domain.Room;
import Repository.RoomRepository;

import java.util.*;

public class RoomService {
    private RoomRepository repository;

    /**
     * creating the constructor
     */
    public RoomService(RoomRepository repository){
        this.repository = repository;
    }
    /**
     * @param id
     * @param numberOfPersons
     * @param roomNumber
     * @param days
     */
    public void checkIn(int id, int roomNumber, int numberOfPersons, int days) {

        Room room = new Room(id, numberOfPersons, roomNumber, days);
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isOutOfRoom()) {
                throw new RuntimeException("That room is already occupied!");
            }
        }
        repository.add(room);
    }
    /**
     * @param roomNumber
     * @param feedback
     * @param  rating
     */
    public void checkOut(int roomNumber, String feedback, int rating){
        Room personsInRoom = null;
        List<Room> rooms = repository.getAll();
        for(Room r : rooms){
            if(r.getRoomNumber() == roomNumber && !r.isOutOfRoom()){
                personsInRoom = r;
            }
        }
        if (personsInRoom != null) {
            personsInRoom.setFeedback(feedback);
            personsInRoom.setRating(rating);
            personsInRoom.setOutOfRoom(true);
            repository.update(personsInRoom);
        } else {
            throw new RuntimeException("The room is not ocupied!");
        }
    }
    public List<Room> getAll() {
        return repository.getAll();
    }
    public Set<Integer> getAllRooms(){
        Set<Integer> roomsNumber = new HashSet<>();
        List<Room> rooms = getAll();
        for(Room room : rooms){
            roomsNumber.add(room.getRoomNumber());
        }
        return roomsNumber;
    }

    /**
     *
     * @param nrRoom
     * @return a list of ratings
     */
    public List<Integer> getAllByNumber(int nrRoom){
        List<Integer> ratings = new ArrayList<>();
        for(Room room : getAll()){
            if(room.getRoomNumber() == nrRoom){
                ratings.add(room.getRating());
            }
        }
        return ratings;
    }

    /**
     *
     * @param ratings
     * @return compute the average by ratings
     */
    public double getAverage(List<Integer> ratings){
        int sum = 0;
        for(Integer rating : ratings){
            sum += rating;
        }
        return (double)sum / ratings.size();
    }

    /**
     *
     * @return decreasing order of rooms by rating
     */
    public Map<Double, Integer> getResult(){
        Map<Double, Integer> result = new TreeMap<>();
        for(Integer room : getAllRooms()){
            List<Integer> ratings = getAllByNumber(room);
            double average = getAverage(ratings);
            result.put(average, room);
        }
        Map<Double, Integer> decreasing = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double rating1, Double rating2) {
                return rating2.compareTo(rating1);
            }
        });
        decreasing.putAll(result);
        return decreasing;
    }

}
