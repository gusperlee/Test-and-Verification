import java.awt.*;
import java.util.ArrayList;

public class CarClass implements CarInterface {

    public ArrayList<Integer> data = new ArrayList<>();
    public  boolean isEmpty=true;
   // public Point Coordinates = new Point (Current_postion,lane_pos );
    String error_message="";

    private Radar front_radar = new Radar(0, new ArrayList<>());
    private Radar rear_radar = new Radar(0, new ArrayList<>());
    private Radar left_radar = new Radar(0, new ArrayList<>());
    private Lidar lidar = new Lidar(0, new ArrayList<>());
    Actuator actuator = new Actuator();

    public CarClass(int positionX, int positionY) {
        this.actuator.current_position = positionX;
        this.actuator.lane_pos = positionY;
    }

    // Assuming the car is moving 5 meters whenever the move function is called the car will move 5 meters. it stops  it reaches 100 meters.
    public boolean moveForward() {
        boolean state = actuator.moveForward();
        return state;
    }


	public boolean leftLaneDetect(int front, int rear, int left, int lidar_data,
								  int front1, int rear1, int left1, int lidar_data1) {


		int count_changeLane = 0;
		int count_occupied = 0;
		int count_corrupted=0;
		querry(front, rear, left, lidar_data);
		querry(front1, rear1, left1, lidar_data1);

		for (int j = 0; j < data.size(); j++) {

			if (j<4 && data.get(j) == 2 && (data.get(j+4) == 2 || data.get(j+4) == -1 || data.get(j+4) == 1) ) {
				count_occupied++;

			}
			if (j <4 && data.get(j) == 1 &&  data.get(j+4)==1 ) {
				count_changeLane++;

			} if (j < 4 && data.get(j) == -1 && data.get(j+4) == -1){
				count_corrupted++;
			}


		}
		if (count_changeLane > 1 && count_occupied ==0  ) {
			isEmpty = true;

		}   else if (count_corrupted >1 && count_changeLane <2 ) {

			isEmpty = false;
			System.out.println("you have more than 1 corrupted sensor") ;
			error_message="you have more than 1 corrupted sensor";

		} else if (count_occupied > 0 ){
			isEmpty = false;
			error_message="there is an obstacle on the left";

		} else if ((count_changeLane==0 ||count_changeLane==1)   && (count_occupied==0 ) && (count_corrupted==0 ||count_corrupted==1)  ) {
			isEmpty = false;
		}
		data =  new ArrayList<>();

		return isEmpty;
	}

	public ArrayList<Integer> querry(int front, int rear, int left, int lidar_data) {

		data.add(front_radar.checkReading(front));
		data.add(rear_radar.checkReading(rear));
		data.add(left_radar.checkReading(left));
		data.add(lidar.checkReading(lidar_data));

		System.out.println(data.toString());

		return data;
	}



    public void changeLane() {

    	actuator.changeLane(this);

    }

    public Point whereIs (){
        Point coordinates = new Point();
        coordinates.x = actuator.current_position;
        coordinates.y = actuator.lane_pos;

        return coordinates;
    }
}
