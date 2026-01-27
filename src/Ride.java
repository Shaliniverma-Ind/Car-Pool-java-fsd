public class Ride {
    int id;
    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
    User user;


    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                ", user=" + user +
                '}';
    }

    public Ride(int id, String source, String destination, int total_seats, int available_seats, double fare, User user) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.fare = fare;
        this.user = user;


    }
}
