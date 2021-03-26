package stud.summits.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.summits.dao.SummitNameDao;
import stud.summits.model.SummitName;

import java.util.List;


@RestController
@RequestMapping("summitName")
public class SummitNameController {
    private final SummitNameDao summitNameDao;
    
    @Autowired
    public SummitNameController(SummitNameDao summitNameDao) {
        this.summitNameDao = summitNameDao;
    }

    @GetMapping
    public List<SummitName> list() {
        return summitNameDao.findAll();
    }

    @GetMapping("{id}")
    public SummitName getOne(@PathVariable("id") SummitName summitName) {
        return summitName;
    }

    @PostMapping
    public SummitName create(@RequestBody SummitName summitName) {
        return summitNameDao.save(summitName);
    }

    @PutMapping("{id}")
    public SummitName update(
            @PathVariable("id") SummitName summitNameFromDb,
            @RequestBody SummitName summitName
    ) {
        BeanUtils.copyProperties(summitName, summitNameFromDb, "id");
        return summitNameDao.save(summitNameFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") SummitName summitName) {
        summitNameDao.delete(summitName);
    }
}
