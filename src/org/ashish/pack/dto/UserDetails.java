package org.ashish.pack.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.ashish.hibernate.Address;
import org.ashish.hibernate.Vehicle;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SelectBeforeUpdate
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId > :userId and userName = :userName")
public class UserDetails {
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	/* @OneToMany(mappedBy="user") */
	/* @ManyToMany */
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Address adr;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable (name = "User_Address",
			joinColumns=@JoinColumn(name="Address")
					)
	@GenericGenerator(name="hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name="Address_Id") }, generator="hilo-gen", type = @Type(type="long"))
	private Collection<Address> addresses = new ArrayList<Address>();
	
	@Embedded
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	@Lob
	private String descp;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	

}
