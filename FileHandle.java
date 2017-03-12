import java.io.FileInputStream;
import java.io.*;

public class FileHandle {
	private FileInputStream fileIn;
	private byte[] buffer = new byte[52428800];
	private File tempFile;
	private int readLength = 52428800;
	private boolean isReadComplete = false;
	private long readFileSize = 0;

	public FileHandle(File temp){
		tempFile = temp;
		try{
			fileIn = new FileInputStream(temp);
		}catch(FileNotFoundException e){
			System.out.println("File not found"+e.getMessage());
		}
	}

	public byte[] read(){
		//check for file size and available bytes to be read
		int readL = readLength;
		try{
			//checks if we are at the end of file read
			if (fileIn.available() < readLength) {
				readL = fileIn.available();
			}

			//reads a specified size of bytes from the file being transfered
			this.fileIn.read(buffer,0,readL);
			readFileSize += readL;

			//checks if the file read is complete
			if (readFileSize >= tempFile.length()) {
				isReadComplete = true;
				fileIn.close();
			}			
		}catch(FileNotFoundException e){
			System.out.println("File not found"+e.getMessage());
		}catch(IOException e){
			System.out.println("IO: "+e.getMessage());
		}

		return getBuffer();
	}

	public byte[] getBuffer(){
		return buffer;
	}

	public long getReadFileSize(){
		return readFileSize;
	}

	public boolean getIsReadComplete(){
		return isReadComplete;
	}
}