package awyss.data.steelPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;

@Service
public class SteelPriceService {

    @Autowired
    SteelPriceRepository steelPriceRepository;

    SteelPrice steelPrice;

    public SteelPrice getLastValue() {
        SteelPrice steelPrice = new SteelPrice();

        steelPrice.setSteelPrice(0.0);

        return steelPrice;
    }


    public SteelPrice updatePrice(SteelPrice newSteelPrice, BindingResult bindingResult) {

        if(steelPrice == null){
            steelPrice = new SteelPrice(Long.valueOf(1),0.0,LocalDate.MIN,LocalDate.now());
        }

        steelPrice.setSteelPrice(newSteelPrice.getSteelPrice());
        return steelPriceRepository.save(steelPrice);
    }
}
