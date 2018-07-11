package awyss.data.steelPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SteelPriceService {


    @Autowired
    SteelPriceRepository steelPriceRepository;


    public SteelPrice getLastValue() {

        List<SteelPrice> steelPriceList = steelPriceRepository.findAll();

        SteelPrice steelPrice = steelPriceList.get(steelPriceList.size()-1);

        return steelPrice;
    }


    public SteelPrice updatePrice(SteelPrice newSteelPrice) {

        return steelPriceRepository.save(newSteelPrice);
    }
}
