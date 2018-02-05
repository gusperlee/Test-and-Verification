import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.abs;

public class CarClass implements CarInterface{

    Random rand = new Random();
    // x,y positions of the car    
    int xPos = 0;
    int yPos = 0;

    Street street = new Street(100);
    PositionData positionData = new PositionData(xPos,yPos);

    Radar front_radar = new Radar(0,new int [2]);
    Radar rear_radar = new Radar(0,new int [2]);
    Radar left_radar = new Radar(0,new int [2]);
    Lidar lidar = new Lidar(0,new int[1]);



    public  CarClass () {
        xPos = 0;
        yPos = 0;
        street = new Street(100);
        positionData = new PositionData(xPos,yPos);
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
    public PositionData getPositionData() {
        return positionData;
    }
    public int getPosition() {
        return yPos;
    }
    public int getLane(){
        return xPos;
    }
    // Assuming the car is moving 5 meters whenever the move function is called the car will move 5 meters. it stops  it reaches 100 meters.

    public PositionData moveForward(){

       // int wheel_diam =5;
       // int distance=500;
       // int motor_diam;
       // double Spin=500/(2*Math.PI*5);

        if ( yPos <100 )  {
            yPos +=5;
            positionData.position = yPos;
            System.out.println(positionData.position);
            return positionData;
        }
        System.out.println("Car is at the end of the street.");
        return positionData;
    }

    void leftLaneDetect (){

        int car_dist=500;
        int Speed_of_Sound= 3430;
        double time = Speed_of_Sound/car_dist;




    }

    void changeLane(){


    }

    //checks in the position of car
//    int whereIs() {
//        return  Current_postion;
//    }

    public CarPosition whereIs() {

        carPosition.position  = yPos;
        carPosition.lane = xPos;

        System.out.println(carPosition.lane + carPosition.position );

        return carPosition;

    }

    // main for testing
    public static void main(String[] args) {

        Car car = new Car();

        for (int i = 0; i < 100; i++) {
            car.moveForward();
        }

    }

}