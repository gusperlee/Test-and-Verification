public interface SensorInterface {
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
