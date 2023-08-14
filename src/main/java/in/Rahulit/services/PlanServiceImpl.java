package in.Rahulit.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Rahulit.entities.Plan;
import in.Rahulit.entities.PlanCategory;
import in.Rahulit.repo.PlanCategoryRepo;
import in.Rahulit.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	@Override
	public Map<Integer, String> getPlanCategories() {

	List<PlanCategory> categories=	planCategoryRepo.findAll();
		
	Map<Integer,String> categoryMap=new HashMap<>();
	categories.forEach(category->{
		categoryMap.put(category.getCategoryId(),category.getCategoryName());
	});
	
		return categoryMap;
	}
	
	@Override
	public boolean savePlan(Plan plan) {
		Plan saved=planRepo.save(plan);
		return saved.getPlanId()!=null?true:false;
		
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById=planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		
		Plan saved=planRepo.save(plan); //upsert method()
		
		return plan.getPlanId()!=null;
	}
	

	@Override
	public boolean deletePlanById(Integer planId) {

		boolean status=false;
		try {
			planRepo.deleteById(planId);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		
	}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		// TODO Auto-generated method stub
		
		Optional<Plan> findById=planRepo.findById(planId);
	
	     if(findById.isPresent()) {
	    	 Plan plan=findById.get();
	    	 plan.setActiveSw(status);
	    	 planRepo.save(plan);
	    	 return true;
	     }
		return false;
	}

}
