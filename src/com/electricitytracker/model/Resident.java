
package com.electricitytracker.model;

public class Resident {

	private int residentId;
	private String name;
	private String meterNumber;

	private double openingReading;
	private double month1Reading;
	private double month2Reading;
	private double month3Reading;

	public Resident(int residentId, String name, String meterNumber, double openingReading, double month1Reading,
			double month2Reading, double month3Reading) {

		this.residentId = residentId;
		this.name = name;
		this.meterNumber = meterNumber;
		this.openingReading = openingReading;
		this.month1Reading = month1Reading;
		this.month2Reading = month2Reading;
		this.month3Reading = month3Reading;
	}

	public int getResidentId() {
		return residentId;
	}

	public String getName() {
		return name;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public double getOpeningReading() {
		return openingReading;
	}

	public double getMonth1Reading() {
		return month1Reading;
	}

	public double getMonth2Reading() {
		return month2Reading;
	}

	public double getMonth3Reading() {
		return month3Reading;
	}

	// Calculate monthly units

	public double getMonth1Units() {
		return month1Reading - openingReading;
	}

	public double getMonth2Units() {
		return month2Reading - month1Reading;
	}

	public double getMonth3Units() {
		return month3Reading - month2Reading;
	}

	public double getTotalUnits() {
		return getMonth1Units() + getMonth2Units() + getMonth3Units();
	}

	// Display resident report

	public void displayReport() {

		System.out.println("\n========== RESIDENT REPORT ==========");
		System.out.println("Resident ID       : " + residentId);
		System.out.println("Resident Name     : " + name);
		System.out.println("Meter Number      : " + meterNumber);

		System.out.println("----------------------------------");

		System.out.println("Opening Reading   : " + openingReading);
		System.out.println("Month 1 Reading   : " + month1Reading);
		System.out.println("Month 2 Reading   : " + month2Reading);
		System.out.println("Month 3 Reading   : " + month3Reading);

		System.out.println("----------------------------------");

		System.out.println("Month 1 Units     : " + getMonth1Units());
		System.out.println("Month 2 Units     : " + getMonth2Units());
		System.out.println("Month 3 Units     : " + getMonth3Units());

		System.out.println("----------------------------------");

		System.out.println("Total Units       : " + getTotalUnits());

		System.out.println("==================================");
	}
}
