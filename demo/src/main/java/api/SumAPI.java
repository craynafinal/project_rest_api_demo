package api;
import java.io.*;

public class SumAPI {
	private static final String fileName = "sum.txt";
	private int sum = 0;

	public SumAPI() {
		readFromFile();
	}

	public void addValue(int value) {
		sum += value;
		writeToFile(sum);
	}

	public int getSum() {
		return sum;
	}

	public void removeAll() {
		sum = 0;
	}

	private void writeToFile(int data) {
		try {
			Writer wr = new FileWriter(fileName);
			wr.write(new Integer(sum).toString());
			wr.close();
		} catch (Exception e) {
			System.err.println("Error: failed to store sum value.");
		}
	}

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
