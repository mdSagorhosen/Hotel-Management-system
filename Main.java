import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isOccupied;
    private double rate;

    public Room(int roomNumber, double rate) {
        this.roomNumber = roomNumber;
        this.rate = rate;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getRate() {
        return rate;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        for (int i = 0; i < numRooms; i++) {
            rooms.add(new Room(i + 1, 100)); // Assuming a default rate of 100 for all rooms
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setOccupied(true);
                System.out.println("Room " + roomNumber + " booked successfully.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    public void printAvailableRooms() {
        List<Room> availableRooms = getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("Available rooms:");
            for (Room room : availableRooms) {
                System.out.println("Room " + room.getRoomNumber() + ", Rate: $" + room.getRate() + " per night");
            }
        }
    }
}

class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(10); // Assuming the hotel has 10 rooms

        while (true) {
            System.out.println("\n1. View available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.printAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    hotel.bookRoom(roomNumber);
                    break;
                case 3:
                    System.out.println("Thank you for using the hotel management system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
