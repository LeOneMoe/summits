package stud.summits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stud.summits.dao.SummitAlpDao;
import stud.summits.dao.SummitDao;
import stud.summits.exceptions.NotFoundException;
import stud.summits.model.SummitAlp;

import javax.validation.Valid;
import java.util.List;


@RestController
public class SummitAlpController {
    private final SummitAlpDao summitAlpDao;
    private final SummitDao summitDao;

    @Autowired
    public SummitAlpController(SummitAlpDao summitAlpDao, SummitDao summitDao) {
        this.summitAlpDao = summitAlpDao;
        this.summitDao = summitDao;
    }

    @GetMapping("summits/{summitId}/alps")
    public List<SummitAlp> findAllBySummitId(
            @PathVariable("summitId") Long summitId
    ) {
        return summitAlpDao.findBySummitId(summitId);
    }

    @PostMapping("summits/{summitId}/alps")
    public SummitAlp create(
            @PathVariable("summitId") Long summitId,
            @Valid @RequestBody SummitAlp summitAlp
    ) {
        return summitDao.findById(summitId).map(summit -> {
            summitAlp.setSummit(summit);
            return summitAlpDao.save(summitAlp);
        }).orElseThrow(() -> new NotFoundException("SummitId: " + summitId + " not found"));
    }

    @PutMapping("summits/{summitId}/alps/{alpId}")
    public SummitAlp update(
            @PathVariable("summitId") Long summitId,
            @PathVariable("alpId") Long alpId,
            @Valid @RequestBody SummitAlp summitAlpRequest
    ) {
        if (!summitDao.existsById(summitId)) {
            throw new NotFoundException("SummitId: " + summitId + " not found");
        }

        return summitAlpDao.findById(alpId).map(summitAlp -> {
            summitAlp.setAscentDate(summitAlpRequest.getAscentDate());
            summitAlp.setFirstName(summitAlpRequest.getFirstName());
            summitAlp.setLastName(summitAlpRequest.getLastName());
            summitAlp.setMiddleName(summitAlpRequest.getMiddleName());
            return summitAlpDao.save(summitAlp);
        }).orElseThrow(() -> new NotFoundException("NameId: " + alpId + " not found"));
    }

    @DeleteMapping("summits/{summitId}/alps/{alpId}")
    public ResponseEntity<?> delete(
            @PathVariable("summitId") Long summitId,
            @PathVariable("alpId") Long alpId
    ) {
        return summitAlpDao.findByIdAndSummitId(alpId, summitId).map(summitAlp -> {
            summitAlpDao.delete(summitAlp);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("SummitAlp not found with id " + alpId + " and SummitId " + summitId));
    }
}
