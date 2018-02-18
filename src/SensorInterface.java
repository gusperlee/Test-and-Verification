public interface SensorInterface {
    /**
     * Description: Checks if the reading received is within range
     * Pre-condition: None
     * Post-condition: Has returned a value (2, 1 or -1) if the measurement is too close, within range or out of range, respectively
     * Test-cases:
     */
    int checkReading(int to_obstacle);
}
