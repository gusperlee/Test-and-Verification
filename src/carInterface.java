import java.awt.Point;
import java.util.ArrayList;

 interface CarInterface {

    /**
     * Description: This method moves forward the car by 5 meters when called, using the actuator.
     * Pre-condition: Car is on the street and in the 0-100 range.
     * Post-condition: The car has moved 5 meter.
     * Test-cases:
     */
    boolean moveForward();

    /**
     * Description: The method returns the x and y position of the car.
     * Pre-condition: Car is on the street and in the 0-100 range.
     * Post-condition: None
     * Test-cases:
     */
    Point whereIs();

    /**
     * Description: The method calls leftLaneDetect() and if it returns true, then change to the lane on the left.
     * Pre-condition: Car is on the street and in the 0-100 range on the y-axis and between 0-1.99999... on the y-axis.
     * Post-condition: None
     * Test-cases:
     */
    void changeLane();

    /**
     * Description: Takes eight consecutive measurements, taken from the four sensors, as arguments and checks if these
     * are within bound of normality (0m-50m). If this is the case, check if there is an obstacle directly to the left of the car (0m-8m).
     * Pre-condition:
     * Post-condition:
     * Test-cases:
     */
    boolean leftLaneDetect(int front, int rear, int left, int lidar_data, int front1, int rear1, int left1, int lidar_data1);
}
