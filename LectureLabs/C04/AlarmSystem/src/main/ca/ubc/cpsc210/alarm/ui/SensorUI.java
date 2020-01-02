package ca.ubc.cpsc210.alarm.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import ca.ubc.cpsc210.alarm.model.Sensor;

/**
 * Represents user interface for sensors.
 */
class SensorUI extends JInternalFrame {
	private static final int WIDTH = 200;
	private static final int HEIGHT = 100;
	private static final int LOC = 100;
	private static int sensorCount = 0;
	private Sensor theSensor;
	private JTextField openCloseStatus;
	private String location;
	
	/**
	 * Constructor sets up user interface for a given sensor
	 * @param s   the sensor
	 * @param parent  the parent component
	 */
	public SensorUI(Sensor s, Component parent) {
		super(s.getLocation(), false, false, false, false);
		theSensor = s;
		location = s.getLocation();
		openCloseStatus = new JTextField(location + " is closed");
		openCloseStatus.setEditable(false);
		openCloseStatus.setAlignmentX(CENTER_ALIGNMENT);

        JButton openClose = new JButton(new OpenCloseAction());
		openClose.setAlignmentX(CENTER_ALIGNMENT);
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.add(openCloseStatus);
		cp.add(openClose);
		setSize(WIDTH, HEIGHT);
		setPosition(parent);
		sensorCount++;
		setVisible(true);
	}
	
	/**
	 * Sets the position of this sensor UI relative to parent component
	 * @param parent  the parent component
	 */
	private void setPosition(Component parent) {
		setLocation(LOC * sensorCount, parent.getHeight() / 2 + LOC * sensorCount / 5);
	}
	
	/**
	 * Represents the action to be taken when sensor is opened or closed
	 */
	private class OpenCloseAction extends AbstractAction {
		OpenCloseAction() {
			super("Toggle");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (theSensor.isOpen()) {
				theSensor.close();
				openCloseStatus.setText(location + " is closed");
			}
			else {
				theSensor.open();
				openCloseStatus.setText(location + " is open");
			}
		}
	}
}
