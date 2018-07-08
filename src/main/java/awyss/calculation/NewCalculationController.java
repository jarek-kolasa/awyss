package awyss.calculation;

import awyss.calculation.totalTime.TotalTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class NewCalculationController {

    @Autowired
    private TotalTimeService totalTimeService;

//    @GetMapping("/newcalculation")
//    public String newcalculation(){
//        return "calculation/newcalculation";
//    }

    @GetMapping("/newcalculation")
    public String totalTime(Model model){
        model.addAttribute( "totalTime",totalTimeService );
        return "calculation/newcalculation";
    }

    public double operationTime( @PathVariable Long id @)



}
