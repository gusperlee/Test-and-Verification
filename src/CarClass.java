import java.util.ArrayList;

public class CarClass {

    public int Current_postion=0;
    public int lane_pos=1;
    ArrayList<Integer> data = new ArrayList<>();
    public int j=0;
    public boolean isEmpty;
    private Radar front_radar = new Radar(0,new ArrayList<Integer>());
    private Radar rear_radar = new Radar(0,new ArrayList<Integer>());
    private Radar left_radar = new Radar(0,new ArrayList<Integer>());
    private Lidar lidar = new Lidar(0, new ArrayList<Integer>());

    public  CarClass (int positionx,int positionY) {
        this.Current_postion=positionx;
        this.lane_pos=positionY;
    }

    // Assuming the car is moving 5 meters whenever the move function is called the car will move 5 meters. it stops  it reaches 100 meters.

    boolean  moveForward(){

       // int wheel_diam =5;
       // int distance=500;
       // int motor_diam;
       // double Spin=500/(2*Math.PI*5);
        if (Current_postion  <100 && Current_postion >=0)  {

              Current_postion+=5;
              return true;

        } else {

            return false;

        }
    }


    public boolean leftLaneDetect (int front, int rear, int left , int lidar_data,
                                   int front1, int rear1, int left1 , int lidar_data1 ) {

        int count_change=0;
        int count_faulty=0;
        querry(front,rear,left,lidar_data);
        querry(front1,rear1,left1,lidar_data1);

        for (int j=0 ; j<8 ; j++) {

            if (data.get(j)== -1 ) {
                count_faulty++;

            } if (data.get(j)==2 ) {
                count_change++;

            }

        }
        if (count_change > 0 &&  count_faulty >2) {
            isEmpty=false;
        } else {
            isEmpty=true;
        }
        return isEmpty;
    }

    public ArrayList<Integer> querry(int front, int rear, int left , int lidar_data) {

        front_radar.checkReading(front);
        rear_radar.checkReading(rear);
        left_radar.checkReading(left);
        lidar.checkReading(lidar_data);

        for (int i=0 ; i<8 ; ) {

            if (data.get(i) !=0) {
            i++;
            } else {
                data.add(front_radar.sensor_data.get(j)) ;
                i++;
            }
        }

        j++;
        return data;
    }

     public void changeLane(){

       if (isEmpty) {

           moveForward();
           this.lane_pos=+1;
       }

    }

    //checks in which lane the car is
    int whereIs() {

        return  Current_postion & lane_pos ;
    }
}