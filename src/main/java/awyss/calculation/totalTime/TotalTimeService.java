package awyss.calculation.totalTime;

import awyss.calculation.numberOfRepetitions.NumberOfRepetitions;
import awyss.calculation.operationTime.OperationTime;
import org.springframework.stereotype.Service;

@Service
public class TotalTimeService {



    public TotalTime countingTotalOperationTime( ){

        NumberOfRepetitions numberOfRepetitions = new NumberOfRepetitions();
        int x=numberOfRepetitions.getNumberOfRepetitions();

        OperationTime operationTime = new OperationTime();
        double y = operationTime.getOperationTime();

//        numberOfRepetitions numberOfRepetitions;

        TotalTime totalTime = new TotalTime();

//        OperationTime operationTime;

//        double calculatedTime = operationTime.getOperationTime()*numberOfRepetitions.getNumberOfRepetitions();
        double calculatedTime = x*y;

        totalTime.setTotalTime( calculatedTime );


        return  totalTime;

}

}
