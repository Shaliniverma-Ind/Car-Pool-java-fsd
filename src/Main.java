//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        RideBookingSystem rideBookingSystem = new RideBookingSystem();
        rideBookingSystem.createRide(1,"jaipur","delhi",5,725.00,new User(12331,"shALINI","sfffss",13312313));
        rideBookingSystem.createRide(4,"jaipur","delhi",1,555.00,new User(122221,"shI","fss",22222313));
        rideBookingSystem.createRide(2,"greator noida","agra",3,340.00,new User(31,"sI","fffs",13));
        rideBookingSystem.createRide(3,"gurugram","faridabad",2,170.00,new User(555,"sFGDGDGD","sWEDFWSFs",1333333));
          //System.out.println(rideBookingSystem.showAllRide());
          System.out.println(rideBookingSystem.searchRide("jaipur","agra",2));

        Connection conn =   DBConnection.getConnection();

        if (conn != null) {
            System.out.println("PostgreSQL connected successfully from Java!");
        } else {
            System.out.println("Database connection failed!");
        }
    }
}