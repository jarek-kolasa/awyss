package awyss.data.steelPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteelPriceRepository extends JpaRepository<SteelPrice, Long> {


}
