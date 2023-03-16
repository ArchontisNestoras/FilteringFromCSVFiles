package file.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import filtering.FilteringEngine;
import metadata.NaiveFileMetadataManager;

public class StructuredFileManager implements StructuredFileManagerInterface {
	private String pAlias;
	private String pPath;
	private String pSeparator;
	@Override
	public File registerFile(String pAlias, String pPath, String pSeparator) throws IOException, NullPointerException {
		// TODO Auto-generated method stub
		File pFile=new File(pPath);
		this.pAlias=pAlias;
		this.pSeparator=pSeparator;
		this.pPath=pPath;
		return pFile;
	}

	@Override
	public String[] getFileColumnNames(String pAlias) throws FileNotFoundException, NullPointerException, IOException {
		// TODO Auto-generated method stub
		if(pAlias.equals(this.pAlias)) {
			NaiveFileMetadataManager metadataManager=new NaiveFileMetadataManager(pAlias,this.registerFile(this.pAlias, this.pPath,this.pSeparator),this.pSeparator);
			
			return metadataManager.getColumnNames();
		}else  {
			String[] y = {};
			return y;
		}
	}

	@Override
	public List<String[]> filterStructuredFile(String pAlias, Map<String, List<String>> pAtomicFilters) throws FileNotFoundException, NullPointerException, IOException {
		// TODO Auto-generated method stub
		NaiveFileMetadataManager manager=new NaiveFileMetadataManager(pAlias,this.registerFile(this.pAlias, this.pPath,this.pSeparator),this.pSeparator);
		FilteringEngine myEngine = new FilteringEngine(pAtomicFilters,manager);
		
		return myEngine.workWithFile();
	}

	@Override
	public int printResultsToPrintStream(List<String[]> recordList, PrintStream pOut) {
		// TODO Auto-generated method stub
		
		
		for(String[] i:recordList) {
			for(int j=0;j<i.length;j++) {
				pOut.println(i[j]);
			}	
		}
		
		
		if(recordList==null) {
			return -1;
		}
			return recordList.size();
			
		
	}

	

}
