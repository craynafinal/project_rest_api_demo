package api;
import java.io.*;

/**
 * SumAPI class offers the following features:
 * - Return the sum value that is sum of all inputs so far
 * - Adding a new value
 * - Reset the sum to 0
 * - Persistentcy by saving the sum value to a file
 *
 * @author Jong Seong Lee
 *
 */
public class SumAPI {
	// Temp file name for saving sum value
	private static final String fileName = "sum.txt";

	private int sum = 0;

	// In the beginning, try to read sum from the file
	public SumAPI() {
		readFromFile();
	}

	// Add another value to sum
	public void addValue(int value) {
		sum += value;
		// Saving the last sum value will happen every time
		// because the server might crash
		writeToFile(sum);
	}

	// Return the sum value
	public int getSum() {
		return sum;
	}

	// Reset the sum back to 0
	public void resetValue() {
		sum = 0;
		writeToFile(sum);
	}

	// Save value to a file 
	private void writeToFile(int data) {
		try {
			Writer wr = new FileWriter(fileName);
			wr.write(new Integer(sum).toString());
			wr.close();
		} catch (Exception e) {
			System.err.println("Error: failed to store sum value.");
		}
	}

	// Read the last sum value from previous server run
	// If there is no file or an issue found, sum is 0
	private void readFromFile() {
		BufferedReader reader = null;

		try {
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			sum = Integer.parseInt(reader.readLine());

		} catch (Exception e) {
			// if error occured, just set sum to 0
			sum = 0;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				System.err.println("Error: failed to close while reading file.");
			}
		}
	}
}
