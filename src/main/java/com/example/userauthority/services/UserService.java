package com.example.userauthority.services;



import com.example.userauthority.domain.Users;
import com.example.userauthority.dto.UsersDto;
import com.example.userauthority.exceptions.UsernameAlreadyExistsException;
import com.example.userauthority.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users saveUser (UsersDto usersDto){
        Users users = new Users();
        try{
            users.setUsername(usersDto.getUsername());
            users.setFullName(usersDto.getFullName());
            users.setPassword(bCryptPasswordEncoder.encode(usersDto.getPassword()));
            users.setConfirmPassword(usersDto.getConfirmPassword());
            return userRepository.save(users);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException( String.format("Username %s already exists", users.getUsername()));
        }
    }

}
