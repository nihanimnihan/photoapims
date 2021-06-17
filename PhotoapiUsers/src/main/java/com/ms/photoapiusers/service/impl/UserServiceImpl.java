package com.ms.photoapiusers.service.impl;

import com.ms.photoapiusers.data.UserEntity;
import com.ms.photoapiusers.data.UserRepository;
import com.ms.photoapiusers.dto.UserDto;
import com.ms.photoapiusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        return mapper.map(userRepository.save(userEntity), UserDto.class);
    }
}
