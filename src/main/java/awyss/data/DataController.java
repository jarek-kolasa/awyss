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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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
    public String data(Model model) throws IOException {
        List<HourlyWage> hourlyWages = hourlyWageRepository.findAll();
        model.addAttribute("hourlyWage", hourlyWages);
        model.addAttribute("euro", euroService.euroLastApplicableValue());
        model.addAttribute("price", steelPriceService.getLastValue().getSteelPrice());
        return "data/data";
    }

    @GetMapping("/price")
    public String priceChange(Model model) {
        model.addAttribute("steelPrice", steelPriceService.getLastValue());
        return "data/price";
    }

    @PostMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    public String updatePriceOfSteel(@Valid @ModelAttribute("steelPrice") SteelPrice steelPrice){
        System.out.println(steelPrice.getId());
        System.out.println(steelPrice.getSteelPrice());
//        System.out.println(steelPrice.getStartDate());
//        System.out.println(steelPrice.getEndDate());

        steelPriceService.updatePrice(steelPrice);
        return "data/price";
    }

}
