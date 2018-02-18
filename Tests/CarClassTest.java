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
        public void moveForwardTest() {
            ArrayList<Integer> position ;

           // for (int i =0 ; i < 18 ; i++) {
                carClass.moveForward();

           // }
            position=carClass.whereIs();
            Assert.assertTrue(true);
            Assert.assertEquals(carClass.current_position , position.get(0).intValue());
            Assert.assertEquals(position.get(1).intValue() , carClass.lane_pos );

            if (position.get(0)>95) {
                Assert.assertFalse(false);
                Assert.assertEquals(carClass.current_position , position.get(0).intValue());

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
        Assert.assertEquals(pos.get(0).intValue(),car.current_position);
        Assert.assertEquals(pos.get(1).intValue(),car.lane_pos);
        System.out.println("check pos " + car.current_position + pos.get(0));

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
        ArrayList<Integer> position ;
        position=carClass.whereIs();
        Assert.assertEquals(carClass.current_position, position.get(0).intValue());
        Assert.assertEquals(carClass.lane_pos, position.get(1).intValue());

    }
    @Test
    public void changeLaneTest ()  {
    	 carClass = new CarClass(0,1);
    	 boolean input =carClass.leftLaneDetect(12,-2,60,55,100,-4,-12,100);
        ArrayList<Integer> position ;
        position=carClass.whereIs();
        carClass.changeLane();
     
        Assert.assertTrue(carClass.isEmpty);
        Assert.assertEquals(position.get(0) +5 , carClass.current_position);

        Assert.assertEquals( position.get(1) +1 ,carClass.lane_pos );
        System.out.println("pos" + position.get(0)  );
        System.out.println("current pos" + carClass.current_position  );
    }
    
    
    
    @Test
    public void Scenario_perfect_movement () {
    	CarClass car1 = new CarClass(0,0);
    	ArrayList<Integer> position = car1.whereIs();
    	
    	for (int i=0;i<5;i++){ //move car 25 m forward
    	car1.moveForward();
    	}
    	car1.leftLaneDetect(25, 20, 27, 15, 21, 20, 26, 14);
    	car1.changeLane();
    	while (car1.moveForward()==true){
    		car1.moveForward();
    	}
    	Assert.assertEquals(car1.whereIs().get(0)+0 ,100);

        Assert.assertEquals(car1.whereIs().get(1)+0 ,1);
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

