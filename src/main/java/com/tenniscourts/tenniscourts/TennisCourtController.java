package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("tennisCourt")
@Api(value = "TennisCourt")
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;

    @PutMapping("/addTennisCourt")
    @ApiOperation("Add a Tennis Court")
    public ResponseEntity<Void> addTennisCourt(@RequestBody CreateTennisCourtRequestDTO tennisCourtDTO) {
        return ResponseEntity.created(locationByEntity(tennisCourtService.addTennisCourt(tennisCourtDTO).getId())).build();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation("Find a Tennis Court")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(@PathVariable("id") Long tennisCourtId) throws Throwable {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    @GetMapping("/findWithSchedulesById/{id}")
    @ApiOperation("Find a Tennis Court with Schedules")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(@PathVariable Long tennisCourtId) throws Throwable {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
