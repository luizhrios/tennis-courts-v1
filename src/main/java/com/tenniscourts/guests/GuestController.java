package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.reservations.ReservationDTO;
import com.tenniscourts.reservations.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("guest")
@Api(value = "Guest")
public class GuestController extends BaseRestController {

    private final GuestService guestService;

    @PutMapping("create")
    @ApiOperation(value = "Create Guest")
    public ResponseEntity<Void> createGuest(@RequestBody CreateGuestRequestDTO guest) {
        return ResponseEntity.created(locationByEntity(guestService.createGuest(guest).getId())).build();
    }

    @PatchMapping(path = "/update")
    @ApiOperation(value = "Update Guest")
    public ResponseEntity<GuestDTO> updateGuest(@RequestBody GuestDTO guest) throws Throwable {
        return ResponseEntity.ok(guestService.updateGuest(guest));
    }

    @PostMapping("findByIdOrName")
    @ApiOperation(value = "Find Guests")
    public ResponseEntity<List<GuestDTO>> findGuest(Long guestId, String guestName) {
        return ResponseEntity.ok(guestService.findByIdOrName(guestId, guestName));
    }

    @PostMapping("getAll")
    @ApiOperation(value = "Get Guests")
    public ResponseEntity<List<GuestDTO>> getAllGuests() throws Throwable {
        return ResponseEntity.ok(guestService.findAll());
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "Delete Guest")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) throws Throwable {
        return guestService.deleteGuest(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
