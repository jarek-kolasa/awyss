package awyss.calculation.operationTime;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTimeRepository extends JpaRepository<OperationTime,Long> {
}
