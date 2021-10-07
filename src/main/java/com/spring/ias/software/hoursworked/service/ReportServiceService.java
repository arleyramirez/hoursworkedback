package com.spring.ias.software.hoursworked.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ias.software.hoursworked.model.ReportService;
import com.spring.ias.software.hoursworked.repository.ReportServiceRepository;

@Service
public class ReportServiceService {
	
	@Autowired
	private ReportServiceRepository reporteServicioRepository;

	public List<ReportService> findAll() {
		return reporteServicioRepository.findAll();
	}

	public <S extends ReportService> S save(S entity) {
		return reporteServicioRepository.save(entity);
	}
	
	public ReportResponse findByIdTechnicalAndWeekNumber(String idTechnical, String week) {
		double totalHours = 0;
		double dayHours = 0;
		double nightHours = 0;
		double sundayHours = 0;
		double extraDayHours = 0;
		double extraNightHours = 0;
		double extraSundayHours = 0;

		ReportResponse reportResponse = new ReportResponse();
		List<ReportService> report = new ArrayList<ReportService>();
		report = (List<ReportService>) reporteServicioRepository.findByIdTechnicalAndWeekNumber(idTechnical, week);

		if (report.isEmpty()) {
			
			reportResponse.setTotalHours(totalHours);
			reportResponse.setDayHours(dayHours);
			reportResponse.setNightHours(nightHours);
			reportResponse.setSundayHours(sundayHours);
			reportResponse.setExtraDayHours(extraDayHours);
			reportResponse.setExtraNightHours(extraNightHours);
			reportResponse.setExtraSundayHours(extraSundayHours);
			reportResponse.setIdTechnical("0");
			reportResponse.setWeekNumber("0");

		} else {
			for (int i = 0; i < report.size(); i++) {
				if (totalHours < 48.0) {
					if (report.get(i).getDayHours() + totalHours >= 48) {
						extraDayHours = difference(totalHours + report.get(i).getDayHours());
						totalHours = 48;
					} else {
						totalHours = totalHours + report.get(i).getDayHours();
					}

					if (report.get(i).getNightHours() + totalHours >= 48) {
						extraNightHours = difference(totalHours + report.get(i).getNightHours());
						totalHours = 48;
					} else {
						totalHours = totalHours + report.get(i).getNightHours();
					}

					if (report.get(i).getSundayHours() + totalHours >= 48) {
						extraSundayHours = difference(totalHours + report.get(i).getSundayHours());
						totalHours = 48;
					} else {
						totalHours = totalHours + report.get(i).getSundayHours();
					}
					
					dayHours = dayHours + report.get(i).getDayHours();
					nightHours = nightHours + report.get(i).getNightHours();
					sundayHours = sundayHours + report.get(i).getSundayHours();
					
				} else {
					extraDayHours = extraDayHours + report.get(i).getDayHours();
					extraNightHours = extraNightHours + report.get(i).getNightHours();
					extraSundayHours = extraSundayHours + report.get(i).getSundayHours();
				}

			}
			totalHours = dayHours + nightHours + sundayHours + extraDayHours + extraNightHours + extraSundayHours;
			
			reportResponse.setTotalHours(Math.round(totalHours*100.0)/100.0);
			reportResponse.setDayHours(Math.round(dayHours*100.0)/100.0);
			reportResponse.setNightHours(Math.round(nightHours*100.0)/100.0);
			reportResponse.setSundayHours(Math.round(sundayHours*100.0)/100.0);
			reportResponse.setExtraDayHours(Math.round(extraDayHours*100.0)/100.0);
			reportResponse.setExtraNightHours(Math.round(extraNightHours*100.0)/100.0);
			reportResponse.setExtraSundayHours(Math.round(extraSundayHours*100.0)/100.0);
			reportResponse.setIdTechnical(report.get(0).getIdTechnical());
			reportResponse.setWeekNumber(report.get(0).getWeekNumber());
		}

		return reportResponse;
	}
	
	public double difference(double totalHours) {
		double difference = 0;
		difference = totalHours - 48;
		return difference;
	};
	
}
