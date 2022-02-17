package com.ilkerguldali.boredapp.service.imp;

import com.ilkerguldali.boredapp.dto.ActivityDTO;
import com.ilkerguldali.boredapp.model.Activity;
import com.ilkerguldali.boredapp.repository.ActivityRepository;
import com.ilkerguldali.boredapp.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Configuration
public class ActivityServiceImp implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ActivityDTO> getAllActivity() {
        return activityRepository.findAll()
                .stream().map(activity -> modelMapper.map(activity, ActivityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }
}
