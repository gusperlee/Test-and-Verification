import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import java.awt.Point;

public class CarClassTest {

    private CarClass carClass;

        @Before
        public void setUp() {
            carClass = new CarClass(0,1);
        }

        @Test
        public void moveForwardTest() {
            Point position ;
            carClass.moveForward();

            position=carClass.whereIs();
            Assert.assertTrue(true);
            Assert.assertEquals(carClass.current_position, position.x);
            Assert.assertEquals(position.y, carClass.lane_pos );

            if (position.x>95) {
                Assert.assertFalse(false);
                Assert.assertEquals(carClass.current_position, position.x);

            }
        }

    @Test
    public void MoveMaxTest ()  {
        CarClass car = new CarClass(55,1);
        Point pos ;

        car.moveForward();
        pos=car.whereIs();
        Assert.assertFalse(false);
        Assert.assertEquals(pos.x,car.current_position);
        Assert.assertEquals(pos.y,car.lane_pos);
        System.out.println("check pos " + car.current_position + pos.x);

    }

    @Test
    public void leftLaneDetectTest ()  {

           boolean input =carClass.leftLaneDetect(160,-2,5,15,70,120,6,44);
            CarClass car =new CarClass(50,1);
            boolean input2 =car.leftLaneDetect(24,80,60,14,23,18,9,31);
            Assert.assertFalse(input);
            Assert.assertTrue(input2);
            Assert.assertEquals("you have more than 1 corrupted sensor",car.error_message);

    }

    @Test
    public void whereIsTest ()  {
        Point position ;
        position=carClass.whereIs();
        Assert.assertEquals(carClass.current_position, position.x);
        Assert.assertEquals(carClass.lane_pos, position.y);

    }

    @Test
    public void changeLaneTest ()  {
    	carClass = new CarClass(0,1);
        boolean input =carClass.leftLaneDetect(12,-2,60,55,100,-4,-12,100);
        Point position ;
        position=carClass.whereIs();
        carClass.changeLane();
     
        Assert.assertTrue(carClass.isEmpty);
        Assert.assertEquals(position.x +5 , carClass.current_position);

        Assert.assertEquals( position.y +1 ,carClass.lane_pos );
        System.out.println("pos" + position.x);
        System.out.println("current pos" + carClass.current_position);
    }
}

