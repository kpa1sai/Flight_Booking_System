package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {
	
	@Autowired 
	SessionFactory sessionFactory;
	@Override
	public void saveUsers(Users users) {
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	session.save(users);
	session.flush();
	tx.commit();
	session.close();
	}

	@Override
	public boolean updateUser(Users users) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(users);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteUser(Users users) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(session);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<Users> findAll() {
		Session session=sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		List<Users> userList=session.createQuery("select u from Users u").list();
		//tx.commit();
		return userList;
		

	}
	
	@Override
	//@Transactional
	public Users findUser(int id) {
		Session session = sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		Users users= session.find(Users.class, id);
		//tx.commit();
		return new Users();
	}
	/*
	@Override
	//@Transactional
	public List<String> findEmail(String email) {
		Session session= sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		List<String> useremail=session.createQuery("select u from Users u where u.email="+email).list();
		//tx.commit();
		return useremail;

	}

	@Override
	//@Transactional
	public List<String> findUserName() {
		Session session= sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		List<String> username=session.createQuery("select u.userName from Users u").list();
		//tx.commit();
		return username;
	}

	@Override
	//@Transactional
	public List<String> findPassword() {
		Session session= sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		List<String> userpassword=session.createQuery("select u.password from Users u").list();
		//tx.commit();
		return userpassword;
	}
	*/

}