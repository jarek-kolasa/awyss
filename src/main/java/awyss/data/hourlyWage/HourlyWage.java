package awyss.data.hourlyWage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "work_wage")
@Getter
@Setter
public class HourlyWage implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "work_name")
    private String workName;

    @Column(name = "price")
    private Long price;
}
