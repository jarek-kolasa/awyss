package awyss.calculation;

import awyss.calculation.operationTime.OperationTime;
import awyss.calculation.operationTime.OperationTimeService;
import awyss.calculation.totalTime.TotalTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class NewCalculationController {

    @Autowired
    private TotalTimeService totalTimeService;

    @Autowired
    private OperationTimeService operationTimeService;


    @GetMapping("/newcalculation")
    public String totalTime(Model model){
        model.addAttribute( "totalTime",totalTimeService.value );
        return "calculation/newcalculation";
    }

    @PutMapping("/newcalculation")
    @ResponseStatus(HttpStatus.OK)
    public String operationTime( @Valid @ModelAttribute("operationTime")OperationTime operationTime, BindingResult bindingResult ){
        operationTimeService.operationTime(operationTime);
        return "calculation/newcalculation";

    }






}
