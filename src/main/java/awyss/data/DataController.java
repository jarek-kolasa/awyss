package awyss.data;

import awyss.account.Account;
import awyss.account.Role;
import awyss.data.hourlyWage.HourlyWage;
import awyss.data.hourlyWage.HourlyWageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DataController {

    @Autowired
    private HourlyWageRepository hourlyWageRepository;

    @GetMapping("/data")
    public String signin(Model model) {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        model.addAttribute("hourlyWage", hourlyWages);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getAuthorities();
//        data.addAttribute("data", data);
        return "data/data";
    }
}
