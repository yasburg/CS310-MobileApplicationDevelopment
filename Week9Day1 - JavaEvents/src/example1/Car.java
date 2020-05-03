package example1;
import java.util.Date;

//Concrete class
public class Car implements TrafficLightListener{

	@Override
	public void colorChanged(String color, Date date) {
		
		System.out.println("Light changed:" + color + ", Date:" + date);
		
		
	}

	
	
	
	
}
