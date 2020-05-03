package example2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Subject
public class Button {
	
	List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	
	
	public void addListener(ButtonClickListener listener) {
		listeners.add(listener);
	}
	
	
	public void doButtonClick() {
		Date now = new Date();
		for (ButtonClickListener buttonClickListener : listeners) {
			buttonClickListener.buttonClicked(now);
		}
		
	}
	
	
}

interface ButtonClickListener{
	public void buttonClicked(Date date);
}

