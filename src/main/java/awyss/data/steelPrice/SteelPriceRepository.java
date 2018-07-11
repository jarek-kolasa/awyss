package awyss.data.steelPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SteelPriceRepository extends JpaRepository<SteelPrice, Long> {

//    getLastValue

//List<SteelPrice> findSteelPricesByIdOrderByIdIdDesc();

}
