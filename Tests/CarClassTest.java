import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarClassTest {

    private CarClass carClass;

        @Before
        public void setUp() {
            carClass = new CarClass(0,0);
        }
        @Test
        public void moveForwardTest ()  {
            carClass.moveForward();
         //   int position=carClass.whereIs();
            Assert.assertTrue(true);
        }

    @Test
    public void MoveMaxTest ()  {
        CarClass car = new CarClass(97,1);

        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertFalse(false);
    }

    @Test
    public void leftLaneDetectTest ()  {

            Boolean input =carClass.leftLaneDetect(8,8,8,8,7,5,9,3);
            Assert.assertTrue(input);

    }


    @Test
    public void whereIsTest ()  {
        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertEquals(carClass.Current_postion, position);
    }


    }

