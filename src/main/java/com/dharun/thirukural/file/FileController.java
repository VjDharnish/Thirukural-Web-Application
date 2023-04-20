package com.dharun.thirukural.file;

import java.util.Scanner;

public class FileController {
	private FileModelCallBack fileModel;
	private  FileController() {

	this.fileModel = new FileModel(this);// TODO Auto-generated constructor stub
	}
	private  static FileController fileController;
	
	public static FileController getInstance() {
		if(fileController  ==null)
			fileController =new FileController();
		return fileController;
	}
	
	

	public Scanner getHistory() {
		Scanner history = fileModel.getHistory();
		
		return history;
	}
	
	public Scanner getSpecality() {
		Scanner speciality = fileModel.getSpeciality();
		
		return speciality;
	}

}
