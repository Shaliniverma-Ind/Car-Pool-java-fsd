import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RideBookingSystem system = new RideBookingSystem();

        User currentUser = null;

        while (true) {

            System.out.println("\n1 Create Account");
            System.out.println("2 Login");
            System.out.println("3 Create Ride");
            System.out.println("4 View Rides");
            System.out.println("5 Book Ride");
            System.out.println("0 Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    currentUser = system.signup(name, email, password);

                    break;


                case 2:

                    System.out.print("Enter email: ");
                    email = sc.nextLine();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    currentUser = system.login(email, password);

                    break;


                case 3:

                    if (currentUser == null) {
                        System.out.println("Login first");
                        break;
                    }

                    System.out.print("Enter source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter destination: ");
                    String dest = sc.nextLine();

                    System.out.print("Enter seats: ");
                    int seats = sc.nextInt();

                    System.out.print("Enter fare: ");
                    double fare = sc.nextDouble();

                    system.createRide(source, dest, seats, fare, currentUser);

                    break;


                case 4:

                    List<Ride> rides = system.viewAllRidesFromDB();

                    for (Ride r : rides)
                        System.out.println(r);

                    break;


                case 5:

                    if (currentUser == null) {
                        System.out.println("Login first");
                        break;
                    }

                    System.out.print("Enter ride ID: ");
                    int rideId = sc.nextInt();

                    System.out.print("Enter seats: ");
                    seats = sc.nextInt();

                    System.out.print("Enter total fare: ");
                    int totalFare = sc.nextInt();

                    system.bookRide(rideId, currentUser, seats, totalFare);

                    break;


                case 0:

                    System.exit(0);
            }
        }
    }
}
