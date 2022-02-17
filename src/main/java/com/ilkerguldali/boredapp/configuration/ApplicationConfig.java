package com.ilkerguldali.boredapp.configuration;

import com.ilkerguldali.boredapp.dto.ActivityDTO;
import com.ilkerguldali.boredapp.model.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Activity.class, ActivityDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Activity::getTitle, ActivityDTO::setActivity);
                });
        modelMapper.typeMap(ActivityDTO.class, Activity.class)
                .addMappings(mapper -> {
                    mapper.map(ActivityDTO::getActivity, Activity::setTitle);
                });
        return modelMapper;
    }
}