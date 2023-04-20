package com.dharun.thirukural.repository;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dharun.thirukural.dto.Thirukural;

import java.io.File;
public class ThirukuralRepo {
	Object obj =null;
	JSONObject thirukuralJson;
	private static ThirukuralRepo ThirukuralDbInstance;
	private ThirukuralRepo(){
		
	}
	
	public static ThirukuralRepo getInstance() {
		if(ThirukuralDbInstance == null) {
			ThirukuralDbInstance = new ThirukuralRepo();
		}
		return ThirukuralDbInstance;
	}

	

	public Thirukural getThirukural(int kuralEnn) {
		JSONParser jsonParser = new JSONParser();
		
		
		try {
		FileReader reader = new FileReader("D:\\Folder\\java class\\Thirukural Application\\src\\assert\\thirukkural.json");
		
		try {
			obj = jsonParser.parse(reader);
			 
		}
		catch(Exception e) {
			
			return null;
		   }	
		thirukuralJson = (JSONObject)obj;
		JSONArray array = (JSONArray)thirukuralJson.get("kural"); 
		JSONObject kuraljsonObject = (JSONObject)array.get(kuralEnn);
		Thirukural thirukural = new Thirukural(kuraljsonObject);
		return thirukural;
		}
		catch(FileNotFoundException e) {	
			return null;
		}
		
	}
	public List getAdhigaram(int adhigaramEnn) {
		List arr = new ArrayList<>(2);
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("D:\\Folder\\java class\\Thirukural Application\\src\\assert\\thirukkuralAdhigaramEdited.json");
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (Exception e) {
				
				return arr;
			}
			JSONObject thirukuralAdhigaram =(JSONObject)obj;
			JSONArray array = (JSONArray)thirukuralAdhigaram.get("detail");
			JSONObject jsonObject = (JSONObject)array.get(adhigaramEnn);
			String adhigaramName = (String)jsonObject.get("name");
			long start = (long)jsonObject.get("start");
			arr.add(adhigaramName);
			arr.add(start);
			return arr;
		}
		catch(FileNotFoundException e) {
			
			return arr;
		}
	}
			
	
	
	public List getAdhigaramKural(long start) {
		List<Thirukural> kurals = new LinkedList<>();
		JSONParser jsonParser = new JSONParser();
		int startIndex =0;
		try {
			FileReader reader = new FileReader("D:\\Folder\\java class\\Thirukural Application\\src\\assert\\thirukkural.json");
			Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (Exception  e) {
				
				return kurals;
			}
			JSONObject thirukuralJson = (JSONObject)obj;
			while(startIndex<10) {
				JSONArray array = (JSONArray)thirukuralJson.get("kural");
				JSONObject kuraljsonObject = (JSONObject)array.get((int)start);
				Thirukural thirukural = new Thirukural(kuraljsonObject);
				start++;
				startIndex++;
				kurals.add(thirukural);
			}	
			
			return kurals;
			
		}catch(FileNotFoundException e) {		
			return kurals;
		}
	}

	public Scanner getHistory() {
		try {
			File history = new File("D:\\java projects\\ThirukuralApp\\assert\\Thirukural History.txt");
			Scanner reader = new Scanner(history);
			return reader;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	public Scanner getSpeciality() {
		try {
			File speciality = new File("D:\\java projects\\ThirukuralApp\\assert\\Thirukural Sirappugal.txt");
			Scanner reader = new Scanner(speciality);
			return reader;
		}
		catch(Exception e) {
			return null;
		}
	}
}
