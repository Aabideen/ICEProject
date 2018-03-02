package com.ice.iceutility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.ice.aabideen.common.VariableConstants;

/**
 * 
 * @author Aabideen
 * 
 */
public class PriceCUSIPWriter {

	/**
	 * 
	 * @param intSplit
	 * @return
	 * @throws IOException
	 * @description This method is to refine the price for each CUSIP and write
	 *              to the new file
	 */
	public static boolean latestPriceCUSIP(final String[] intSplit)
			throws IOException {

		final StringBuilder latestPriceCUSIP = new StringBuilder();
		final List<String> priceCUSIPList = new ArrayList<String>();
		for (int splitCount = 0; splitCount < intSplit.length; splitCount++) {
			priceCUSIPList.add(intSplit[splitCount]);
		}
		for (int pLCount = 0; pLCount < priceCUSIPList.size(); pLCount++) {
			final String calStr = (String) priceCUSIPList.get(pLCount);
			final String[] latestCUSIPPricStr = calStr
					.split(VariableConstants.COMMA);
			latestPriceCUSIP.append(latestCUSIPPricStr[0]
					+ System.getProperty("line.separator")
					+ latestCUSIPPricStr[latestCUSIPPricStr.length - 1]
					+ System.getProperty("line.separator"));
		}
		FileUtils.writeStringToFile(
				new File(VariableConstants.DESTINATION_FILE),
				latestPriceCUSIP.toString());
		return true;
	}
}
