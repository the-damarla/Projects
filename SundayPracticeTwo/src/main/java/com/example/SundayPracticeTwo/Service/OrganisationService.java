package com.example.SundayPracticeTwo.Service;

import com.example.SundayPracticeTwo.Enity.Organisation;

public interface OrganisationService {
    Organisation select(Long id);
    void save(Organisation organisation);
    Iterable<Organisation> findAll();
}
