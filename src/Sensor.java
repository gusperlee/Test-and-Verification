public class Sensor implements SensorInterface {

    public int checkReading(int to_obstacle ) {
        if (to_obstacle < 50  && to_obstacle > 0 && to_obstacle <= 8){
            return 2;
        }else if (to_obstacle < 50  && to_obstacle > 0 &&  to_obstacle > 8){
            return 1;
        }else {
            return -1;
        }
    }
}
