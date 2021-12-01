package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends CrudRepository<User,Long> {

}
