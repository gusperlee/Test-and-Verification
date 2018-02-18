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
     * 1. Car is on the road and not reach the bound of road
     * Post-condition:
     * return if there is car in the left lane next to current lane
     * Test-cases:
     */
    boolean check_left_lane(int dis_to_target);

	/**
	 * Method used for reading a sensor.
	 * Pre-Condition
	 * 1. Car is on the road 
	 * Post-Condition
	 * 1. The sensor returns a reading.
	 * Tests
     * @return int
     */
    public int checkReading(int to_obstacle);
}
