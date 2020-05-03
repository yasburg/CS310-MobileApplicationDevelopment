package example2;

import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		
		
		Button btn = new Button();
		
		btn.addListener(new ButtonClickListener() {
			
			@Override
			public void buttonClicked(Date date) {
				System.out.println("Listener 1 button cklicked at " + date);
				
			}
		});
		
		btn.addListener(new ButtonClickListener() {
			
			@Override
			public void buttonClicked(Date date) {
				System.out.println("Listener 2 button cklicked at " + date);
				
			}
		});
		
		
		btn.doButtonClick();
		
		
		
	}
	
	
	
}
