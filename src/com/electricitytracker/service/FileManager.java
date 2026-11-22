
package com.electricitytracker.service;

import com.electricitytracker.model.Resident;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

	private static final String FILE_NAME = "residents.txt";

	// Save residents to file
	public static void saveResidents(ArrayList<Resident> residents) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

			for (Resident r : residents) {

				bw.write(r.getResidentId() + "," + r.getName() + "," + r.getMeterNumber() + "," + r.getOpeningReading()
						+ "," + r.getMonth1Reading() + "," + r.getMonth2Reading() + "," + r.getMonth3Reading());

				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error saving residents: " + e.getMessage());
		}
	}

	// Load residents from file
	public static ArrayList<Resident> loadResidents() {

		ArrayList<Resident> residents = new ArrayList<>();

		File file = new File(FILE_NAME);

		if (!file.exists()) {
			return residents;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",", -1);

				if (data.length != 7) {
					System.out.println("Skipping invalid record: " + line);
					continue;
				}

				Resident resident = new Resident(Integer.parseInt(data[0]), data[1], data[2],
						Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]),
						Double.parseDouble(data[6]));

				residents.add(resident);
			}

		} catch (IOException | NumberFormatException e) {
			System.out.println("Error loading residents: " + e.getMessage());
		}

		return residents;
	}
}
