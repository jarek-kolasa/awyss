package awyss.calculation.numberOfRepetitions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberOfRepetitionsRepository extends JpaRepository<NumberOfRepetitions,Long> {
}
