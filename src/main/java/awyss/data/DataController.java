package awyss.data;

import awyss.data.euro.EuroService;
import awyss.data.hourlyWage.HourlyWage;
import awyss.data.hourlyWage.HourlyWageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    private HourlyWageRepository hourlyWageRepository;

    @Autowired
    private EuroService euroService;

    @Autowired
    private SteelPrice steelPrice;

    @GetMapping("/data")
    public String data(Model model) {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        model.addAttribute("hourlyWage", hourlyWages);
        model.addAttribute("euro", euroService);
        model.addAttribute("price", steelPrice);
        return "data/data";
    }

    @GetMapping("/price")
    public String priceChange() {
        return "data/price";
    }

}
