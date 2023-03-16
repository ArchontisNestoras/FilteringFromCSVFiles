package metadata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;  

public class NaiveFileMetadataManager implements MetadataManagerInterface {
	private String sAlias;
	private File sFile;
	private String sSeparator;

	public NaiveFileMetadataManager(String sAlias, File sFile, String sSeparator) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		this.sAlias=sAlias;
		this.sFile=sFile;
		this.sSeparator=sSeparator;
		
		
		
	}

	@Override
	public Map<String, Integer> getFieldPositions() throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(this.sFile);
		//String x=sc.nextLine();
		//String [] y=x.split(sSeparator);
		String [] y=this.getColumnNames();
		Map <String,Integer> myMap=new HashMap <String,Integer>();
		for(int i=0;i<y.length;i++) {
			myMap.put(y[i],i);	
		}
		return myMap ;
	}

	@Override
	public File getDataFile() {
		// TODO Auto-generated method stub
		return this.sFile;
	}

	@Override
	public String getSeparator() {
		// TODO Auto-generated method stub
		return this.sSeparator;
	}

	@Override
	public String[] getColumnNames() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(this.sFile);
		String x=sc.nextLine();
		String [] y=x.split(sSeparator);
		
		
		return y;
	}

	public String getAlias() {
		// TODO Auto-generated method stub
		
		return this.sAlias;
	}


}

/*class NaiveFileMetadataManager{
	public static void main(String args[]) throws FileNotFoundException {
		File pFile = new File("./test/resources/input/simple.csv");
		NaiveFileMetadataManagers dummy= new NaiveFileMetadataManagers("defaultAlias",pFile,",");
		String [] g= new String[6];
		g=dummy.getColumnNames();
		for(String i:g) {
			System.out.println(i);
		}
		//Map<String, Integer>a=dummy.getFieldPositions();
		//Scanner sc = new Scanner(pFile);
		//String x=sc.nextLine();
		//for(int i=0;i<a.size();i++) {
			//System.out.println(a.get(i));
		//} 
		
		//System.out.println(Arrays.asList(a));
		//System.out.println(Collections.singletonList(a));
	}
	
}*/