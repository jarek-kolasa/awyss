package awyss.calculation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewCalculationController {

    @GetMapping("/newcalculation")
    public String newcalculation(){
        return "calculation/newcalculation";
    }
}
