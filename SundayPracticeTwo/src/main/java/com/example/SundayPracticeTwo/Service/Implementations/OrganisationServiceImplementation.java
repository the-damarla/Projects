package com.example.SundayPracticeTwo.Service.Implementations;

import com.example.SundayPracticeTwo.Dto.OrganisationDto;
import com.example.SundayPracticeTwo.Enity.Organisation;
import com.example.SundayPracticeTwo.Repository.OrganisationRepository;
import com.example.SundayPracticeTwo.Service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImplementation implements OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public Iterable<Organisation> findAll() {
        return organisationRepository.findAll();
    }

    @Override
    public void save(Organisation organisation) {
        organisationRepository.save(organisation);
    }

    @Override
    public Organisation select(Long id) {
        return organisationRepository.findById(id).get();
    }
}
