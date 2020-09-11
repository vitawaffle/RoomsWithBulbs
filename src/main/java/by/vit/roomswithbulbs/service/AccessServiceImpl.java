package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Access service implementation.
 *
 * @author Vitaly Lobatsevich
 */
@Service
public class AccessServiceImpl implements AccessService {

    /** Room repository. */
    private final RoomRepository roomRepository;

    /** Location service. */
    private final LocationService locationService;

    @Autowired
    public AccessServiceImpl(final RoomRepository roomRepository, final LocationService locationService) {
        this.roomRepository = roomRepository;
        this.locationService = locationService;
    }

    @Override
    public Boolean checkByRoomId(final String id, final String ip) {
        final Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            return true;
        }
        return locationService.getCountryCodeByIp(ip).equals(room.getCountry().getAlpha2());
    }

}
