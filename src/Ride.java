public class Ride {

    int id;
    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
    User user;

    public Ride(int id,
                String source,
                String destination,
                int total_seats,
                int available_seats,
                double fare,
                User user) {

        this.id = id;
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.fare = fare;
        this.user = user;
    }

    @Override
    public String toString() {

        return "Ride ID: " + id +
                " | " + source +
                " -> " + destination +
                " | Seats: " + available_seats + "/" + total_seats +
                " | Fare: " + fare +
                " | User ID: " + user.user_id +
                " | Owner: " + user.name;
    }
}
