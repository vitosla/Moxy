package com.vitos.moxy.mvp.models;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Victor on 28.05.2017.
 */

public class UserMapper {

    public User map(UserDTO dto) {
        User item = new User();
        item.setId(dto.getId());
        item.setProvider(dto.getProvider());
        item.setEmail(dto.getEmail());
        item.setPassword(dto.getPassword());
        item.setData(dto.getData());
        item.setThumb(dto.getThumb());
        item.setImage(dto.getImage());
        return item;
    }

    public UserDTO map(User user) {
        UserDTO item = new UserDTO();
        item.setId(user.getId());
        item.setProvider(user.getProvider());
        item.setEmail(user.getEmail());
        item.setPassword(user.getPassword());
        item.setData(user.getData());
        item.setThumb(user.getThumb());
        item.setImage(user.getImage());
        return item;
    }

    public List<User> call(List<UserDTO> dtoList) {

        if (dtoList == null)
            return new ArrayList<>();

        return Observable
                .from(dtoList)
                .map(this::map)
                .toList()
                .toBlocking()
                .first();
    }
}