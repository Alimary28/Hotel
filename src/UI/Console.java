package UI;
import Domain.Room;
import Service.RoomService;

import java.util.Map;
import java.util.Scanner;

public class Console {
    private RoomService service;
    private Scanner scanner;

    public Console(RoomService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Show the room and the rating");
        System.out.println("a. Show all rooms");
        System.out.println("x. Exit");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckIn();
            } else if (option.equals("2")) {
                handleCheckOut();
            } else if (option.equals("3")) {
                handleFeedback();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }
    private void handleCheckIn() {

        try {
            System.out.println("Give the room ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Give the number of the room: ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Number of the persons: ");
            int persons = Integer.parseInt(scanner.nextLine());
            System.out.println("Number of days: ");
            int days = Integer.parseInt(scanner.nextLine());

            service.checkIn(id, number, persons, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Showing errors: " + runtimeException.getMessage());
        }
    }
    private void handleCheckOut() {
        try {
            System.out.println("Enter the number of the room: ");
            int numberOfRoom = Integer.parseInt(scanner.nextLine());
            System.out.println("Give a feedback: ");
            String feedback = scanner.nextLine();
            System.out.println("Give a rating for the room: ");
            int rating = Integer.parseInt(scanner.nextLine());

            service.checkOut(numberOfRoom, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Showing errors: " + runtimeException.getMessage());
        }

    }
    private void handleFeedback(){
        Map<Double, Integer> result = service.getResult();
        for(Double rating : result.keySet()){
            System.out.println("Room number: " + result.get(rating) + " rating: " + rating);
        }
    }
    private void handleShowAll(){
        for (Room room : service.getAll())
            System.out.println(room);
    }
}