package awyss.calculation.numberOfRepetitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberOfRepetitionsService {


    @Autowired
    NumberOfRepetitionsRepository numberOfRepetitionsRepository;

    NumberOfRepetitions numberOfRepetitions;

    public NumberOfRepetitions getNumberOfRepetitions(){
        if (numberOfRepetitions == null) {
            numberOfRepetitions = new NumberOfRepetitions();

            numberOfRepetitions.setNumberOfRepetitions( 0 );
        }
        return numberOfRepetitions;
    }

    public NumberOfRepetitions numberOfRepetitions( NumberOfRepetitions newNumberOfRepetitions) {

        numberOfRepetitions.setNumberOfRepetitions(newNumberOfRepetitions.getNumberOfRepetitions());

        return numberOfRepetitionsRepository.save(numberOfRepetitions);
    }



}
