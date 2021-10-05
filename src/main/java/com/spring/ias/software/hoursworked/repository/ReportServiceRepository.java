package com.spring.ias.software.hoursworked.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ias.software.hoursworked.model.*;

public interface ReportServiceRepository extends JpaRepository<ReportService, String>{
	
	List<ReportService> findByIdTechnicalAndWeekNumber(String idTechnical, String week);
	
}
