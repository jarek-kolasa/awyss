package awyss.data.hourlyWage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HourlyWageController {

    @Autowired
    private HourlyWageRepository hourlyWageRepository;

    @RequestMapping("/price_per_hour")
    public String getWorkers(Model model) {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        model.addAttribute("hourlyWage", hourlyWages);
        return "data/hourlyWage";

    }


    @GetMapping("/edit_price_per_hour")
    public String price(Model model) {
        return "data/hourlyWage";
    }


    @PostMapping(value = "/add_work")
    public String submit(@Valid @ModelAttribute("hourlyWage") HourlyWage hourlyWage, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "error";
        }
        hourlyWageRepository.save(hourlyWage);
        return "data/hourlyWage";
    }



}
