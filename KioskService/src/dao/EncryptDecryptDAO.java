package dao;

import java.util.List;

import model.Bill;
import model.Discom;
import model.Phed;

public interface EncryptDecryptDAO {
	public List<Bill> getAirtelDetails(String apiResult,Bill bill);
	public List<Bill> getIdeaDetails(String apiResult,Bill bill);
	public List<Bill> getVodafoneDetails(String apiResult,Bill bill);
	public List<Discom> getDiscomDetails(String apiResult,Bill bill, Discom discom);
	public List<Bill> getBsnlDetails(String apiResult,Bill bill);
	public List<Phed> getPhedDetails(String apiResult,Bill bill, Phed phed);
	
}

