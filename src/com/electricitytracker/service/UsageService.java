package com.electricitytracker.service;

import com.electricitytracker.model.Resident;
import java.util.ArrayList;

public class UsageService {

	private ArrayList<Resident> residents;

	public UsageService() {
		residents = FileManager.loadResidents();
	}

	// Register resident
	public void registerResident(Resident resident) {

		if (findResidentById(resident.getResidentId()) != null) {
			System.out.println("Resident ID already exists.");
			return;
		}

		for (Resident r : residents) {
			if (r.getMeterNumber().equalsIgnoreCase(resident.getMeterNumber())) {

				System.out.println("Meter number already exists.");
				return;
			}
		}

		residents.add(resident);

		FileManager.saveResidents(residents);

		System.out.println("Resident registered successfully.");
	}

	// Find resident by ID
	public Resident findResidentById(int residentId) {

		for (Resident resident : residents) {

			if (resident.getResidentId() == residentId) {
				return resident;
			}
		}

		return null;
	}

	// Display one resident report
	public void displayResidentReport(int residentId) {

		Resident resident = findResidentById(residentId);

		ReportService.displayResidentReport(resident);
	}

	// Display all residents
	public void displayAllResidents() {

		if (residents.isEmpty()) {
			System.out.println("No residents registered.");
			return;
		}

		System.out.println("\n========== RESIDENT LIST ==========");

		for (Resident resident : residents) {

			System.out
					.println(resident.getResidentId() + " | " + resident.getName() + " | " + resident.getMeterNumber());
		}

		System.out.println("================================");
	}

	// Display all reports
	public void displayAllReports() {

		ReportService.displayAllReports(residents);
	}

	// Delete resident
	public boolean deleteResident(int residentId) {

		Resident resident = findResidentById(residentId);

		if (resident == null) {
			System.out.println("Resident not found.");
			return false;
		}

		residents.remove(resident);

		FileManager.saveResidents(residents);

		System.out.println("Resident deleted successfully.");

		return true;
	}
}
