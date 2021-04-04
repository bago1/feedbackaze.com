package com.feedback.website.services;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.exceptions.UserNotFoundException;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.entities.UserEntity;
import com.feedback.website.repos.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserDto getOneUser(int id) {

        return userMapper.entityToDto(userRepo.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }

    public List<UserDto> listUsers() {
        return userMapper.entityListToDtoList(userRepo.findAll());
    }

    public void saveUser(UserDto userDto) {
        userRepo.save(userMapper.dtoToEntity(userDto));
    }

    public void updateUser(UserDto userDto, Integer id) {
        if (userRepo.findById(id).isEmpty()) throw new UserNotFoundException();
        //fetch fields as DTO and set to new Entity-type Object. Of course some values will be null
        //then Fetch the main Entity Object by id
        //then copy the only Not-Null fields to main Entity
        //save(Main Entity)
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        UserEntity existing = userRepo.findById(id).orElse(null);
        copyNonNullProperties(userEntity, existing);
        userRepo.save(existing);

    }


    public void deleteOneUser(int id) {

        //todo nie birbasa deletebyId ile orElseThrow islemir
        userRepo.findById(id).orElseThrow(UserNotFoundException::new);
        userRepo.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);

    }


}
