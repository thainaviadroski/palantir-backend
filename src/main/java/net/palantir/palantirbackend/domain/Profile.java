package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;
import lombok.Generated;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Generated
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "date_born", nullable = false)
	private Date dateBorn;


	@OneToOne
	private User user;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Profile profile = (Profile) o;
		return id == profile.id && Objects.equals(fullName, profile.fullName) && Objects.equals(dateBorn, profile.dateBorn) && Objects.equals(user, profile.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fullName, dateBorn, user);
	}


	@Override
	public String toString() {
		return "Profile{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", dateBorn=" + dateBorn +
				", user=" + user +
				'}';
	}
}
