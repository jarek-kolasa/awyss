package awyss.data.steelPrice;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
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
    public String steelPrice;

    public LocalDate startDate = LocalDate.now();


//    public LocalDate endDate;


}
