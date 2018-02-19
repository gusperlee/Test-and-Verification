
import java.util.ArrayList;

public class Actuator {
    int carPosition[] = new int[10];

    public boolean moveForward(CarClass car) {
        if (car.current_position < 96 && car.current_position >= 0) {

            car.current_position += 5;
            return true;

        } else {

            return false;

        }
    }

    public void changeLane(CarClass car) {

        if (car.isEmpty && car.current_position != 3) {

            car.moveForward();

            car.lane_pos++;

        } else {

            car.moveForward();
        }

    }

}
