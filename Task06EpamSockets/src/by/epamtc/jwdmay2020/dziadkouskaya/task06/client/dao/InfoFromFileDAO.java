package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.exception.DaoException;

//take info from source - File
public class InfoFromFileDAO implements InfoFromSourceDAO {

	@Override
	public String takeInfoFromSource(String string) throws IOException {

		String sourcePath = string;

		BufferedReader reader = null;

		String textLine = "";

		StringBuilder stringBuilder = new StringBuilder();

		try {
			reader = new BufferedReader(new FileReader(sourcePath));

			while (reader.ready()) {

				textLine = reader.readLine();
				stringBuilder.append(textLine);
				stringBuilder.append("\n");

			}

		} finally

		{
			if (reader != null) {
				try {
					reader.close();

				} catch (Exception e) {
					System.err.println("Error!!!");
				}

			}
		}
		String result = stringBuilder.toString();

		return result;
	}

	
	
	
}
