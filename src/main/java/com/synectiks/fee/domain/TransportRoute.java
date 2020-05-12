package com.synectiks.fee.domain;


import java.io.Serializable;


public class TransportRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String routeName;
    private String routeDetails;
    private String routeMapUrl;
    private Integer noOfStops;
    private String routeFrequency;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getRouteDetails() {
		return routeDetails;
	}
	public void setRouteDetails(String routeDetails) {
		this.routeDetails = routeDetails;
	}
	public String getRouteMapUrl() {
		return routeMapUrl;
	}
	public void setRouteMapUrl(String routeMapUrl) {
		this.routeMapUrl = routeMapUrl;
	}
	public Integer getNoOfStops() {
		return noOfStops;
	}
	public void setNoOfStops(Integer noOfStops) {
		this.noOfStops = noOfStops;
	}
	public String getRouteFrequency() {
		return routeFrequency;
	}
	public void setRouteFrequency(String routeFrequency) {
		this.routeFrequency = routeFrequency;
	}

}
