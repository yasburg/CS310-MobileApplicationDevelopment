package example1;
import java.util.Date;

public class MainClass {

	
	public static void main(String[] args) {
		
		TrafficLight light = new TrafficLight();
		
		Car car1 = new Car();
		Car car2 = new Car();
		
		
		light.addListener(car1);
		light.addListener(car2);
		
		
		
		//Anonymous inner class
		light.addListener(new TrafficLightListener() {

			@Override
			public void colorChanged(String color, Date date) {
				System.out.println("Truck:" + color + ", date: " + date);
			}
		});
		
		
		light.addListener(new TrafficLightListener() {
			
			@Override
			public void colorChanged(String color, Date date) {
				System.out.println("Motorcycle: color:" + color + ", date:" + date);
				
			}
		});
		
		light.lightChanged("yellow");
		
	}
	
	
}
