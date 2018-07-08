package awyss.data;

import awyss.data.euro.EuroService;
import awyss.data.hourlyWage.HourlyWage;
import awyss.data.hourlyWage.HourlyWageRepository;
import awyss.data.steelPrice.SteelPrice;
import awyss.data.steelPrice.SteelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    private HourlyWageRepository hourlyWageRepository;

    @Autowired
    private EuroService euroService;

    @Autowired
    private SteelPriceService steelPriceService;

    @GetMapping("/data")
    public String data(Model model) {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        model.addAttribute("hourlyWage", hourlyWages);
        model.addAttribute("euro", euroService);
        model.addAttribute("price", steelPriceService);
        return "data/data";
    }

    @GetMapping("/price")
    public String priceChange() {
        return "data/price";
    }

    @PutMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    public SteelPrice priceOfSteel(@PathVariable Long id, @Valid @RequestBody SteelPrice steelPrice, BindingResult bindingResult){
        return steelPriceService.updatePrice(steelPrice, id, bindingResult);
    }

}
