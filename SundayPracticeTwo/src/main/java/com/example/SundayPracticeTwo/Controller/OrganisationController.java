package com.example.SundayPracticeTwo.Controller;

import com.example.SundayPracticeTwo.Dto.OrganisationDto;
import com.example.SundayPracticeTwo.Enity.Organisation;
import com.example.SundayPracticeTwo.Service.OrganisationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping(value = "/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;

    @GetMapping(value = "/{id}")
    OrganisationDto select(@PathVariable("id") Long id)
    {
        Organisation organisation = organisationService.select(id);
        OrganisationDto organisationDto = new OrganisationDto();
        BeanUtils.copyProperties(organisation,organisationDto);
        return organisationDto;
    }

    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST})
    void save(@RequestBody OrganisationDto organisationDto)
    {
        Organisation organisation = new Organisation();
        BeanUtils.copyProperties(organisationDto, organisation);
        organisationService.save(organisation);
    }

    @GetMapping(value = "/count")
    int countOfOrganisation()
    {
        Iterable<Organisation> organisations = organisationService.findAll();
        int sum = 0;
        for(Organisation org:organisations)sum++;
        return sum;
    }

    @GetMapping(value = "/all")
    Iterable<Organisation> findAll()
    {
        return organisationService.findAll();
    }
}
