import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import java.awt.Point;

public class CarClassTest {

    private CarClass carClass;

    @Before
    public void setUp() {
        carClass = new CarClass(75,1);
    }

    @Test
    public void moveForwardTest ()  {
        Point position ;

        position=carClass.whereIs();
        Assert.assertTrue(carClass.moveForward());
        Assert.assertEquals(carClass.actuator.current_position  , position.x +5);
        Assert.assertEquals(carClass.actuator.lane_pos,position.y   );
    }

    @Test
    public void MoveMaxTest ()  {
        carClass = new CarClass(98,1);

        Point intial_pos;
        intial_pos=carClass.whereIs();
        Assert.assertFalse( carClass.moveForward());
        Assert.assertEquals(intial_pos.x,carClass.actuator.current_position);
        Assert.assertEquals(intial_pos.y,carClass.actuator.lane_pos);

    }

    @Test
    public void leftLaneDetectFreeWay_twoFaultySensorsTest ()  {

        carClass.leftLaneDetect(15,55,60,13,12,55,60,15);
        Assert.assertTrue(carClass.isEmpty);
    }

    @Test
    public void leftLaneDetectObstacleOnTheLeft_twoFaultySensorsTest ()  {

        carClass.leftLaneDetect(5,55,60,15,5,55,60,15);
        Assert.assertFalse(carClass.isEmpty);
        Assert.assertEquals("you have more than 1 corrupted sensor",carClass.error_message);

    }

    @Test
    public void leftLaneDetectObstacleOnTheLeft_noFaultySensor ()  {

        carClass.leftLaneDetect(5,15,15,15,5,15,15,15);
        Assert.assertFalse(carClass.isEmpty);
        Assert.assertEquals("there is an obstacle on the left",carClass.error_message);

    }

    @Test
    public void whereIsTest () {
        Point position;
        position = carClass.whereIs();
        Assert.assertEquals(carClass.actuator.current_position, position.x);
        Assert.assertEquals(carClass.actuator.lane_pos, position.y);

    }

    @Test
    public void whereIsTest_afterMove ()  {
        Point position_after ;
        carClass.moveForward();
        position_after=carClass.whereIs();

        Assert.assertEquals(carClass.actuator.current_position, position_after.x );
        Assert.assertEquals(carClass.actuator.lane_pos, position_after.y);

    }

    @Test
    public void changeLaneTest_StartInThirdLane  ()  {

        CarClass car2 = new CarClass(50,3);
        Point position ;

        car2.leftLaneDetect( 4,4,4,4,4,4,4,4);
        position=car2.whereIs();
        car2.changeLane();
        Assert.assertEquals( car2.actuator.current_position ,position.x +5);
        Assert.assertEquals( car2.actuator.lane_pos, position.y );

    }

    @Test
    public void changeLaneTest_FirstLanePosition_Change()  {

        Point new_position=carClass.whereIs();;

        carClass.leftLaneDetect(15,55,60,13,12,55,60,15);
        carClass.changeLane();

        Assert.assertEquals( carClass.actuator.current_position ,new_position.x + 5);
        Assert.assertEquals( carClass.actuator.lane_pos, new_position.y +1  );

    }

    @Test
    public void changeLaneTest_SecondLanePositionc_Change()  {

        CarClass car3 = new CarClass(35,2);
        Point position=car3.whereIs();

        car3.leftLaneDetect(15,55,60,13,12,55,60,15);
        Assert.assertTrue(car3.isEmpty);

        car3.changeLane();

        Assert.assertEquals( car3.actuator.current_position ,position.x + 5);
        Assert.assertEquals( car3.actuator.lane_pos, position.y +1  );

    }

    @Test
    public void changeLaneTest_WithNOObstacle()  {

        Point position=carClass.whereIs();

        carClass.leftLaneDetect(5,7,60,13,5,7,60,15);
        Assert.assertFalse(carClass.isEmpty);
        carClass.changeLane();

        Assert.assertEquals( carClass.actuator.current_position ,position.x + 5);
        Assert.assertEquals( carClass.actuator.lane_pos, position.y );

    }

    @Test
    public void changeLaneTest_WithObstacle ()  {
        carClass.leftLaneDetect(5,7,60,-55,5,-7,-12,-100);
        Point  position=carClass.whereIs();
        carClass.changeLane();
        Assert.assertFalse(carClass.isEmpty);
        Assert.assertEquals(position.x +5 , carClass.actuator.current_position);

        Assert.assertEquals( carClass.actuator.lane_pos, position.y);
    }

}




