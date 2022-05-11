package enablement.transformers.hackathon.repositories;

import enablement.transformers.hackathon.entities.Company;
import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}

