package awyss.data.hourlyWage;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "work_wage")
@Data
public class HourlyWage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "work_name")
    private String workName;

    @Column(name = "price")
    private Long price;
}
