
import java.util.ArrayList;

public class Actuator {
	/**
	 * Description:
	 * Moves the car forward one meter, but limited to bounds
	 * Pre-Condition:
	 * 1. Car is not over the bound of street
	 * Post-Condition:
	 * the car moving forward and update the car position
         * Test-Cases:
         *
	 * @return
	 */

	int carPosition[] = new int[10]; 
	public boolean moveForward(CarClass car) {
		if (car.current_position < 96 && car.current_position >= 0) {

			car.current_position += 5;
			return true;

		} else {

			return false;

		}
	}
		/**
	 * Description:
	 * Moves the car forward one meter, but limited to bounds
	 * Pre-Condition:
	 * 1. Car is on the leftest lane and there is no car driving in the left side of car
	 * Post-Condition:
	 * the car move to the left side lane next to previous lane and update the car position
         * Test-Cases:
         *
	 * @return
	 */
	
	
	 public void changeLane(CarClass car) {

	        if (car.isEmpty && car.current_position!=3) {

	            car.moveForward();

	            car.lane_pos++;

	        } else {

	            car.moveForward();
	        }

	    }

}
