import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void create(){
        /*
         * Mock to sensors from the sensor interface
         * */
        Sensor sensors[]=new Sensor[8];
        sensors[0]     = mock(Radar.class);
        sensors[1]     = mock(Radar.class);
        sensors[2]     = mock(Radar.class);
        sensors[3]     = mock(Lidar.class);
        sensors[4]     = mock(Radar.class);
        sensors[5]     = mock(Radar.class);
        sensors[6]     = mock(Radar.class);
        sensors[7]     = mock(Lidar.class);
        int obstacle_counter = 0;
        int lane_pos = 1;
        boolean isEmpty = true;
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
         * Stub the moveForward method so that it return 5 for all integers
         * */
        when(actuator.moveForward(testcar.whereIs())).thenReturn(5);
		/*
		 *
		 */
		when(actuator.changeLane(testcar.isEmpty(true))).thenReturn(lane_pos++);
        /*
         * Stub the read method from sensors so that it return the value
         * */
        for(int i=0;i<sensors.length;i++)
            for(int n=0;n<100;n++)
                when(sensors[i].checkReading(2)).thenReturn(isEmpty=false);

    }

    @Test
    public void test(){
        boolean test = true;
        for(int i = 0; i < 96; i+=5){
            testcar.moveForward();
        }
        test = test && testcar.whereIs();

        /*
         * Move the car to 50
         * */
        for(int i=0;i<10;i+=5){
            testcar.moveForward();
        }


        testcar.leftLaneDetect(sensors[i]);
        /*
         * test if the car could change lane
         * */

        test = test && testcar.isEmpty(false)&& testcar.WhereIs().positionX+5;
        
        /*
         * then move to the end of the road.
         * */
        for(int i=testcar.whereIs();i<99;i++){
            testcar.moveForward();
        }
        /*
         * verify test
         * */
        assertTrue(test);
    }










}
