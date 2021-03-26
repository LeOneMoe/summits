package stud.summits.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.summits.model.Summit;
import stud.summits.dao.SummitDao;

import java.util.List;

@RestController
@RequestMapping("summit")
public class SummitController {
    private final SummitDao summitDao;

    @Autowired
    public SummitController(SummitDao summitDao) {
        this.summitDao = summitDao;
    }

    @GetMapping
    public List<Summit> list() {
        return summitDao.findAll();
    }

    @GetMapping("{id}")
    public Summit getOne(@PathVariable("id") Summit summit) {
        return summit;
    }

    @PostMapping
    public Summit create(@RequestBody Summit summit) {
        return summitDao.save(summit);
    }

    @PutMapping("{id}")
    public Summit update(
            @PathVariable("id") Summit summitFromDb,
            @RequestBody Summit summit
    ) {
        BeanUtils.copyProperties(summit, summitFromDb, "id");
        return summitDao.save(summitFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Summit summit) {
        summitDao.delete(summit);
    }
}