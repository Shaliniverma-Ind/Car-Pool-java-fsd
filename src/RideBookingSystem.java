import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    public User signup(String name, String email, String password) {

        User user = null;

        try {

            Connection conn = DBConnection.getConnection();

            String checkSql = "SELECT userid FROM users WHERE email = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, email);

            ResultSet checkRs = checkPs.executeQuery();

            if (checkRs.next()) {

                System.out.println("Account already exists");
                return null;
            }

            String sql = "INSERT INTO users(name,email,pass) VALUES (?,?,?) RETURNING userid";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("userid");

                user = new User(id, name, email, password);

                System.out.println("Signup successful");
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }


    public User login(String email, String password) {

        User user = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT userid, name FROM users WHERE email = ? AND pass = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("userid");

                String name = rs.getString("name");

                user = new User(id, name, email, password);

                System.out.println("Login successful");
            }
            else {

                System.out.println("Invalid login");
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }


    public int createRide(String source,
                          String destination,
                          int seats,
                          double fare,
                          User user) {

        int rideId = -1;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = """
                    INSERT INTO ride(
                    source,
                    dest,
                    total_seats,
                    available_seats,
                    fare,
                    created_by)
                    VALUES (?, ?, ?, ?, ?, ?)
                    RETURNING ride_id
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, source);
            ps.setString(2, destination);
            ps.setInt(3, seats);
            ps.setInt(4, seats);
            ps.setDouble(5, fare);
            ps.setInt(6, user.user_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                rideId = rs.getInt("ride_id");

                System.out.println("Ride created with Ride ID: " + rideId);
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return rideId;
    }


    public List<Ride> viewAllRidesFromDB() {

        List<Ride> rides = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = """
                    SELECT r.ride_id,
                           r.source,
                           r.dest,
                           r.total_seats,
                           r.available_seats,
                           r.fare,
                           u.userid,
                           u.name
                    FROM ride r
                    JOIN users u
                    ON r.created_by = u.userid
                    ORDER BY r.ride_id
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int rideId = rs.getInt("ride_id");
                String source = rs.getString("source");
                String dest = rs.getString("dest");
                int totalSeats = rs.getInt("total_seats");
                int availableSeats = rs.getInt("available_seats");
                double fare = rs.getDouble("fare");
                int uid = rs.getInt("userid");
                String uname = rs.getString("name");

                User owner = new User(uid, uname, null, null);

                Ride ride = new Ride(
                        rideId,
                        source,
                        dest,
                        totalSeats,
                        availableSeats,
                        fare,
                        owner
                );

                rides.add(ride);
            }

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return rides;
    }


    public void bookRide(int rideId,
                         User user,
                         int seats,
                         int totalFare) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = """
                    INSERT INTO booking(
                    ride_id,
                    userid,
                    seats_booked,
                    total_fare)
                    VALUES (?, ?, ?, ?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rideId);
            ps.setInt(2, user.user_id);
            ps.setInt(3, seats);
            ps.setInt(4, totalFare);

            ps.executeUpdate();

            System.out.println("Ride booked successfully");

        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
}
