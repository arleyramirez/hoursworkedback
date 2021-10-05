package com.spring.ias.software.hoursworked.service;

public class ReportResponse {
	
	private double totalHours;
	private double dayHours;
	private double nightHours;
	private double sundayHours;
	private double extraDayHours;
	private double extraNightHours;
	private double extraSundayHours;
	private String idTechnical;
	private String weekNumber;
	
	public ReportResponse() {}
	
	public ReportResponse(double totalHours, double dayHours, double nightHours, double sundayHours,
			double extraDayHours, double extraNightHours, double extraSundayHours, String idTechnical,
			String weekNumber) {
		super();
		this.totalHours = totalHours;
		this.dayHours = dayHours;
		this.nightHours = nightHours;
		this.sundayHours = sundayHours;
		this.extraDayHours = extraDayHours;
		this.extraNightHours = extraNightHours;
		this.extraSundayHours = extraSundayHours;
		this.idTechnical = idTechnical;
		this.weekNumber = weekNumber;
	}
	
	public double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	public double getDayHours() {
		return dayHours;
	}
	public void setDayHours(double dayHours) {
		this.dayHours = dayHours;
	}
	public double getNightHours() {
		return nightHours;
	}
	public void setNightHours(double nightHours) {
		this.nightHours = nightHours;
	}
	public double getSundayHours() {
		return sundayHours;
	}
	public void setSundayHours(double sundayHours) {
		this.sundayHours = sundayHours;
	}
	public double getExtraDayHours() {
		return extraDayHours;
	}
	public void setExtraDayHours(double extraDayHours) {
		this.extraDayHours = extraDayHours;
	}
	public double getExtraNightHours() {
		return extraNightHours;
	}
	public void setExtraNightHours(double extraNightHours) {
		this.extraNightHours = extraNightHours;
	}
	public double getExtraSundayHours() {
		return extraSundayHours;
	}
	public void setExtraSundayHours(double extraSundayHours) {
		this.extraSundayHours = extraSundayHours;
	}
	public String getIdTechnical() {
		return idTechnical;
	}
	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}	

}
