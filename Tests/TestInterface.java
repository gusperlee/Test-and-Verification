import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public interface TestInterface{
    Sensor Lidar,Radar;
    Actuator actuator;
	  Car testcar;
   

    @Before
    public void create(){
    
    }
    
    @Test
    public void test() {
    
    }

}
