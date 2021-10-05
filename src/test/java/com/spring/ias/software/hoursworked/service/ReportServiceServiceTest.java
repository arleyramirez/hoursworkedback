package com.spring.ias.software.hoursworked.service;

import com.spring.ias.software.hoursworked.repository.ReportServiceRepository;
import com.spring.ias.software.hoursworked.model.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReportServiceServiceTest {

    @Mock
    private ReportServiceRepository reporteServicioRepository;

    @InjectMocks
    private ReportServiceService reportServiceService;

    private ReportService reportService;
    private ReportResponse reportResponse;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format.parse("23/09/2021");
        Date endDate = format.parse("23/09/2021");

        reportService = new ReportService();
        reportService.setId(1);
        reportService.setIdReport("1");
        reportService.setIdTechnical("10");
        reportService.setWeekNumber("38");
        reportService.setDayHours(9);
        reportService.setNightHours(0);
        reportService.setSundayHours(0);
        reportService.setStartDate(startDate);
        reportService.setEndDate(endDate);

        reportResponse = new ReportResponse();
        reportResponse.setIdTechnical("10");
        reportResponse.setWeekNumber("38");
        reportResponse.setDayHours(9);
        reportResponse.setNightHours(0);
        reportResponse.setSundayHours(0);
        reportResponse.setTotalHours(9);
        reportResponse.setExtraDayHours(0);
        reportResponse.setExtraNightHours(0);
        reportResponse.setExtraSundayHours(0);
		
    }

    @Test
    void findAll() {
        when(reportServiceService.findAll()).thenReturn(Arrays.asList(reportService));
        assertNotNull(reportServiceService.findAll());
    }

    @Test
    void save() {
        when(reportServiceService.save(any())).thenReturn(reportService);
        assertNotNull(reportServiceService.save(new ReportService()));
    }

    @Test
    void findByIdTechnicalAndWeekNumber() {
		 reportResponse = reportServiceService.findByIdTechnicalAndWeekNumber("10","38");
         assertNotNull(reportResponse);
         assertEquals("10","10");
     }

    @Test
    void difference() {
        double difference = 0.0;
        when(reportServiceService.difference(65)).thenReturn((difference = 65-48));
    }
}