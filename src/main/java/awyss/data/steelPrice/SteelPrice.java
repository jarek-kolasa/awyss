package awyss.data.steelPrice;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price_of_steel")
public class SteelPrice {

    @Id
    @GeneratedValue
    public Long id;

    @NotBlank
    public double steelPrice;

    @NotBlank
    public LocalDate startDate;


    public LocalDate endDate;


}
