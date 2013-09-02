package client;
import java.io.File;


public class TotalTimeInVedios {

	public TotalTimeInVedios() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("D:\\Mdev\\Vedios\\Algo Vedios\\Part 2");
		File[] listOfFiles = folder.listFiles();
int iTotal = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			File file =listOfFiles[i];
			String fileName = file.getName();
			if (listOfFiles[i].isFile()) {		        
				if(fileName.endsWith("mp4")){
					System.out.println("File " + listOfFiles[i].getName());
					int i1 = fileName.indexOf("(");
					int i2 = fileName.indexOf(")");
					String milli = fileName.substring(i1+1, i2);
					int time = Integer.valueOf(milli);
					int sec = time%100;
					int min = time/100;
					iTotal = iTotal + sec + min*60;
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		System.out.println(iTotal/60/60+" hrs");
	}

}
