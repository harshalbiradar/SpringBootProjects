package com.harshalit.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshalit.entity.City;
import com.harshalit.entity.Country;
import com.harshalit.entity.State;
import com.harshalit.entity.User;
import com.harshalit.repository.CityRepository;
import com.harshalit.repository.CountryRepositry;
import com.harshalit.repository.StateRepository;
import com.harshalit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository  userRepositry;
	
	@Autowired
	private CountryRepositry  countryRepositry;
	
	@Autowired
	private StateRepository  stateRepositry;
	
	@Autowired
	private CityRepository  cityRepositry;
	
	//Registration  page operations
	@Override 
	public Map<Integer, String> getCountry() {
		List<Country> countryList = countryRepositry.findAll();
		Map<Integer, String> countryMap = new HashMap<>();
		countryList.forEach(country->{
			countryMap.put(country.getCountryId(), country.getCountryName());
		});
		System.out.println("countryMap: "+countryMap);
		return countryMap;
		
	}


	@Override
	public Map<Integer, String> getState(Integer countryId) {
		List<State> stateList = stateRepositry.findByCountryId(countryId);
		Map<Integer, String> stateMap = new HashMap<>();
		stateList.forEach(state->{
			stateMap.put(state.getStateId(), state.getStateName());
		});
		System.out.println("stateMap: "+stateMap);
		return stateMap;
	}


	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		List<City> cityList = cityRepositry.findByStateId(stateId);
		Map<Integer, String> cityMap = new HashMap<>();
		cityList.forEach(city->{
			cityMap.put(city.getCityId(), city.getCityName());
		});
		System.out.println("cityMap: "+cityMap);
		return cityMap;
	}


	@Override
	public boolean registerUser(User user) {
		user.setPassword(passwordGenerator());
		user.setAccountStatus("LOCKED");
		User save = userRepositry.save(user);
		return save.getUserID()!= null;
	}


	private String passwordGenerator() {
		char[] password = new char[5];
		String alphaNumeric = "ABCDEFGHabcdefgh1234567890";
		Random randomPw = new Random();
		for(int i = 0; i<=5; i++) {
			password[i] = alphaNumeric.charAt(randomPw.nextInt(alphaNumeric.length()));
		}
		System.out.println("Random password: "+password.toString());
		return password.toString();
	}


	@Override
	public User userIsEmailUnique(String email) {
		User findByEmail = userRepositry.findByEmail(email);
		return findByEmail;
	}


	//login page operations
	
	@Override
	public String userSignIn(String email, String password) {
		User findByEmail = userIsEmailUnique(email);
		if(findByEmail != null) {
			User findByEmailAndPassword = userRepositry.findByEmailAndPassword(email, password);
			if(findByEmailAndPassword.getAccountStatus() != "LOCKED") {
				if(findByEmailAndPassword.getFirstName()!= null){
					return findByEmailAndPassword.getFirstName()+" you logged in successfully";
				}else {
					return "Please Enter correct password";
				}
			}
			else {
				return "Your account is locked";
			}
		}else {
			return "Email id is not registered plese enter valid email address";
		}
		
	}


	@Override
	public boolean checkTemporaryPassIsValid(String email, String temporaryPassword) {
		User userDetails = userRepositry.findByEmailAndPassword(email, temporaryPassword);
		return userDetails.getUserID()!=null;
	}


	@Override
	public boolean updatePasswordAndUnlockAcc(String email, String newPassword) {
		User userDetails = userRepositry.findByEmail(email);
		userDetails.setPassword(newPassword);
		userDetails.setAccountStatus("UNLOCKED");
		try {
			userRepositry.save(userDetails);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public String forgotPassword(String email) {
		User findByEmail = userRepositry.findByEmail(email);
		if(findByEmail!=null) {
			return findByEmail.getPassword();
		}
		return null;
	}


	
	
	
	
	

}
