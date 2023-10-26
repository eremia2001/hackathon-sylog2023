package com.projectmanagementservice.persistence.service;

import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.ImageEntity;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.repository.ImageEntityRepository;
import com.projectmanagementservice.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageEntityRepository imageEntityRepository;

    public List<ImageEntity> findAll(){
        return imageEntityRepository.findAll();
    }

    public ImageEntity findById(Long id){
        return imageEntityRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Image with ID " + id + " not found!"));
    }

    public ImageEntity save(ImageEntity imgEntity) {
        return imageEntityRepository.save(imgEntity);
    }
}
