import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    List<user> users = new ArrayList<>();
    List<Ride> rideList = new ArrayList<>();
    List<booking> bookingList = new ArrayList<>();

    int bookingCounter = 1;

    public void signup(int id, String name, String email, int password) {
        user u = new user(id, name, email, password);
        users.add(u);
        System.out.println("Signup successful for " + name);
    }
    public user login(String email, int password) {
        for (user u : users) {
            if (u.email.equals(email) && u.password == password) {
                System.out.println("Login successful: " + u.name);
                return u;
            }
        }
        System.out.println("Invalid email or password");
        return null;
    }

    public void updateUserDetails(user u, String newName, int newPassword) {

        if (u == null) {
            System.out.println("Update failed: user not logged in");
            return;
        }

        u.name = newName;
        u.password = newPassword;

        System.out.println("User details updated successfully");
        System.out.println(u);
    }

    // DELETE USER DETAILS
    public void deleteUserDetails(user u) {

        if (u == null) {
            System.out.println("Delete failed: user not logged in");
            return;
        }

        users.remove(u);
        System.out.println("User deleted successfully");
    }
    public void createRide(int id, String source, String destination,
                           int totalSeats, double fare, user user) {

        Ride ride = new Ride(
                id,
                source,
                destination,
                totalSeats,
                totalSeats,   // available seats initially = total seats
                fare,
                user
        );

        rideList.add(ride);
        System.out.println("Ride created successfully");
    }

    public List<Ride> searchRide(String source, String destination, int seats) {

        List<Ride> availableRide = new ArrayList<>();

        for (Ride ride : rideList) {
            if (ride.source.equalsIgnoreCase(source)
                    && ride.destination.equalsIgnoreCase(destination)
                    && ride.available_seats >= seats) {

                availableRide.add(ride);
            }
        }
        return availableRide;
    }

    // UPDATE RIDE
    public void updateRide(Ride ride, String newSource, String newDestination,
                           int newTotalSeats, double newFare) {

        if (ride == null) {
            System.out.println("Update failed: Ride not found");
            return;
        }

        ride.source = newSource;
        ride.destination = newDestination;
        ride.total_seats = newTotalSeats;
        ride.available_seats = newTotalSeats;
        ride.fare = newFare;

        System.out.println("Ride updated successfully");
        System.out.println(ride);
    }
    // DELETE RIDE
    public void deleteRide(Ride ride) {

        if (ride == null) {
            System.out.println("Delete failed: Ride not found");
            return;
        }

        rideList.remove(ride);
        System.out.println("Ride deleted successfully");
    }

    public void bookRide(Ride ride,user user,int seats_booked ){
        // search ride
        // available seats
        // fare calculate
        // booking create
        // seats update
    }

    public List<Ride> viewRideCreated(user user) {

        List<Ride> createdRides = new ArrayList<>();

        if (user == null) {
            return createdRides;
        }

        for (Ride ride : rideList) {
            if (ride.user.equals(user)) {
                createdRides.add(ride);
            }
        }
        return createdRides;
    }

    public List<Ride> viewRideBooked(user user) {

        List<Ride> bookedRides = new ArrayList<>();

        if (user == null) {
            return bookedRides;
        }

        for (booking b : bookingList) {
            if (b.user.equals(user)) {
                bookedRides.add(b.ride);
            }
        }
        return bookedRides;
    }

    public void updateBooking(booking b, int newSeatsBooked) {

        int oldSeats = b.seats_booked;
        Ride ride = b.ride;

        // Case 1: Increase seats
        if (newSeatsBooked > oldSeats) {
            int extraSeatsNeeded = newSeatsBooked - oldSeats;

            if (ride.available_seats < extraSeatsNeeded) {
                System.out.println("Update failed: Not enough seats available");
                return;
            }

            ride.available_seats -= extraSeatsNeeded;
        }
        // Case 2: Decrease seats
        else if (newSeatsBooked < oldSeats) {
            int seatsToReturn = oldSeats - newSeatsBooked;
            ride.available_seats += seatsToReturn;
        }

        // Update booking details
        b.seats_booked = newSeatsBooked;
        b.total_fare = newSeatsBooked * ride.fare;

        System.out.println("Booking updated successfully!");
        System.out.println(b);
    }
    public void deleteBooking(booking b) {

        // Restore seats
        b.ride.available_seats += b.seats_booked;

        // Remove booking
        bookingList.remove(b);

        System.out.println("Booking deleted successfully!");
    }


}
//future scope:
//time
//Authentication & Authorization
//admin
//mul location
//price bargain
//AI chatbot & fare recommendation
//review
//chat




