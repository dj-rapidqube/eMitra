package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class HortiCultureController {

	static final Logger logger = Logger.getLogger(HortiCultureController.class);
	
	@RequestMapping("/appsolarpumpset")
	public String getAppSolarPumpSet() {
		return "AppSolarPumpSet";
	}
	
	@RequestMapping("/coldStorage")
	public String getColdStorage() {
		return "ColdStorage";
	}
	
	@RequestMapping("/fruitOrch")
	public String getFruitOrch() {
		return "FruitOrch";
	}
	
	@RequestMapping("/greenHouse")
	public String getGreenHouse() {
		return "GreenHouse";
	}
	
	@RequestMapping("/vermiCompost")
	public String getVermiCompost() {
		return "VermiCompost";
	}
	
	@RequestMapping("/waterResource")
		public String getWaterRsource() {
		return "WaterResource";
	}
	
	@RequestMapping("/mediPlantMedicinalPlants")
	public String getMedicinalPlants() {
		return "MedicinalPlants";
	}
	
	@RequestMapping("/mISHorticulturePmsky")
	public String getMISHorticulturePmsky() {
		return "MISHorticulturePmsky";
	}
	
	
	
}
