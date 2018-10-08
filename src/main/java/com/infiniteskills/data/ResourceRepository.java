package com.infiniteskills.data;

import com.infiniteskills.data.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
    //this is our own method
    //spring will see findBy and create the select query for us
    public Resource findByName(String name);
}

//this repository has all the methods of JPA Repository
//if we want to restrict the usage of some of the methods,
//we can create our own interface
//@NoRepositoryBean will tell spring not to create a bean of it
//because we just want to inherit it

//example
//@NoRepositoryBean
//public interface ReadOnlyRepository<T,ID extends Serializable> extends Repository<T,ID>{
//T findOne(ID id);
//Iterable<T> findAll();

//then our ResourceRepository interface should extend ReadOnlyRepository and
//it will only have findOne and findAll methods
