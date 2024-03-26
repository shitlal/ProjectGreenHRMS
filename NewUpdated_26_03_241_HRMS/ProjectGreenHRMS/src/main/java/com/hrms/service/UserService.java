package com.hrms.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.hrms.model.RecruitmentEntity;
import com.hrms.model.User;
import com.hrms.repository.UserRepository;
 
@Service
public class UserService{
 
    @Autowired
    private UserRepository userRepository;
 
    public String checkPassword(String userName)
	{String password=null;
    	User details = userRepository.findByUsername(userName) ;
    	if(details !=null) {
    		 password=details.getPassword();
    	}
        return password;
    }
}