package GiuaKy;

import javax.swing.*;
public class StatusBar extends JPanel{
	JLabel status;
	public StatusBar() {
		status = new JLabel("ready...");
		add(status);
	}
	
	public void setMessage(String text) {
		this.status.setText(text);
	}
	
}