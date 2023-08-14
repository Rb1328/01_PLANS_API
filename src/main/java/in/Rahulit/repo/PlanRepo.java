package in.Rahulit.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import in.Rahulit.entities.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer> {

}
