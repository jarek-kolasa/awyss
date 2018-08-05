package awyss.data.hourlyWage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourlyWageService {

    @Autowired
    HourlyWageRepository hourlyWageRepository;


}
