package com.example.SundayPracticeTwo.Repository;

import com.example.SundayPracticeTwo.Enity.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends CrudRepository<Organisation,Long> {
}
