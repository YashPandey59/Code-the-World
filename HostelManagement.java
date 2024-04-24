import java.util.ArrayList;
import java.util.Scanner;

class HostelRoom {
    private int roomNumber;
    private int capacity;
    private ArrayList<Student> students;

    public HostelRoom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean isFull() {
        return students.size() >= capacity;
    }

    public void addStudent(Student student) {
        if (!isFull()) {
            students.add(student);
            System.out.println(student.getName() + " has been assigned to room " + roomNumber);
        } else {
            System.out.println("Room " + roomNumber + " is already full.");
        }
    }

    public void displayRoomInfo() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupants: " + students.size());
    }
}

class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

public class HostelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<HostelRoom> rooms = new ArrayList<>();
        int totalRooms = 10; 
		
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRoom(scanner, rooms);
                    break;

                case 2:
                    displayRoomInfo(scanner, rooms);
                    break;

                case 3:
                    assignStudentToRoom(scanner, rooms);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

           
            int roomsLeft = totalRooms - rooms.size();
            System.out.println("Rooms Left: " + roomsLeft);
        }
    }

    private static void printMenu() {
        System.out.println("\nHostel Management System");
        System.out.println("1. Add Room");
        System.out.println("2. Display Room Info");
        System.out.println("3. Assign Student to Room");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addRoom(Scanner scanner, ArrayList<HostelRoom> rooms) {
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter Room Capacity: ");
        int capacity = scanner.nextInt();
        HostelRoom room = new HostelRoom(roomNumber, capacity);
        rooms.add(room);
        System.out.println("Room added successfully.");
    }

    private static void displayRoomInfo(Scanner scanner, ArrayList<HostelRoom> rooms) {
        System.out.print("Enter Room Number: ");
        int displayRoomNumber = scanner.nextInt();
        for (HostelRoom hostelRoom : rooms) {
            if (hostelRoom.getRoomNumber() == displayRoomNumber) {
                hostelRoom.displayRoomInfo();
                return;
            }
        }
        System.out.println("Room not found.");
    }

    private static void assignStudentToRoom(Scanner scanner, ArrayList<HostelRoom> rooms) {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();
        System.out.print("Enter Student Roll Number: ");
        int studentRollNumber = scanner.nextInt();

        System.out.print("Enter Room Number to Assign Student: ");
        int assignRoomNumber = scanner.nextInt();
        for (HostelRoom hostelRoom : rooms) {
            if (hostelRoom.getRoomNumber() == assignRoomNumber) {
                Student student = new Student(studentName, studentRollNumber);
                hostelRoom.addStudent(student);
                return;
            }
        }
        System.out.println("Room not found.");
    }
}