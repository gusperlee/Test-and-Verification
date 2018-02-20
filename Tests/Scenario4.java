import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

public class Scenario4 implements TestInterface {
    /*
     * This scenario is take from the TAV Assignment Phase 2,The Car
     * 1. Starts at the beginning of the street,
     * 2. Moves along the street 50 meters
     * 3. It senses the left-hand-side lane and in both queries receives within-range values and these sensors values
     *    show there is a car on the left-hand-side lane.
     * 4. Keep moves on current lane until the end of the street

     * */
    private Sensor   sensors[];
    private Actuator actuator;
    private CarClass testcar;


    public void create(){
        /*
         * Mock to sensors from the sensor interface
         * */
        Sensor front,rear,left = new Radar;
        Sensor lidar_data = new Lidar;
        Sensor front    = mock(Radar.class);
        Sensor rear    = mock(Radar.class);
        Sensor left    = mock(Radar.class);
        Sensor lidar_data    = mock(Lidar.class);
        /*
         * Mock the actuator interface
         */
        actuator = mock(Actuator.class);
        /*
         * Initiate car to the begin of street position zero
         */
        testcar = new CarClass(0,1);
        this.sensors = sensors;
        private boolean isEmpty=true;
        /*
         * Stub the moveF method so that it return 50 for all integers
         * */
        when(actuator.moveForward(testcar.whereIs())).thenReturn(50);
		/*
		 *
		 */
        when(testcar.querry(2,3,4,5)).thenReturn(isEmpty(false));

    }

    @Test
    public void test(){
        boolean test = true;
        for(int i = 0; i < 96; i+=5){
            testcar.moveForward();
        }
        test = test && testcar.whereIs(98);


        testcar.leftLaneDetect(3,3,3,3);

        test = test && testcar.isEmpty().isEmpty == false;
        
        /*
         * then move to the end of the road.
         * */
        for(int i=testcar.whereIs();i<99;i++){
            testcar.moveForward();
        }
        /*
         * test if car moved to the end of the road
         * */
        test=test && testcar.whereIs(99);
        /*
         * verify test
         * */
        assertTrue(test);
    }










}
