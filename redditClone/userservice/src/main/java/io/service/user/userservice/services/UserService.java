package io.service.user.userservice.services;

import io.service.user.userservice.core.utilities.results.DataResult;
import io.service.user.userservice.core.utilities.results.Result;
import io.service.user.userservice.entities.User;
import io.service.user.userservice.entities.dtos.userSaveRequestDto;

import java.util.List;

public interface UserService {
    Result add(userSaveRequestDto user);
    DataResult<List<String>> findByUsername(String username);

    DataResult<List<User>> findByUsernames(List<Integer> users);

    DataResult MainLatestPosts(int userid);

    DataResult getById(List<Integer> userId);
}
