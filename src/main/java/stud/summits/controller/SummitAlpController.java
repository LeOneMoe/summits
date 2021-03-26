package stud.summits.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.summits.dao.SummitAlpDao;
import stud.summits.model.SummitAlp;

import java.util.List;


@RestController
@RequestMapping("summitAlp")
public class SummitAlpController {
    private final SummitAlpDao summitAlpDao;
    
    @Autowired
    public SummitAlpController(SummitAlpDao summitAlpDao) {
        this.summitAlpDao = summitAlpDao;
    }

    @GetMapping
    public List<SummitAlp> list() {
        return summitAlpDao.findAll();
    }

    @GetMapping("{id}")
    public SummitAlp getOne(@PathVariable("id") SummitAlp summitAlp) {
        return summitAlp;
    }

    @PostMapping
    public SummitAlp create(@RequestBody SummitAlp summitAlp) {
        return summitAlpDao.save(summitAlp);
    }

    @PutMapping("{id}")
    public SummitAlp update(
            @PathVariable("id") SummitAlp summitAlpFromDb,
            @RequestBody SummitAlp summitAlp
    ) {
        BeanUtils.copyProperties(summitAlp, summitAlpFromDb, "id");
        return summitAlpDao.save(summitAlpFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") SummitAlp summitAlp) {
        summitAlpDao.delete(summitAlp);
    }
}
