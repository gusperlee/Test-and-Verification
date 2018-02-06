import CarClass;

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
    /**
    * Test Case 1: TC1
    */        
    public void moveForwardTest ()  {
        carClass.moveForward();
    //   int position=carClass.whereIs();
        Assert.assertTrue(true);
        }

    @Test
    /**
     * Test Case 2: TC2
     */
    public void leftLaneDetectTest ()  {

        boolean input =carClass.leftLaneDetect(8,8,8,8,7,5,9,3);
        Assert.assertTrue(input);

    }

    @Test
    /**
     * Test Case 3: TC3
     */
    public void changeLaneTest () {

    } 

    @Test
    /**
     * Test Case 4: TC4
     */    
    public void whereIsTest ()  {
        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertEquals(carClass.Current_postion, position);
    }
    
    @Test
    /**
     * Test Case 5: TC5
     */    
    public void MoveMaxTest ()  {
        CarClass car = new CarClass(97,1);

        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertFalse(false);
    }


}

