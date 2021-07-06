package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public Guest createGuest(CreateGuestRequestDTO guest) {
        return guestRepository.save(guestMapper.map(guest));
    }

    public List<GuestDTO> findByIdOrName(Long guestId, String guestName) {
        return guestMapper.map(guestRepository.findAll(Example.of(Guest.builder()
                    .id(guestId)
                    .name(guestName)
                    .build(),
                        ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withMatcher("name", contains()))));
    }

    public GuestDTO updateGuest(GuestDTO guest) throws Throwable {
        if (!guestRepository.existsById(guest.getId()))
            throw new EntityNotFoundException("Guest not found.");
        return guestMapper.map(guestRepository.save(guestMapper.map(guest)));
    }

    public List<GuestDTO> findAll() {
        return guestMapper.map(guestRepository.findAll());
    }

    public boolean deleteGuest(Long guestId) throws Throwable {
        if (guestRepository.existsById(guestId)) {
            guestRepository.deleteById(guestId);
            return true;
        } else
            return false;
    }

}
