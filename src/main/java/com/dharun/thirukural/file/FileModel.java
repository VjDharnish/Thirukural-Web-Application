package com.dharun.thirukural.file;
import java.util.Scanner;

import com.dharun.thirukural.repository.ThirukuralRepo;
public class FileModel implements FileModelCallBack{

	private FileController fileController;

	public FileModel(FileController fileController) {
		this.fileController = fileController;
	}

	@Override
	public Scanner getHistory() {
		Scanner history = ThirukuralRepo.getInstance().getHistory();
		return history;
		
	}

	@Override
	public Scanner getSpeciality() {
		Scanner speciality = ThirukuralRepo.getInstance().getSpeciality();
		return speciality;
	}

}
