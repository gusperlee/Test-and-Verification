package production;

import java.util.ArrayList;
import java.util.List;


public interface CarInterface{

	
    /**
    Description:    This is the data structure, It uses List data structure to hold the position of car and saved parking spots.
    Pre-condition:  Car is on the street and in the 0-100 (meters) range
    Post-condtion:  None
    Test-cases:     None
    */
    class PositionData{
        int lane = 0;
        int position = 0;

        public PositionData(Integer carPosition, Integer carLane){
            this.position = carPosition;
            this.lane = carLane;

        }

        // Getters
        public int getPosition(){
        	return this.position;
        }
        
        public int getLane(){
        	return this.carLane;
        }
    }

    
    
    /**
    Description: This class holds the position of the car and returns if it is parked or not. 
    Pre-condition: Car is on the street and in the 0-500 range
    Post-condtion: None
    Test-cases: None
    */
    class CarPosition {
        int position;
        boolean parked;

        public CarPosition(int position, int lane){
            this.position = position;
            this.lane = lane;

        }

        // Getters
        public int getPosition(){
            return this.position;
        }
        
        public int getLane(){
            return this.lane;
        }
        
    }
    
    
	
	/**
	 Description: This method moves forward the car by 1 meter when called.
                  It returns the position of the car and a list of available parking slots..
	 Pre-condition: Car is on the street and in the 0-499 range. The car can not be parked.
	 Post-condtion: The car has moved 1 meter. 
	 Test-cases: TC1, TC7
	 */
    PositionData moveForward();

      
    
    
    /**
    Description: The methos returns the x postion of the car and whether it is parked or not.
    Pre-condition: Car is on the street and in the 0-500. It may be parked or not.
    Post-condtion: None
    Test-cases: TC4
    */
    CarPosition whereIs();





}
