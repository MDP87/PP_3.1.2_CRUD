package ru.crud.crud_312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crud.crud_312.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
