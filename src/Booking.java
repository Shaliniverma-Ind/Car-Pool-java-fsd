public class Booking {
    int booking_id;
    Ride ride;
    User user;
    int seats_booked;
    double total_fare;

    public Booking(int booking_id, User user, Ride ride, int seats_booked, double total_fare) {
        this.booking_id = booking_id;
        this.user = user;
        this.ride = ride;
        this.seats_booked = seats_booked;
        this.total_fare = total_fare;
    }

    @Override
    public String toString() {
        return "booking{" +
                "booking_id=" + booking_id +
                ", ride=" + ride +
                ", user=" + user +
                ", seats_booked=" + seats_booked +
                ", total_fare=" + total_fare +
                '}';
    }
}
