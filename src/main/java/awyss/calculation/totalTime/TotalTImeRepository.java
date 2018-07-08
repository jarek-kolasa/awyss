package awyss.calculation.totalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalTImeRepository extends JpaRepository<TotalTime,Long> {
}
