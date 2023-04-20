package com.dharun.thirukural.thirukuralbyadhigaram;

import java.util.List;


import com.dharun.thirukural.dto.Thirukural;
import com.dharun.thirukural.repository.ThirukuralRepo;

public class AdhigaramModel implements AdhigaramModelCallBack {
	private AdhigaramControllerModelCallBack adhigaramController;
	public AdhigaramModel(AdhigaramControllerModelCallBack adhigaramController) {
		this.adhigaramController =adhigaramController;
	}
	@Override
	public List<Thirukural> getAdhigaram(int number) {
		List arr  = ThirukuralRepo.getInstance().getAdhigaram(number); 
		if(arr.size() ==0) {
			return null;
		}
		else {
			String adhigaram  = (String) arr.get(0);
			long start = ((long)arr.get(1))-1;
			List<Thirukural> kurals =  ThirukuralRepo.getInstance().getAdhigaramKural(start);
//			if(kurals.size() == 0) {
//				adhigaramController.showException("File Not Found");
//			}
//			else {
//				adhigaramController.showKurals(adhigaram,kurals);
//			}
			return kurals;
		}	
	}

}
