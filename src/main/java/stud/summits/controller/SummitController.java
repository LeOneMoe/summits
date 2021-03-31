package stud.summits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stud.summits.dao.SummitDao;
import stud.summits.dao.SummitNameDao;
import stud.summits.exceptions.NotFoundException;
import stud.summits.model.Summit;

import java.util.List;


@RestController
@RequestMapping("summits")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SummitController {
    private final SummitDao summitDao;

    @Autowired
    public SummitController(SummitDao summitDao, SummitNameDao summitNameDao) {
        this.summitDao = summitDao;
    }

    @GetMapping
    public List<Summit> getAll() {
        return summitDao.findAll();
    }

    @PostMapping
    public Summit create(@RequestBody Summit summit) {
        return summitDao.save(summit);
    }

    @PutMapping("{id}")
    public Summit update(
            @PathVariable Long id,
            @RequestBody Summit summitRequest
    ) {
        return summitDao.findById(id).map(summit -> {
            summit.setMainland(summitRequest.getMainland());
            summit.setLatitude(summitRequest.getLatitude());
            summit.setLongitude(summitRequest.getLongitude());
            summit.setHeight(summitRequest.getHeight());

            return summitDao.save(summit);
        }).orElseThrow(() -> new NotFoundException("SummitId: " + id + " not found"));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return summitDao.findById(id).map(summit -> {
            summitDao.delete(summit);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("SummitId: " + id + " not found"));
    }
}
