package in.Rahulit.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.Rahulit.entities.Plan;
 
public interface PlanService {
    public Map<Integer,String>getPlanCategories();
   
    public List<Plan> getAllPlans();
    
    public Plan getPlanById(Integer planId);
    
    public boolean updatePlan(Plan plan);
    
    public boolean deletePlanById(Integer planId);
    
    public boolean planStatusChange(Integer planid,String status);

	boolean savePlan(Plan plan);
}
