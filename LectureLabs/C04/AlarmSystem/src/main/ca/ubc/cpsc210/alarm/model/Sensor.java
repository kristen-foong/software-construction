package ca.ubc.cpsc210.alarm.model;

import ca.ubc.cpsc210.alarm.model.exception.DuplicateSensorException;

/**
 * Represents a sensor in the alarm system.
 */
public class Sensor {
	private static final int HASH_CONSTANT = 13;
	private AlarmController ac;
	private String location;
	private boolean isOpen;
	
	/**
	 * Constructor creates sensor at given location and sensor is closed.
	 * @param location  the location of the sensor
	 * @param ac  the alarm controller
	 * @throws DuplicateSensorException 
	 */
	public Sensor(String location, AlarmController ac) throws DuplicateSensorException {
		this.location = location;
		this.ac = ac;
		ac.addSensor(this);
		isOpen = false;
	}
	
	/**
	 * Opens the sensor (e.g. when door or window is open)
	 */
	public void open() {
		isOpen = true;
		EventLog.getInstance().logEvent(new Event("Opened sensor at: " + location));
		ac.update();
	}
	
	/**
	 * Closes the sensor (e.g. when door or window is closed)
	 */
	public void close() {
		isOpen = false;
		EventLog.getInstance().logEvent(new Event("Closed sensor at: " + location));
		ac.update();
	}
	
	/**
	 * Determines if sensor is open.
	 * @return  true if sensor open, false otherwise
	 */
	public boolean isOpen() {
		return isOpen;
	}
	
	/**
	 * Gets location of sensor.
	 * @return location of the sensor
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the alarm controller to which this sensor is attached.
	 * @param ac  the alarm controller
	 * @throws DuplicateSensorException 
	 */
	public void setAlarmController(AlarmController ac) throws DuplicateSensorException {
		if (this.ac != ac) {
			this.ac = ac;
			ac.addSensor(this);
		}
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        return !(location != null ? !location.equals(sensor.location) : sensor.location != null);

    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }
}
