import java.awt.*;
import java.util.ArrayList;

public class CarClass {

    public  int current_postion;
    public  int lane_pos=1 ;
    public ArrayList<Integer> data = new ArrayList<>();
    public  boolean isEmpty=true;
   // public Point Coordinates = new Point (Current_postion,lane_pos );

    private Radar front_radar = new Radar(0, new ArrayList<>());
    private Radar rear_radar = new Radar(0, new ArrayList<>());
    private Radar left_radar = new Radar(0, new ArrayList<>());
    private Lidar lidar = new Lidar(0, new ArrayList<>());

    public CarClass(int positionx, int positionY) {
        this.current_postion = positionx;
        this.lane_pos = positionY;
    }

    // Assuming the car is moving 5 meters whenever the move function is called the car will move 5 meters. it stops  it reaches 100 meters.

    public boolean moveForward() {
        if (current_postion < 96 && current_postion >= 0) {

            current_postion += 5;
            return true;

        } else {

            return false;

        }
    }

    public boolean leftLaneDetect(int front, int rear, int left, int lidar_data,
                                  int front1, int rear1, int left1, int lidar_data1) {

        int count_changeLane = 0;
        int count_faulty = 0;
        querry(front, rear, left, lidar_data);
        querry(front1, rear1, left1, lidar_data1);

        for (int j = 0; j < data.size(); j++) {

            if (j<4 && data.get(j) == 2 && (data.get(j+4) == 2 || data.get(j+4) == -1 || data.get(j+4) == 1) ) {
                count_faulty++;

            }
            if (j <4 && data.get(j) == 1 &&  data.get(j+4)==1 ) {
                count_changeLane++;

            }


        }
        if (count_changeLane > 1 && count_faulty ==0 ) {
            isEmpty = true;
        } else if (count_faulty > 0){
           isEmpty = false;
        }

        System.out.println("enfjeje" + count_faulty + isEmpty + count_changeLane );
        return isEmpty;
    }

    public ArrayList<Integer> querry(int front, int rear, int left, int lidar_data) {

       // front_radar.checkReading(front);
        //rear_radar.checkReading(rear);
        //left_radar.checkReading(left);
       // lidar.checkReading(lidar_data);

        data.add(front_radar.checkReading(front));
        data.add(rear_radar.checkReading(rear));
        data.add(left_radar.checkReading(left));
        data.add(lidar.checkReading(lidar_data));

        System.out.println(data.toString());
        // i++;
        // for (int i=0 ; i<8 ; i++) {

        // if (data.get(i) !=0) {
        /// i++;
        // } else {

        //  }
        //  }

       // j++;
        return data;
    }

    public void changeLane() {

        if (isEmpty) {

            moveForward();
           // Coordinates.y = lane_pos ++;
            lane_pos ++;
            System.out.println("lalalalala" + lane_pos  );

        } else {

            moveForward();
        }

    }

    //checks in which lane the car is
    /**
    Point whereIs() {

        return Coordinates;
    }
     **/
    ArrayList <Integer>  whereIs (){
        ArrayList <Integer> coordinates =new ArrayList <>();
        coordinates.add(current_postion);
        coordinates.add(lane_pos);

        return coordinates;
    }
}
