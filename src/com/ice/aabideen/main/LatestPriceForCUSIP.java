package com.ice.aabideen.main;

/**
 */
import java.io.IOException;

import com.ice.aabideen.common.VariableConstants;
import com.ice.iceutility.PriceCUSIPReader;
import com.ice.iceutility.PriceCUSIPWriter;

/**
 * 
 * @author AABIDEEN
 * 
 */
public class LatestPriceForCUSIP {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @description This method used to call the methods for the get
	 *              content(CUSIP and Price) from the file and write the latest
	 *              Price for CUSIP into another file
	 */
	public static void main(final String[] args) throws IOException {
		final String[] intSplit = PriceCUSIPReader.dataPriceCUSIP()
				.split("\\|");
		final boolean status = PriceCUSIPWriter.latestPriceCUSIP(intSplit);
		if (status)
			System.out.println(VariableConstants.SUCCESS_MSG);
	}
}