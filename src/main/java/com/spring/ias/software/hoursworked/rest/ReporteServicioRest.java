package com.spring.ias.software.hoursworked.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ias.software.hoursworked.model.ReportService;
import com.spring.ias.software.hoursworked.service.ReportResponse;
import com.spring.ias.software.hoursworked.service.ReportServiceService;

@CrossOrigin
@RestController
@RequestMapping ("/service")
public class ReporteServicioRest {
	
	@Autowired
	private ReportServiceService reporteservicioService;
	
	@GetMapping
	private ResponseEntity<Object> getAllReporteServicio () {
		return ResponseEntity.ok(reporteservicioService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<ReportService> saveReport (@RequestBody ReportService reporte) {
		try {
			ReportService reportService  = reporteservicioService.save(reporte);
			return ResponseEntity.created(new URI("/service/"+reportService.getIdReport())).body(reportService);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}	
	
	@GetMapping("{idTechnical}/{weekNumber}")
	public @ResponseBody ReportResponse getReport(@PathVariable(name = "idTechnical") String idTechnical, @PathVariable(name = "weekNumber") String weekNumber) {
		return reporteservicioService.findByIdTechnicalAndWeekNumber(idTechnical, weekNumber);
	}
}
