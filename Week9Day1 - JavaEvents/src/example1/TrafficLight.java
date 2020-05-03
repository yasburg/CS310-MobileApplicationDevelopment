package example1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrafficLight {

	List<TrafficLightListener> listeners;
	
	
	public void addListener(TrafficLightListener listener) {
		
		if(listeners==null) {
			listeners = new ArrayList<TrafficLightListener>();
		}
		
		listeners.add(listener);
		
		
	}
	
	public void lightChanged(String color) {
		Date now = new Date();
		
		for (TrafficLightListener listener : listeners) {
			
			listener.colorChanged(color, now);
			
			
		}
		
		
	}
	
	
	//Member inner class
	class InnerTest{
		
		
		void test() {
			
			
			
		}
		
	}
	
}

interface TrafficLightListener{
	
	public void colorChanged(String color,Date date);
	
	
}
