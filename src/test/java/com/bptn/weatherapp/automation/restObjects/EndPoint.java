package com.bptn.weatherapp.automation.restObjects;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.provider.ResourceProvider;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTable.TableConverter;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jakarta.annotation.PostConstruct;

public class EndPoint {

	protected static final String AUTHORIZATION = "Authorization";

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    ObjectMapper objectMapper;
    
	@Autowired
	ResourceProvider provider;
	
	RequestSpecification reqSpec;

	TableConverter tableConverter;
	
	public void createRequestWithToken(String jwtToken) {
	    
		this.reqSpec = RestAssured.given()
                .baseUri(this.provider.getBackEndUrl())
                .header(AUTHORIZATION, "Bearer " + jwtToken);
	}
	
	public void createRequestWithData(DataTable data) throws JsonProcessingException {
		
		this.reqSpec = RestAssured.with()
				.baseUri(this.provider.getBackEndUrl())
				.contentType(ContentType.JSON)
				.body(this.objectMapper.writeValueAsString(data.asMap()));
	}
	
	
	public void createRequestWithTokenAndData(String jwtToken, DataTable data) throws JsonProcessingException {

		this.reqSpec = RestAssured.with()
				.baseUri(this.provider.getBackEndUrl())
				.header(AUTHORIZATION, "Bearer " + jwtToken)
				.contentType(ContentType.JSON)
				.body(this.objectMapper.writeValueAsString(data.asMap()));
	}
	
	public Response sendGetRequest(String path) {
		
		return RestAssured.given(this.reqSpec)
				        .get(path);
	}

	public Response sendPostRequest(String path) {
		
		return RestAssured.given(this.reqSpec)
				        .post(path);
	}
	   
    @PostConstruct
    private void postConstruct() {
    	this.tableConverter = new DataTableTypeRegistryTableConverter(new DataTableTypeRegistry(Locale.ENGLISH));
    }
     
}
