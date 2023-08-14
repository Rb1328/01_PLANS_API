package in.Rahulit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Rahulit.Constants.AppContants;
import in.Rahulit.Props.AppProperties;
import in.Rahulit.entities.Plan;
import in.Rahulit.services.PlanService;

@RestController
public class PlanRestCotroller {
	
	public PlanService planService;
	 Map<String,String> messages;
	
	public PlanRestCotroller(PlanService planService,AppProperties appProps) {
		this.planService=planService;
		this.messages=appProps.getMessages();
		   System.out.println(this.messages);
	}
//	------------Here We Remove Autowired annotation and create Costructor for Map( " Map<String,appProps.getMessages() " this line we have tString> messages=o write in every 
//	msg now after constructor we remove this) and planServices	
//	@Autowired
//	private PlanService planService;
//	
//	@Autowired
//	private AppProperties appProps;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer ,String>> planCategories(){
		Map<Integer,String> categories=planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	   
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		String responseMsg=AppContants.Empty_STR;
		
		boolean isSaved=planService.savePlan(plan);
		
	   if(isSaved) {
		   
		 responseMsg=messages.get(AppContants.PLAN_SAVE_SUCC);
	   }
	   else {
		   responseMsg=messages.get(AppContants.PLAN_SAVE_FAIL);
	   }
	
	return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
}
	
	@GetMapping("plans")
	public ResponseEntity<List<Plan>> Plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		
		Plan planById = planService.getPlanById(planId);
		
		return new ResponseEntity<>(planById,HttpStatus.OK);
	
		
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		 
		boolean isupdated = planService.updatePlan(plan);
		String msg=AppContants.Empty_STR;
		if(isupdated) {
			 msg=messages.get(AppContants.UPDATE_SAVE_SUCC);
		}
		else {
			 msg=messages.get(AppContants.UPDATE_SAVE_FAIL);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
	 
		String msg=AppContants.Empty_STR;
		 boolean isDeleted = planService.deletePlanById(planId);
	 	 
		 
		 if (isDeleted){
			 msg=messages.get(AppContants.DELETE_SAVE_SUCC);
		 }
		 else {
			 msg=messages.get(AppContants.DELETE_SAVE_FAIL);
		 }
		 
		
		return new ResponseEntity<>(msg,HttpStatus.OK); 
	
		
	}
	
	@PutMapping("/ststus-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(Integer planID, String status){
		boolean isStatusChanged=planService.planStatusChange(planID, status);
		
		String msg=AppContants.Empty_STR;
		 
		if(isStatusChanged) {
			msg=messages.get(AppContants.STATUS_CHANGE_SUCC);
		}
		else {
			msg=messages.get(AppContants.STATUS_CHANGE_FAIL);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK); 
		
	}
	
}