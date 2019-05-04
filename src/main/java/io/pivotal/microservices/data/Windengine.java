package io.pivotal.microservices.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Windengine {

	private String windengineID;
	private Date timestamp;
	private String parkrechnerID;
	
	private double windspeed;
	private String unitWindspeed;

	private double temperature;
	private String unitTemperature;

	private double power;
	private String unitPower;

	private double blindpower;
	private String unitBlindpower;

	private double rotationspeed;
	private String unitRotationspeed;

	private double bladeposition;
	private String unitBladeposition;



	/**
	 * Constructor
	 */
	public Windengine() {
		
		this.timestamp = new Date();
		this.unitWindspeed = "kmH";
		this.unitTemperature = "C";
		this.unitPower = "kwH";
		this.unitBlindpower = "kwH";
		this.unitRotationspeed = "uM";
		this.unitBladeposition = "grad";
		
	}

	/**
	 * Setter and Getter Methods
	 */
	public String getWindengineID() {
		return windengineID;
	}

	public void setWindengineID(String windengineID) {
		this.windengineID = windengineID;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		try {
			this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}

	public double getWindspeed() {
		return windspeed;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getBlindpower() {
		return blindpower;
	}

	public void setBlindpower(double blindpower) {
		this.blindpower = blindpower;
	}

	public double getRotationspeed() {
		return rotationspeed;
	}

	public void setRotationspeed(double rotationspeed) {
		this.rotationspeed = rotationspeed;
	}

	public double getBladeposition() {
		return bladeposition;
	}

	public void setBladeposition(double bladeposition) {
		this.bladeposition = bladeposition;
	}

	public String getUnitWindspeed() {
		return unitWindspeed;
	}

	public String getUnitTemperature() {
		return unitTemperature;
	}

	public String getUnitPower() {
		return unitPower;
	}

	public String getUnitBlindpower() {
		return unitBlindpower;
	}

	public String getUnitRotationspeed() {
		return unitRotationspeed;
	}

	public String getUnitBladeposition() {
		return unitBladeposition;
	}
	public String getParkrechnerID() {
		return parkrechnerID;
	}

	public void setParkrechnerID(String parkrechnerID) {
		this.parkrechnerID = parkrechnerID;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Windengine Info: ID = %s, timestamp = %s, windspeed = %f ,temperature=%f,power=%f,blindpower=%f,rotationspeed=%f,bladeposition=%f",
			windengineID, timestamp, windspeed,temperature,power,blindpower,rotationspeed,bladeposition);
		return info;
	}


}
