import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import java.awt.Point;
import java.util.ArrayList;

public class CarClassTest {

    private CarClass carClass;

        @Before
        public void setUp() {
            carClass = new CarClass(0,1);
        }

        @Test
        public void moveForwardTest ()  {
            ArrayList<Integer> position ;

           // for (int i =0 ; i < 18 ; i++) {
                carClass.moveForward();

           // }
            position=carClass.whereIs();
            Assert.assertTrue(true);
            Assert.assertEquals(carClass.current_postion , position.get(0).intValue());
            Assert.assertEquals(position.get(1).intValue() , carClass.lane_pos );
            if (position.get(0)>95) {
                Assert.assertFalse(false);
                Assert.assertEquals(carClass.current_postion , position.get(0).intValue());

            }
          ///  System.out.println(initial_pos.toString());


        }

    @Test
    public void MoveMaxTest ()  {
        CarClass car = new CarClass(55,1);
        ArrayList<Integer> pos ;

        car.moveForward();
        pos=car.whereIs();
        Assert.assertFalse(false);
        Assert.assertEquals(pos.get(0).intValue(),car.current_postion);
        Assert.assertEquals(pos.get(1).intValue(),car.lane_pos);
        System.out.println("check check " + car.current_postion + pos.get(0));

    }

    @Test
    public void leftLaneDetectTest ()  {

            boolean input =carClass.leftLaneDetect(11,11,214,199,12,13,12,17);
            CarClass car =new CarClass(50,1);
            boolean input2 =car.leftLaneDetect(5,2,66,18,4,3,2,13);
            //Assert.assertTrue(input);
            Assert.assertFalse(input2);
            Assert.assertTrue(input);

    }


    @Test
    public void whereIsTest ()  {
        ArrayList<Integer> position ;
        position=carClass.whereIs();
        Assert.assertEquals(carClass.current_postion, position.get(0).intValue());
        Assert.assertEquals(carClass.lane_pos, position.get(1).intValue());

    }

    @Test
    public void changeLaneTest ()  {

        ArrayList<Integer> position ;
                position=carClass.whereIs();
        carClass.changeLane();
        Assert.assertTrue(carClass.isEmpty);
        Assert.assertEquals(position.get(0) +5 , carClass.current_postion);

        Assert.assertEquals( position.get(0) +1 ,carClass.lane_pos );
        System.out.println("pos" + position.get(0)  );
        System.out.println("curent pos" + carClass.current_postion  );

    }



}

