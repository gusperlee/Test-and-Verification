public interface SensorInterface {
    /**
     * Description: getDistance_obs gets the distance to the nearest obstacle using a sensor (radar or lidar)
     * Pre-condition: None
     * Post-condition:
     * Test-cases:
     */
    //int getDistance_obs();

    /**
     * Description:
     * Pre-condition:
     * Post-condition:
     * Test-cases:
     */
    boolean check_left_lane(int dis_to_target);

    /**
     * Description:
     * Pre-condition:
     * Post-condition:
     * Test-cases:
     */
    public int checkReading(int to_obstacle);
}
