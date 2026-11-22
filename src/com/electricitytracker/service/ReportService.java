package com.electricitytracker.service;

import com.electricitytracker.model.Resident;
import java.util.ArrayList;

public class ReportService {

	// Display report for one resident
	public static void displayResidentReport(Resident resident) {

		if (resident == null) {
			System.out.println("Resident not found.");
			return;
		}

		resident.displayReport();
	}

	// Display reports for all residents
	public static void displayAllReports(ArrayList<Resident> residents) {

		if (residents.isEmpty()) {
			System.out.println("No resident records available.");
			return;
		}

		for (Resident resident : residents) {
			resident.displayReport();
		}
	}
}
