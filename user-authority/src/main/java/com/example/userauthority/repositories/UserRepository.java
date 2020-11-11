package com.example.userauthority.repositories;


import com.example.userauthority.domain.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {


    @Query(value="select * from Users u where u.usernmae = ?1",nativeQuery=true)
    Users findByUsername(String username);

    Users getById(Long id);
}
