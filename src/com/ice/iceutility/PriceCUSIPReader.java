package com.ice.iceutility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.ice.aabideen.common.VariableConstants;

/**
 * 
 * @author AABIDEEN
 * 
 */
public class PriceCUSIPReader {

	/**
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @description This method to read all the CUSIP and price from the file
	 *              return values for calculation in the proper format
	 */
	public static String dataPriceCUSIP() throws UnsupportedEncodingException,
			FileNotFoundException {
		final File file = new File(VariableConstants.SOURCE_FILE);
		Scanner scanner = null;
		scanner = new Scanner(file);
		final StringBuilder intProcess = new StringBuilder();

		while (scanner.hasNextLine()) {
			String priceCUSIPline = scanner.nextLine();
			final byte lineArray[] = priceCUSIPline.getBytes();
			priceCUSIPline = new String(lineArray, "UTF-8");

			if (!priceCUSIPline.matches(VariableConstants.ALPHABETS_MATCHER)) {
				intProcess.append(VariableConstants.COMMA + priceCUSIPline);
			} else {
				intProcess.append(VariableConstants.PIPE + priceCUSIPline);
			}
		}
		return intProcess.toString().substring(1);
	}
}
