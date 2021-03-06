package awyss.data.hourlyWage;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "work_wage")
@Getter
@Setter
public class HourlyWage implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "work_name")
    private String workName;

    @Column(name = "price")
    private Double price;

    @Column(name = "start_date_work")
    private LocalDateTime workStartDate;

    @Column(name = "end_date_work")
    private LocalDateTime workEndDate;


}
