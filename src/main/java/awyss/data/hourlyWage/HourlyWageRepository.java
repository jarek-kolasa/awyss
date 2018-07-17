package awyss.data.hourlyWage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourlyWageRepository extends JpaRepository<HourlyWage, Long> {

}
