package awyss.calculation.operationTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationTimeService {

    @Autowired
    OperationTimeRepository operationTimeRepository;

    OperationTime operationTime;


    public OperationTime getStartOperationTime(){
        if (operationTime == null) {
            operationTime = new OperationTime();

            operationTime.setOperationTime( 0.0 );
        }
        return operationTime;
    }


    public OperationTime operationTime( OperationTime newOperationTime) {

        operationTime.setOperationTime(newOperationTime.getOperationTime());


        return operationTimeRepository.save(operationTime);
    }


}
