package awyss.account;

import javax.persistence.*;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@Getter
@Setter
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;


	@Enumerated(EnumType.STRING)
	private Role role;

	private Instant created;

    protected Account() {

	}
	
	public Account(String email, String password, Role role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
	}

}
