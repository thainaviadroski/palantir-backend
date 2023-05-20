package net.palantir.palantirbackend.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "statistics")
public class Statistics implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "life_point")
	private int lifePoint;

	@Column(name = "armor_point")
	private int armorPoint;

	@Column(name = "experienci_point")
	private int experienciPoint;

	@Column(name = "mana_point")
	private int manaPoint;

	@Column(name = "displacement")
	private int displacement;

	@Column(name = "initiative")
	private int initiative;

	@Column(name = "perception")
	private int perception;

	@Column(name = "fortification")


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public int getArmorPoint() {
		return armorPoint;
	}

	public void setArmorPoint(int armorPoint) {
		this.armorPoint = armorPoint;
	}

	public int getExperienciPoint() {
		return experienciPoint;
	}

	public void setExperienciPoint(int experienciPoint) {
		this.experienciPoint = experienciPoint;
	}

	public int getManaPoint() {
		return manaPoint;
	}

	public void setManaPoint(int manaPoint) {
		this.manaPoint = manaPoint;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Statistics that = (Statistics) o;
		return lifePoint == that.lifePoint && armorPoint == that.armorPoint && experienciPoint == that.experienciPoint && manaPoint == that.manaPoint && displacement == that.displacement && initiative == that.initiative && perception == that.perception && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lifePoint, armorPoint, experienciPoint, manaPoint, displacement, initiative, perception);
	}

	@Override
	public String toString() {
		return "Statistics{" +
				"id=" + id +
				", lifePoint=" + lifePoint +
				", armorPoint=" + armorPoint +
				", experienciPoint=" + experienciPoint +
				", manaPoint=" + manaPoint +
				", displacement=" + displacement +
				", initiative=" + initiative +
				", perception=" + perception +
				'}';
	}
}
