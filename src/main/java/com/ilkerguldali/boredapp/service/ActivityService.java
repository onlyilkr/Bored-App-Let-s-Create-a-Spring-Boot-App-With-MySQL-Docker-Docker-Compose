package com.ilkerguldali.boredapp.service;

import com.ilkerguldali.boredapp.dto.ActivityDTO;
import com.ilkerguldali.boredapp.model.Activity;

import java.util.List;

public interface ActivityService {
    List<ActivityDTO> getAllActivity();
    Activity addActivity(Activity activity);
}
