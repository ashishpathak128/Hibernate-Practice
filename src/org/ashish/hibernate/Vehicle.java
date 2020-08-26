package org.ashish.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.ashish.pack.dto.UserDetails;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*
 * @DiscriminatorColumn( name="Vehicle_Type",
 * discriminatorType=DiscriminatorType.STRING )
 */
public class Vehicle {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	/* @ManyToMany */
	/* @ManyToOne */
	/* @JoinColumn(name="User_Id") */
	/* private Collection<UserDetails> users = new ArrayList<UserDetails>(); */
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	/*
	 * public Collection<UserDetails> getUsers() { return users; } public void
	 * setUsers(Collection<UserDetails> users) { this.users = users; }
	 */
	
	

}
