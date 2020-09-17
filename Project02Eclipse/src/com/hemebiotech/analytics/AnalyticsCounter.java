package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	/**
	 *  Create a map to use it to get
	 * the symptoms and count the occurrences.
	 * assign it to a new Treemap which will allow us to sort the symptoms alphabetically.
	 * */

	Map<String, Integer> countSymptoms = new TreeMap<>();


	/**
	 * a method to get the symptoms from
	 * list and count the  number of occurrences.
	 * @param symptoms input list
	 */



	public void symptomsFromReader(List<String> symptoms) {
		for (String symptom : symptoms)
			if (countSymptoms.containsKey(symptom))
				countSymptoms.put(symptom, countSymptoms.get(symptom) + 1);
			else
				countSymptoms.put(symptom, 1);




	}

	/**
	 * A method to write the map into a file.
	 *
	 * @param file file path
	 */
	public void write (String file){

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Integer> into : countSymptoms.entrySet()) {
				writer.write(into.getKey() + " = " + into.getValue());
				writer.newLine();

			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A method to use ReadSymptomFromFile class to read files.
	 *
	 * @param filepath the path of the file we want to read.
	 * @return return method Getsymptoms from the class ReadSymptomsFromfile.
	 */
	public List<String> readfile(String filepath) {
		return new ReadSymptomDataFromFile(filepath).GetSymptoms();
	}



}

