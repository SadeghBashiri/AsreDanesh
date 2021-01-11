package com.asredanesh.demo.repositories;

import com.asredanesh.demo.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Modifying
    @Transactional
    @Query("select count(c) from Contact c where c.github = ?1")
    Integer countContactByGithub(String github);

//    @Modifying
//    @Transactional
//    @Query(value = "select c from Contact c where c.name = '%name%' or c.email = '%email%'or c.phoneNumber = '%phoneNumber%'")
//    List<Contact> findByAllColumns(
//            @Param("name") String name
//            , @Param("email") String email
//            , @Param("phoneNumber") String phoneNumber
////            , Pageable pageable
//    );

    List<Contact> findByNameOrEmailOrPhoneNumberOrGithub(String name, String email, String phoneNumber, String github);
}
