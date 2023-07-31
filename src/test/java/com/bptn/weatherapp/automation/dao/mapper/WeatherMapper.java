package com.bptn.weatherapp.automation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bptn.weatherapp.automation.bean.Weather;


public class WeatherMapper implements RowMapper<Weather> {

	@Override
	public Weather mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Weather weather = new Weather();
		
	    weather.setWeatherId(rs.getInt("weatherId"));
	    weather.setCloudsAll(rs.getBigDecimal("cloudsAll"));
	    weather.setDescription(rs.getString("description"));
	    weather.setFeelsLike(rs.getBigDecimal("feelsLike"));
	    weather.setHumidity(rs.getBigDecimal("humidity"));
	    weather.setIcon(rs.getString("icon"));
	    weather.setPressure(rs.getBigDecimal("pressure"));
	    weather.setSunrise(rs.getTimestamp("sunrise"));
	    weather.setSunset(rs.getTimestamp("sunset"));
	    weather.setTemp(rs.getBigDecimal("temp"));
	    weather.setTempMax(rs.getBigDecimal("tempMax"));
	    weather.setTempMin(rs.getBigDecimal("tempMin"));
	    weather.setUpdatedOn(rs.getTimestamp("updatedOn"));
	    weather.setVisibility(rs.getBigDecimal("visibility"));
	    weather.setWeatherStatusId(rs.getInt("weatherStatusId"));
	    weather.setWindDirection(rs.getBigDecimal("windDirection"));
	    weather.setWindSpeed(rs.getBigDecimal("windSpeed"));
		
		return weather;
	}

}
