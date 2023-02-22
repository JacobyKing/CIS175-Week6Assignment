/**
 * @author jacoby - jking11@dmacc.edu
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OwnerDetails {
	@Id
	@GeneratedValue
	private int id;
	private String dlNumber;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<SportsCar> listOfCars;
	
	public OwnerDetails() {
		super();
	}
	public OwnerDetails(int id, String dlNumber, Owner owner, List<SportsCar> listOfCars) {
		super();
		this.id = id;
		this.dlNumber = dlNumber;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}
	public OwnerDetails(String dlNumber, Owner owner, List<SportsCar> listOfCars) {
		super();
		this.dlNumber = dlNumber;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}
	public OwnerDetails(String dlNumber, Owner owner) {
		super();
		this.dlNumber = dlNumber;
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDlNumber() {
		return dlNumber;
	}
	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<SportsCar> getListOfCars() {
		return listOfCars;
	}
	public void setListOfCars(List<SportsCar> listOfCars) {
		this.listOfCars = listOfCars;
	}
	@Override
	public String toString() {
		return "OwnerDetails [id=" + id + ", dlNumber=" + dlNumber + ", owner=" + owner + ", listOfCars=" + listOfCars + "]";
	}
}
