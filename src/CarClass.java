import java.awt.*;
import java.util.ArrayList;

public class CarClass implements CarInterface {

    public  int current_postion;
    public  int lane_pos=1 ;
    public ArrayList<Integer> data = new ArrayList<>();
    public  boolean isEmpty=true;
    String error_message="";

    private Radar front_radar = new Radar(0, new ArrayList<>());
    private Radar rear_radar = new Radar(0, new ArrayList<>());
    private Radar left_radar = new Radar(0, new ArrayList<>());
    private Lidar lidar = new Lidar(0, new ArrayList<>());

    public CarClass(int positionX, int positionY) {
        this.current_postion = positionX;
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
        int count_corrupted=0;
        query(front, rear, left, lidar_data);
        query(front1, rear1, left1, lidar_data1);

        for (int j = 0; j < data.size(); j++) {

            if (j<4 && data.get(j) == 2 && (data.get(j+4) == 2 || data.get(j+4) == -1 || data.get(j+4) == 1) ) {
                count_faulty++;

            }
            if (j <4 && data.get(j) == 1 &&  data.get(j+4)==1 ) {
                count_changeLane++;

            } if (j < 4 && data.get(j) == -1 && data.get(j+4) == -1){
                count_corrupted++;
            }


        }
        if (count_changeLane > 1 && count_faulty ==0  ) {
            isEmpty = true;

        } else if (count_faulty > 0 &&  isEmpty){
           isEmpty = false;
        } else if (count_corrupted >1 && count_changeLane <2) {
            isEmpty = false;
            System.out.println("you have more than 1 corrupted sensor") ;
            error_message="you have more than 1 corrupted sensor";
        }
        return isEmpty;
    }

    public ArrayList<Integer> query(int front, int rear, int left, int lidar_data) {

        data.add(front_radar.checkReading(front));
        data.add(rear_radar.checkReading(rear));
        data.add(left_radar.checkReading(left));
        data.add(lidar.checkReading(lidar_data));

        System.out.println(data.toString());
        return data;
    }

    public void changeLane() {

        if (isEmpty && lane_pos!=3) {
            moveForward();
            lane_pos ++;
        } else {

            moveForward();
        }

    }

    public Point whereIs(){
        Point coordinates = new Point();
        coordinates.x = current_postion;
        coordinates.y = lane_pos;
        return coordinates;
    }
}
