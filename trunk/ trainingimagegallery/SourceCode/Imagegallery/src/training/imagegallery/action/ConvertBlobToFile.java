package training.imagegallery.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertBlobToFile {
	public static File Convert(InputStream blob) {
		File file = new File("Image.jpg");
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] buffer = new byte[1];
			//System.out.println("hello1:" + blob.length());
			//InputStream in =  blob.getBinaryStream();
			while(blob.read(buffer) >0){
				System.out.println("hello3:");
				out.write(buffer);
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return file;
	}
}
