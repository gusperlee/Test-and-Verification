
public interface ActuatorInterface {

	 /**
	  * Description: moveForward makes the car move 5 meters forward
	  * Pre-condition: car is on the road and in 0-100 range
      * Post-condition: car moved 5 meters forward 
	  * Test-cases:
      */
	boolean moveForward();
	
	 /**
	  * Description: changeLane makes the car change lane to the left one
	  * Pre-condition: no car on left lane, last lane (3rd) not reached
	  * Post-condition: lane changed 
	  * Test-cases:
	  */
	void changeLane();
		
}
