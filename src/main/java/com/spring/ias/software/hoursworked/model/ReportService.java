package com.spring.ias.software.hoursworked.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "report_services")
public class ReportService {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String idReport;
	private String idTechnical;
	private float dayHours;
	private float nightHours;
	private float sundayHours;
	private String weekNumber;
	private Date startDate;
	private Date endDate;
	
	public ReportService() {
	}

	public ReportService(int id, String idReport, String idTechnical, float dayHours, float nightHours,
						 float sundayHours, String weekNumber, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.idReport = idReport;
		this.idTechnical = idTechnical;
		this.dayHours = dayHours;
		this.nightHours = nightHours;
		this.sundayHours = sundayHours;
		this.weekNumber = weekNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public String getIdTechnical() {
		return idTechnical;
	}

	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}

	public float getDayHours() {
		return dayHours;
	}

	public void setDayHours(float dayHours) {
		this.dayHours = dayHours;
	}

	public float getNightHours() {
		return nightHours;
	}

	public void setNightHours(float nightHours) {
		this.nightHours = nightHours;
	}

	public float getSundayHours() {
		return sundayHours;
	}

	public void setSundayHours(float sundayHours) {
		this.sundayHours = sundayHours;
	}

	public String getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
