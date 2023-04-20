package com.dharun.thirukural.thirukuralbyadhigaram;

import java.util.List;

import com.dharun.thirukural.dto.Thirukural;

public class AdhigaramController implements AdhigaramControllerModelCallBack {
	 
	private AdhigaramModelCallBack adhigaramModel;
	private  AdhigaramController() {
		
		this.adhigaramModel= new AdhigaramModel(this);
		
	}
	private static AdhigaramController adhigaramController;
	
	
	public static AdhigaramController getInstance() {
		if(adhigaramController == null) {
			adhigaramController = new AdhigaramController();
		}
		return adhigaramController;
	}
	
	
	
	public List<Thirukural> findAdhigaram(String option) {
		List<Thirukural> kurals=null;
		try { 
			int  number=  Integer.parseInt(option);
			if(number<1||number>133)
				throw new NumberFormatException();
			 kurals = adhigaramModel.getAdhigaram(number-1);
		}
		catch(NumberFormatException e) {
			//adhigaramView.invalidOption("நீங்கள் தவறான அதிகார எண்ணை உள்ளிட்டுள்ளீர்கள்");
		}
		return kurals;
		
	}
	
//	@Override
//	public void showKurals(String adhigaram, List<Thirukural> kurals) {
//		Long[] number = new Long[10];
//		String[] line1 = new String[10];
//		String[] line2 = new String[10];
//		String[] tamilExplanation= new String[10];
//		String[] translation = new String[10];
//		String[] englishExplanation = new String[10];
//		for(int i =0;i<kurals.size();i++) {
//			number[i] = kurals.get(i).getNumber();
//			line1[i] = kurals.get(i).getLine1();
//			line2[i] = kurals.get(i).getLine2();
//			tamilExplanation[i]= kurals.get(i).getTamilExplanation();
//			translation[i] = kurals.get(i).getTransliteration();
//			englishExplanation[i] = kurals.get(i).getEnglishExplanation();			
//		}
//		adhigaramView.showKurals(adhigaram,number,line1,line2,tamilExplanation,translation,englishExplanation);
//		
//	}

}
