package com.example.demo1;


import com.example.demo1.controller.DevelopersController;
import com.example.demo1.entity.Developer;
import com.example.demo1.repository.DeveloperRepository;
import com.example.demo1.repository.SkillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DevelopersControllerTest {

    @InjectMocks
    private DevelopersController developersController;

    @Mock
    private DeveloperRepository repository;

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private Model model;
    private DevelopersController yourController;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeveloper() {
        Long id = 1L;
        Developer developer = new Developer();
        developer.setId(id);
        when(repository.findOne(id)).thenReturn(developer);
        when(skillRepository.findAll()).thenReturn(Collections.emptyList());
        String viewName = developersController.developer(id, model);
        assertEquals("developer", viewName);
        verify(repository, times(1)).findOne(id);
        verify(model).addAttribute("developer", developer);
        verify(model).addAttribute("skills", Collections.emptyList());
        verify(skillRepository, times(1)).findAll();
    }
    @Test
    public void testDevelopersList() {
        List<Developer> developers = new ArrayList<>();
        when(repository.findAll()).thenReturn(developers);
        String viewName = developersController.developersList(model);
        assertEquals("developers", viewName);
        verify(model).addAttribute("developers", developers);
        verify(repository, times(1)).findAll();
    }

   /* @Test
    public void testDevelopersAdd() {
        String email = "test@example.com";
        String firstName = "John";
        String lastName = "Doe";
        Developer newDeveloper = new Developer();
        newDeveloper.setEmail(email);
        newDeveloper.setFirstName(firstName);
        newDeveloper.setLastName(lastName);
        when(repository.save(any(Developer.class))).thenReturn(newDeveloper);
        when(skillRepository.findAll()).thenReturn(Collections.emptyList());
        String redirectUrl = developersController.developersAdd(email, firstName, lastName, model);
        assertEquals("redirect:/developer/" + newDeveloper.getId(), redirectUrl);
        verify(repository, times(1)).save(any(Developer.class));
        verify(model).addAttribute("developer", newDeveloper);
        verify(model).addAttribute("skills", Collections.emptyList());
        verify(skillRepository, times(1)).findAll();
    }
*/

}
