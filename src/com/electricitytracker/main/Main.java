
package com.electricitytracker.main;

import com.electricitytracker.model.Resident;
import com.electricitytracker.model.Operator;
import com.electricitytracker.service.UsageService;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UsageService usageService = new UsageService();
		Operator operator = new Operator();

		// Display operator profile
		System.out.println("===== ELECTRICITY TRACKER =====");
		operator.showProfile();

		int choice;

		do {

			System.out.println("\n===== ELECTRICITY USAGE TRACKER =====");
			System.out.println("1. Register Resident (3 Months Readings)");
			System.out.println("2. View Resident Report");
			System.out.println("3. View All Residents");
			System.out.println("4. View All Reports");
			System.out.println("5. Delete Resident");
			System.out.println("6. Exit");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			// Register resident
			case 1:

				System.out.print("Enter Resident ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Resident Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Meter Number: ");
				String meterNumber = sc.nextLine();

				System.out.print("Enter Opening Reading: ");
				double opening = sc.nextDouble();

				System.out.print("Enter Month 1 Reading: ");
				double month1 = sc.nextDouble();

				System.out.print("Enter Month 2 Reading: ");
				double month2 = sc.nextDouble();

				System.out.print("Enter Month 3 Reading: ");
				double month3 = sc.nextDouble();
				sc.nextLine();

				// Validate readings
				if (opening < 0 || month1 < opening || month2 < month1 || month3 < month2) {

					System.out.println("Invalid readings! Readings must increase month by month.");
					break;
				}

				Resident resident = new Resident(id, name, meterNumber, opening, month1, month2, month3);

				usageService.registerResident(resident);
				break;

			// View one report
			case 2:

				System.out.print("Enter Resident ID: ");
				int reportId = sc.nextInt();
				sc.nextLine();

				usageService.displayResidentReport(reportId);
				break;

			// View all residents
			case 3:

				usageService.displayAllResidents();
				break;

			// View all reports
			case 4:

				usageService.displayAllReports();
				break;

			// Delete resident
			case 5:

				usageService.displayAllResidents();

				System.out.print("\nEnter Resident ID to delete: ");
				int deleteId = sc.nextInt();
				sc.nextLine();

				System.out.print("Are you sure you want to delete this resident? (yes/no): ");

				String confirm = sc.nextLine();

				if (confirm.equalsIgnoreCase("yes")) {
					usageService.deleteResident(deleteId);
				} else {
					System.out.println("Deletion cancelled.");
				}
				break;

			// Exit
			case 6:

				System.out.println("Thank you for using Electricity Usage Tracker.");
				break;

			default:

				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 6);

		sc.close();
	}
}
