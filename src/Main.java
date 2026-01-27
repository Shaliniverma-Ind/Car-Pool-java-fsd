//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        RideBookingSystem rideBookingSystem = new RideBookingSystem();
        rideBookingSystem.createRide(1,"jaipur","delhi",5,725.00,"shALINI");
        rideBookingSystem.createRide(4,"jaipur","delhi",1,555.00);
        rideBookingSystem.createRide(2,"greator noida","agra",3,340.00);
        rideBookingSystem.createRide(3,"gurugram","faridabad",2,170.00);
          //System.out.println(rideBookingSystem.showAllRide());
          System.out.println(rideBookingSystem.searchRide("jaipur","agra",2));
    }
}