package am.sfl.cafeShushan.entity;

import am.sfl.cafeShushan.model.ERole;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;

/**
 * Created by Shushi on 1/9/2018.
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	@Column(name = "username",unique = true)
	@NotEmpty(message = "*Please provide your username")
	private String username;
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String fullName;



	@Enumerated(EnumType.STRING)
	private ERole role;



}
