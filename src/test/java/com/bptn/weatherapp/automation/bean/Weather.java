package com.bptn.weatherapp.automation.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Weather {

	private Integer weatherId;

	private BigDecimal cloudsAll;

	private String description;

	private BigDecimal feelsLike;

	private BigDecimal humidity;

	private String icon;

	private BigDecimal pressure;

	private Timestamp sunrise;

	private Timestamp sunset;

	private BigDecimal temp;

	private BigDecimal tempMax;

	private BigDecimal tempMin;

	private Timestamp updatedOn;

	private BigDecimal visibility;

	private Integer weatherStatusId;

	private BigDecimal windDirection;

	private BigDecimal windSpeed;

	public Integer getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public BigDecimal getCloudsAll() {
		return cloudsAll;
	}

	public void setCloudsAll(BigDecimal cloudsAll) {
		this.cloudsAll = cloudsAll;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(BigDecimal feelsLike) {
		this.feelsLike = feelsLike;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public Timestamp getSunrise() {
		return sunrise;
	}

	public void setSunrise(Timestamp sunrise) {
		this.sunrise = sunrise;
	}

	public Timestamp getSunset() {
		return sunset;
	}

	public void setSunset(Timestamp sunset) {
		this.sunset = sunset;
	}

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getTempMax() {
		return tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public BigDecimal getTempMin() {
		return tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public BigDecimal getVisibility() {
		return visibility;
	}

	public void setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
	}

	public Integer getWeatherStatusId() {
		return weatherStatusId;
	}

	public void setWeatherStatusId(Integer weatherStatusId) {
		this.weatherStatusId = weatherStatusId;
	}

	public BigDecimal getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(BigDecimal windDirection) {
		this.windDirection = windDirection;
	}

	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public String toString() {
		return "Weather [weatherId=" + weatherId + ", cloudsAll=" + cloudsAll + ", description=" + description
				+ ", feelsLike=" + feelsLike + ", humidity=" + humidity + ", icon=" + icon + ", pressure=" + pressure
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + ", temp=" + temp + ", tempMax=" + tempMax
				+ ", tempMin=" + tempMin + ", updatedOn=" + updatedOn + ", visibility=" + visibility
				+ ", weatherStatusId=" + weatherStatusId + ", windDirection=" + windDirection + ", windSpeed="
				+ windSpeed + "]";
	}
	
	

}
