package weekendhomework23;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UploadedFile {
	private String fileName;
	private String fileExtension;
	private Long fileSize;
	File file;
	
	
	
	/**
	 * 
	 * @param fileName
	 * @param fileExtension
	 * @param fileSize
	 * @param file
	 */
	public UploadedFile(String fileName, String fileExtension, Long fileSize, File file) {
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.fileSize = fileSize;
		this.file = file;
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}


	/**
	 * @param fileExtension the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}


	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}


	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}
	

	static void copyFile(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UploadedFile [fileName: " + fileName + ", fileExtension: " + fileExtension + ", fileSize: " + fileSize
				+ ", file: " + file + "]";
	}
	
	
	
	
	
	
	

}
