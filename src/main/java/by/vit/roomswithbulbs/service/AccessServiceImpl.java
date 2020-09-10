package by.vit.roomswithbulbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AccessServiceImpl implements AccessService {

    private final LocationService locationService;

    @Autowired
    public AccessServiceImpl(final LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public boolean check(final String id, final HttpServletRequest request) {
        return false;
    }

}
