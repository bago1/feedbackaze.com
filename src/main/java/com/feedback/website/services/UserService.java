package com.feedback.website.services;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.models.User;
import com.feedback.website.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;


    public UserDto getOneUser(int id) {

        return userMapper.entityToDto(userRepo.findById(id).orElse(null));
        //todo try catch - message
    }

    public List<UserDto> listUsers() {
        return userMapper.entityListToDtoList(userRepo.findAll());
    }


    public void saveUser(UserDto userDto) {

        UserDto userDto1 = UserDto.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .ad(userDto.getAd())
                .soyad(userDto.getSoyad())
                .build();

        userRepo.save(userMapper.dtoToEntity(userDto1));
    }

    public List<UserDto> deleteAllUsers() {
         userRepo.deleteAll();
        return listUsers();
    }


    public void deleteOneUser(int id) {
        userRepo.deleteById(id);
    }


    public void updateUser(UserDto userDto, Integer id) throws Exception{
        if (getOneUser(id) == null) {
            throw new Exception("Not found");
        } else {

            //is prinsipi - requestden gelen fieldleri yeni object yaradib set edir
            //daha sonra esas entityni db-dan cekir,
            //requestden gelen obj-nun yalniz null olmayan fieldlerini esas entity-nin objectine copy edir
            // esas entityni save edir

            //fetch fields as DTO and set to new Entity-type Object. Of course some values will be null
            //then Fetch the main Entity Object by id
            //then copy the only Not-Null fields to main Entity
            //save(Main Entity)
            User user = userMapper.dtoToEntity(userDto);

            User existing = userRepo.findById(id).orElse(null);

            copyNonNullProperties(user, existing);

            userRepo.save(existing);

        }
    }
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);

    }
}
