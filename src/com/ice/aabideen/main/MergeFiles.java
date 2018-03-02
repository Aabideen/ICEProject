package com.ice.aabideen.main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.ice.aabideen.common.VariableConstants;

public class MergeFiles {

	public static void main(String[] args) throws IOException {
		List<String> firstFile = FileUtils.readLines(new File(
				VariableConstants.INPUT_FILE1), "utf-8");
		List<String> secondFile = FileUtils.readLines(new File(
				VariableConstants.INPUT_FILE2), "utf-8");
		List<String> combinedData= new ArrayList<String>();
		combinedData.addAll(firstFile);
		combinedData.addAll(secondFile);

		List<String> finalData = new ArrayList<String>(new HashSet<String>(
				combinedData));
		
		Path out = Paths.get(VariableConstants.SORTED_MERGED_FILE);
		Files.write(out,finalData,Charset.defaultCharset());
		System.out.println(VariableConstants.FINAL_MSG);
	}
}
