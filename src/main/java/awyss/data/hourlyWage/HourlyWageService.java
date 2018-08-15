package awyss.data.hourlyWage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HourlyWageService {

    @Autowired
    HourlyWageRepository hourlyWageRepository;

    public List<HourlyWage> getHourlyWageList() {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        if (hourlyWages.size() == 0) {
            HourlyWage newHourlyWage = new HourlyWage();
            newHourlyWage.setId((long) 1);
            newHourlyWage.setWorkName("Spawanie");
            newHourlyWage.setPrice(0.0);
            newHourlyWage.setWorkStartDate(LocalDateTime.now());

            hourlyWages.add(newHourlyWage);
        }
        return hourlyWages;
    }

    public HourlyWage updateHourlyWage(HourlyWage newHourlyWage) {
        return hourlyWageRepository.save(newHourlyWage);
    }
}
