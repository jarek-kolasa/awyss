package awyss.data.steelPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class SteelPriceService {

    @Autowired
    SteelPriceRepository steelPriceRepository;


    public SteelPrice updatePrice(SteelPrice newsteelPrice, Long id, BindingResult bindingResult){

        SteelPrice currentSteelPrice = steelPriceRepository.getOne(id);

        currentSteelPrice.setSteelPrice(newsteelPrice.getSteelPrice());
        return steelPriceRepository.save(currentSteelPrice);
    }
}
