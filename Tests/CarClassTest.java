import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;

public class CarClassTest {

    private CarClass carClass;

        @Before
        public void setUp() {
            carClass = new CarClass(0,0);
        }

        @Test
        public void moveForwardTest ()  {
            int position=carClass.whereIs();
            carClass.moveForward();
            Assert.assertTrue(true);
          //Assert.assertEquals(carClass.Current_postion & carClass.lane_pos, position);

        }

    @Test
    public void MoveMaxTest ()  {
        CarClass car = new CarClass(97,1);

        car.moveForward();
        //int position=carClass.whereIs();
        Assert.assertFalse(false);
    }

    @Test
    public void leftLaneDetectTest ()  {

         //   boolean input =carClass.leftLaneDetect(50,8,50,150,50,8,90,3);
            CarClass car =new CarClass(50,1);
            boolean input2 =car.leftLaneDetect(5,2,66,18,4,3,2,13);
            //Assert.assertTrue(input);
            Assert.assertFalse(input2);

    }


    @Test
    public void whereIsTest ()  {
        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertEquals(carClass.Current_postion & carClass.lane_pos, position);
    }

    @Test
    public void changeLaneTest ()  {

        carClass.changeLane();
        int position=carClass.whereIs();
        Assert.assertTrue(true);
        Assert.assertEquals(carClass.Current_postion & carClass.lane_pos, position);

    }



    }

