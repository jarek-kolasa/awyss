package awyss.calculation.totalTime;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TotalTimeService {

    public double value = totalOperationTime();

    public TotalTimeService() throws IOException {
    }

    private double totalOperationTime() throws IOException {

        return value;
    }
}
