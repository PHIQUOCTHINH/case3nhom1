package com.example.demo12.service.impl;

import com.example.demo12.DAO.PublishingCompanyRepository;
import com.example.demo12.model.PublishingCompany;
import com.example.demo12.model.User;
import com.example.demo12.service.ICRUDService;

import java.util.ArrayList;

public class PublishingCompanyService implements ICRUDService<PublishingCompany> {
    PublishingCompanyRepository publishingCompanyRepository = new PublishingCompanyRepository();
    @Override
    public PublishingCompany findById(int id) {
        return publishingCompanyRepository.findById(id);
    }

    @Override
    public ArrayList<PublishingCompany> findAll() {
        return publishingCompanyRepository.findAll();
    }

    @Override
    public void create(PublishingCompany publishingCompany) {
        publishingCompanyRepository.create(publishingCompany);
    }

    @Override
    public void update(PublishingCompany publishingCompany) {
        publishingCompanyRepository.update(publishingCompany);
    }

    @Override
    public void deleteById(int id) {
        publishingCompanyRepository.deleteById(id);
    }
}
