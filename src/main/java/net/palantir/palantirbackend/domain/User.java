package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import java.util.Objects;

@Generated
@Entity
@Table(name = "user")
public class User implements Serializable {

	@jakarta.persistence.Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "pass")
	private String pass;

	@Column(name = "created")
	private Date created;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public boolean equals(Object o) {
	  	if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id && Objects.equals(email, user.email) && Objects.equals(pass, user.pass) && Objects.equals(created, user.created);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, pass, created);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email + '\'' + ", pass='" + pass + '\'' + ", created=" + created + '}';
	}
}
