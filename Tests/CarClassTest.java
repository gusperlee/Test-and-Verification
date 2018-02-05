import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarClassTest {

    private CarClass carClass;

        @Before
        public void setUp() {
            carClass = new CarClass(0);
        }
        @Test
        public void moveForwardTest ()  {
            carClass.moveForward();
            int position=carClass.whereIs();
            Assert.assertTrue(true);
        }

    @Test
    public void TestmoveForwardOutofbounds ()  {
        CarClass car = new CarClass(97);

        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertFalse(false);
    }



    @Test
    public void whereIsTest ()  {
        carClass.moveForward();
        int position=carClass.whereIs();
        Assert.assertEquals(carClass.Current_postion, position);
    }
    }

