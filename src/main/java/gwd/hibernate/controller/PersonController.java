package gwd.hibernate.controller;

import gwd.hibernate.model.Person;
import gwd.hibernate.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String show(ModelMap modelMap){
        modelMap.put("person",new Person());
        return "form";
    }

    @PostMapping("/")
    public String create(@Valid Person person,
                         BindingResult bindingResult){
        /*
            Person person = new Person();
            person.setAge(age);
            person.setName(name);
         */

        if ( bindingResult.hasErrors()){
            return "form";
        }
        else {
            personRepository.save(person); // zapisuje do bazy danych
            return "redirect:/all";
        }
    }

    @GetMapping("/all")
    public String findAll(ModelMap modelMap){
        modelMap.put("people",personRepository.findAllSortById());
        return "all";
    }

    @GetMapping("/eighteens")
    public String getEighteens(ModelMap modelMap){
        modelMap.put("people",personRepository.
                findByMyAge(18));
        return "all";
    }


    @GetMapping("people/{id}/delete")
    public String delete(@PathVariable Integer id,
                         RedirectAttributes redirectAttributes){
        Person person = personRepository.findById(id).get();

        personRepository.deleteById(id);
        // redirect przechodzi do url all i
        // czyści parametry


        redirectAttributes.addFlashAttribute("message","Usunięto zawodnika " +
                person.getName()+ " z bazy danych");

        return "redirect:/all";
    }

    @GetMapping("people/{id}/update")
    public String update(@PathVariable Integer id,ModelMap modelMap){
        Person person = personRepository.findById(id).get();
        modelMap.put("person",person);
        return "form";
    }


    @PostMapping("/people/search")
    public String search(@RequestParam String option,
                         ModelMap modelMap){

        try {
            Integer age = Integer.parseInt(option);
            modelMap.put("people", personRepository.findByNameOrAge(option,age));
        }
        catch (NumberFormatException e){
            modelMap.put("people", personRepository.findByNameOrAge(option,0));
        }

        return "all";
    }

}