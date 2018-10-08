package com.infiniteskills.data.services;

import com.infiniteskills.data.ResourceRepository;
import com.infiniteskills.data.entities.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;

    public void save(Resource resource) {
        this.resourceRepository.save(resource);
        //it can also save a list of books
        //save either updates an entity if the values are changed
        // or inserts a new entity if we offer an Id which doesn't exist in
        //the datastore
    }
    public Resource findByName(String name){
        System.out.println(this.resourceRepository.findByName(name));
        return  this.resourceRepository.findByName(name);
    }
    public Optional<Resource> find(Long resourceId){
        return  this.resourceRepository.findById(resourceId);
    }
    public List<Resource> findResources (){
        return this.resourceRepository.findAll();
        //if we add new ArrayList<Long>(){{add(1L); add(2L);}}
        //inside findAll, we get only resources with these ids
        // (select in (?,?,?))
    }

    //REMOVING DATA
    //repository.delete(1L);
    //repository.delete(repository.findOne(1L));
    //repository.delete(repository.findAll(new ArrayList<Long>()
    // {{add(1L); add(2L);}}));
    //repository.deleteInBatch(repository.findAll(new ArrayList<Long>()
    // {{add(1L); add(2L);}}));
    //repository.deleteAll();
    //repository.deleteAllInBatch();
}
