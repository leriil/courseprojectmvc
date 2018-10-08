package com.infiniteskills.data.services;

import com.infiniteskills.data.ResourceRepository;
import com.infiniteskills.data.entities.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;

    public void save(Resource resource) {
        this.resourceRepository.save(resource);
    }
}
