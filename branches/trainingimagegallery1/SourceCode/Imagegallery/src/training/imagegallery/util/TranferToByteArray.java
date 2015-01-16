package training.imagegallery.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TranferToByteArray {
	public static byte[] ByteArray(File file){
		 FileInputStream fis;
		try {
			fis = new FileInputStream(file);
		
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[(int) file.length()];
	            fis.read(buf);
	            fis.close();
	        return buf;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}
}
