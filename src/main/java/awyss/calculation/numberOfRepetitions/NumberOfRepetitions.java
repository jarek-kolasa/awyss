package awyss.calculation.numberOfRepetitions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "number_of_repetitions")
public class NumberOfRepetitions {

    @Id
    public Long id;

    @NotBlank
    public int numberOfRepetitions;



}
