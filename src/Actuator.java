
import java.util.ArrayList;

public class Actuator {
	  public  int current_position=0;
	  public  int lane_pos=1 ;


	public boolean moveForward() {
		if (current_position < 96 && current_position >= 0) {            
			current_position += 5;
			return true;
		} else {
			return false;
		}
	}
	
	
	
	 public void changeLane(CarClass car) {

	        if (car.isEmpty && lane_pos!=3) {

	            moveForward();

	            lane_pos++;

	        } else {

	            moveForward();
	        }

	    }

}
