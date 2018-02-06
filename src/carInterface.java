//package production;

import java.util.ArrayList;
import java.util.List;


public interface CarInterface {

    /**
     * Description: This method moves forward the car by 1 meter when called.
     * Pre-condition: Car is on the street and in the 0-100 range.
     * Post-condtion: The car has moved 1 meter.
     * Test-cases:
     */
    boolean moveForward();


    /**
     * Description: The method returns the x and y position of the car.
     * Pre-condition: Car is on the street and in the 0-100 range.
     * Post-condtion: None
     * Test-cases:
     */
    int[] whereIs();


    /**
     * Description: The method calls checkLeftLane() and if it returns true, then change to the lane on the left.
     * Pre-condition: Car is on the street and in the 0-100 range on the y-axis and between 0-1.99999... on the y-axis.
     * Post-condtion: None
     * Test-cases:
     */
    void changeLane();

    /**
     * Description:
     * Pre-condition:
     * Post-condtion:
     * Test-cases:
     */
    boolean leftLaneDetect(int front, int rear, int left, int lidar_data, int front1, int rear1, int left1, int lidar_data1);
}
