package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController()
@RequestMapping("reservation")
@Api(value = "Reservation")
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    @PostMapping("book")
    @ApiOperation(value = "Book Reservation")
    public ResponseEntity<Void> bookReservation(@RequestBody CreateReservationRequestDTO createReservationRequestDTO) throws Throwable {
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }

    public ResponseEntity<ReservationDTO> findReservation(Long reservationId) throws Throwable {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    @PostMapping("cancel")
    @ApiOperation(value = "Cancel Reservations")
    public ResponseEntity<ReservationDTO> cancelReservation(Long reservationId) throws Throwable {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    @PostMapping("reschedule")
    @ApiOperation(value = "Reschedule Reservations")
    public ResponseEntity<ReservationDTO> rescheduleReservation(Long reservationId, Long scheduleId) throws Throwable {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}
