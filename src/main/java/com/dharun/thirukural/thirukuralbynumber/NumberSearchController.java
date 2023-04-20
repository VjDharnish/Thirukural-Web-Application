package com.dharun.thirukural.thirukuralbynumber;



import java.util.Random;

import com.dharun.thirukural.dto.Thirukural;

public class NumberSearchController  {
	private NumberSearchModel numberSearchModel;
	

	private  NumberSearchController() {
		
		this.numberSearchModel = new NumberSearchModel(this);

	}
	private static NumberSearchController numberController;
	public static NumberSearchController getInstance() {
		if(numberController ==null) {
			numberController= new NumberSearchController();
		}
		return numberController;
		
	}
	public Thirukural getKural(int kuralEnn) {
		Thirukural kural = numberSearchModel.getKural(kuralEnn-1);
		return kural;
	}
	public Thirukural getKuralOfTheDay() {
		Random random = new Random();
		int randomNumber = random.nextInt(1320);
		return getKural(randomNumber);
	}

	
	

}
