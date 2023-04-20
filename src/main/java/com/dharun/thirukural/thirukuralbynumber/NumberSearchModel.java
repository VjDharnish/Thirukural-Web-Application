package com.dharun.thirukural.thirukuralbynumber;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.parser.JSONParser;

import com.dharun.thirukural.dto.Thirukural;
import com.dharun.thirukural.repository.ThirukuralRepo;

public class NumberSearchModel  {
	NumberSearchController numberController;
	public NumberSearchModel(NumberSearchController numberController) {
			this.numberController = numberController;
	}
	
	public Thirukural getKural(int number) {
		Thirukural thirukural = ThirukuralRepo.getInstance().getThirukural(number);
	//	numberSearchController.showThirukural(thirukural);
		return  thirukural;
	}


}