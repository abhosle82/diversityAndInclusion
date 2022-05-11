package enablement.transformers.hackathon.repositories;

import enablement.transformers.hackathon.entities.DiversityAndInclusion;
import enablement.transformers.hackathon.entities.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends JpaRepository<Leader,Integer> {
}