package com.bptn.weatherapp.automation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.bptn.weatherapp.automation.bean.Weather;
import com.bptn.weatherapp.automation.bean.User;
import com.bptn.weatherapp.automation.dao.mapper.WeatherMapper;

@Repository
public class WeatherDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Weather getLatestWeatherByUser(User user) {
		String sql = "SELECT * FROM \"Weather\" WHERE \"userId\" = ? ORDER BY \"weatherId\" DESC LIMIT 1";

		Weather weather = this.jdbcTemplate.queryForObject(sql, new WeatherMapper(), user.getUserId());

		return weather;
	}
	
	public List<Weather> findFirst10ByUserOrderByWeatherIdDesc(User user) {
		String sql = "SELECT * FROM \"Weather\" WHERE \"userId\" = ? ORDER BY \"weatherId\" DESC LIMIT 10";

		List<Weather> weathers = this.jdbcTemplate.query(sql, new WeatherMapper(), user.getUserId());

		return weathers;
	}
}
