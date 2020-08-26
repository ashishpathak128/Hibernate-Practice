package org.ashish.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.ashish.pack.dto.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class HibernateMain {

	public static <R> void main(String[] args) {

		UserDetails user = new UserDetails();
		/*
		 * Address adr = new Address(); Vehicle veh = new Vehicle(); Vehicle veh2 = new
		 * Vehicle(); Vehicle veh3 = new Vehicle(); TwoWheeler bike = new TwoWheeler();
		 * bike.setSteeringHandle("Bikes Steering Handle"); bike.setVehicleName("Bike");
		 * FourWheeler car = new FourWheeler();
		 * car.setSteeringWheel("Car's steering wheel"); car.setVehicleName("Car");
		 * 
		 * veh.setVehicleName("Dzire"); veh2.setVehicleName("Maserati");
		 * veh3.setVehicleName("Superb");
		 * 
		 * user.setUserName("Ashish Pathak");
		 * 
		 * adr.setCity("Pune"); adr.setState("Maharashtra"); user.setAdr(adr);
		 * 
		 * user.setDescp("Its going to be a big description"); user.setJoinedDate(new
		 * Date());
		 * 
		 * Address adr2 = new Address(); adr2.setCity("Pune");
		 * adr2.setState("Maharashtra"); adr2.setStreet("dalal street");
		 * adr2.setPincode("411046");
		 * 
		 * Address adr3 = new Address(); adr3.setCity("Ahemdabad Ma");
		 * adr3.setState("Gujarat Ma"); adr3.setStreet("Share Bazar street Ma");
		 * adr3.setPincode("411046");
		 * 
		 * user.getAddresses().add(adr2); user.getAddresses().add(adr3);
		 * 
		 * user.getVehicles().add(veh2); user.getVehicles().add(veh3);
		 * 
		 * veh.getUsers().add(user); veh2.getUsers().add(user);
		 * veh3.getUsers().add(user);
		 * 
		 * 
		 */
		SessionFactory sF = new Configuration().configure().buildSessionFactory();
		Session session = sF.openSession();
		/*
		 * session.beginTransaction(); session.save(user);
		 * 
		 * session.save(veh); session.save(veh2); session.save(veh3);
		 * 
		 * session.save(bike); session.save(car);
		 * 
		 * session.getTransaction().commit(); session.close();
		 * user.setUserName("New User"); user = null;
		 */
		session = sF.openSession();
		session.beginTransaction();
		/* session.update(user); */
		/*
		 * String userName = "Ashish Pathak"; String userId = "10";
		 */
		/*
		 * Query<R> query = session.
		 * createQuery("from UserDetails where userId > :userId and userName = :userName"
		 * );
		 */
		/*
		 * Query<R> query = session.getNamedQuery("UserDetails.byId");
		 * query.setInteger("userId",Integer.parseInt(userId));
		 * query.setString("userName", userName);
		 */
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> cQuery = cb.createQuery(UserDetails.class);
		Root<UserDetails> root = cQuery.from(UserDetails.class);
		/*
		 * cQuery.select(cb.construct(UserDetails.class, root.get("userId"),
		 * root.get("userName")));
		 */
		/* cQuery.select(cb.); */
		List<UserDetails> users = session.createQuery(cQuery).getResultList();
		 
		/* user = (UserDetails) session.get(UserDetails.class, 1); */
		/* criteria.select(criteria.from(UserDetails.class)).where(criteria); */
		
		  //List<UserDetails> users = (List<UserDetails>)criteria.getR; 
		  for (UserDetails u: users) 
		  { System.out.println("User " + u.getUserName()); }
		 
		session.close();
		/*
		 * System.out.println("The userNa,e retrieved is "+ user.getAddresses().size());
		 */

	}

}
