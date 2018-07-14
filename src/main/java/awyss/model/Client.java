package awyss.model;


import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true, nullable = false)
    private String clientName;
}
