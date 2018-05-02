package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.NoteType;

@EnableWebMvc
@Controller
public class AgricultureController {

	static final Logger logger = Logger.getLogger(AgricultureController.class);
	
	@RequestMapping("/agricultureDept")
	public String getAgricultureDept() {
		return "agricultureDept";
	}
	
	@RequestMapping("/agricultureDeptList")
	public String getAgricultureDeptList() {
		return "agricultureDeptList";
	}
	
	@RequestMapping("/horticultureDeptList")
	public String getHorticultureDeptList() {
		return "horticultureDeptList";
	}
	
	@RequestMapping("/waterStorageTank")
	public String getWaterStorageTank() {
		return "WaterStorageTankEng";
	}
	
	
	@RequestMapping("/renewalmanufactureInsecticides")
	public String getRenewalmanufactureInsecticides() {
		return "RenewalmanufactureInsecticides";
	}
	
	
	@RequestMapping("/sprinkler")
	public String getSprinkler() {
		return "Sprinkler";
	}
	
	@RequestMapping("/manufactureinsecticides")
	public String getManufactureInsecticides() {
		return "ManufactureInsecticides";
	}
	
	@RequestMapping("/salepermission")
	public String getSalePermission() {
		return "SalePermission";
	}
	
	@RequestMapping("/appsubsidyonfarmpond")
	public String getFarmPond() {
		return "AppSubsidyOnFarmPond";
	}
	
	@RequestMapping("/appsubsidydiggi")
	public String getSubsidyDiggi() {
		return "AppSubsidyDiggi";
	}
	
	@RequestMapping("/incentivetogirls")
	public String getIncentiveToGirls() {
		return "IncentiveToGirls";
	}
	
	
	@RequestMapping(value="/NoteDetails")
	public void getNoteDetails(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		PrintWriter pw=res.getWriter();
		JSONArray jarr = new JSONArray();
			
		try {
			/*logger.info("NoteDetails, total10note :"+NoteType.total10Note+" total20note :"+NoteType.total20Note+" total50note:"+NoteType.total50Note
					+" total100note :"+NoteType.total100Note+" total200note :"+NoteType.total200Note+" total500note :"	+
					NoteType.total500Note+" total2000note :"+NoteType.total2000Note );*/
			
			/*NoteType.total10Note++;
			NoteType.total20Note++;
			NoteType.total50Note++;
			NoteType.total100Note++;
			NoteType.total200Note++;
			NoteType.total500Note++;
			NoteType.total2000Note++;*/
			
			int total = (NoteType.total10Note*10) + (NoteType.total20Note*20 ) + ( NoteType.total50Note*50)
					+ (NoteType.total100Note*100)+ (NoteType.total200Note*200) + (NoteType.total500Note*500) + (NoteType.total2000Note*2000);
			
		//	logger.info("NoteDetails, total Amount :"+total);
			JSONObject jObject=new JSONObject();
			jObject.put("count1",NoteType.total10Note);
			jObject.put("count2",NoteType.total20Note);
			jObject.put("count3",NoteType.total50Note);
			jObject.put("count4",NoteType.total100Note);
			jObject.put("count5",NoteType.total200Note);
			jObject.put("count6",NoteType.total500Note);
			jObject.put("count7",NoteType.total2000Note);
			
			
			jObject.put("totalcount1",NoteType.total10Note*10);
			jObject.put("totalcount2",NoteType.total20Note*20);
			jObject.put("totalcount3",NoteType.total50Note*50);
			jObject.put("totalcount4",NoteType.total100Note*100);
			jObject.put("totalcount5",NoteType.total200Note*200);
			jObject.put("totalcount6",NoteType.total500Note*500);
			jObject.put("totalcount7",NoteType.total2000Note*2000);
			
			jObject.put("totalAmount",total);
			
			jObject.put("cashTimer",NoteType.cashTimer);
			jObject.put("depositAmount", NoteType.depositAmount);
			
			jarr.put(jObject);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		pw.print(jarr);
		pw.flush();
		pw.close();
	}
	
	
}
