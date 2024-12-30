package com.testrigor;

import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 *
	 * Check README
	 */
	public static void main(String[] args) {
		Map<String, String> criminals = new HashMap<>();
		criminals.put("Paul White Jr.", null);
		criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
		criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
		criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
		criminals.put("Redford Fort", "Red Strong, Red Fort");

		// Add as many as you want
		System.out.println(findCriminal(criminals, "Red "));
		System.out.println(findCriminal(criminals, "Roger"));
		System.out.println(findCriminal(criminals, "Red"));
		System.out.println(findCriminal(criminals, null));
		System.out.println(findCriminal(criminals, "Ford"));
	}

	/**
	 * TODO: Implement
	 * @param criminals
	 * @param possibleName
	 * @return
	 */
	public static String findCriminal(Map<String, String> criminals, String possibleName) {
		if (possibleName == null || possibleName.trim().isEmpty()) {
			return "No match";
		}

		String[] possibleNames = possibleName.split(" ");
		String criminal = null;
		int maxCount = 0;

		for (Map.Entry<String, String> entry : criminals.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			int count = 0;

			for (String name : possibleNames) {
				if (key.contains(name)) {
					count++;
				}

				if (value != null && value.contains(name)) {
					count++;
				}
			}

			if (count > maxCount) {
				maxCount = count;
				criminal = key;
			} else if (count == maxCount && criminal != null && criminal.compareTo(key) > 0) {
				criminal = key;
			}

		}

		return criminal != null ? criminal : "No match";
	}
}
