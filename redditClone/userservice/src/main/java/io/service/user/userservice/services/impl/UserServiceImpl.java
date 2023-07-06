package io.service.user.userservice.services.impl;

import io.service.user.userservice.core.utilities.results.DataResult;
import io.service.user.userservice.core.utilities.results.Result;
import io.service.user.userservice.dataAccess.UserDao;
import io.service.user.userservice.entities.User;
import io.service.user.userservice.entities.dtos.userSaveRequestDto;
import io.service.user.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public UserServiceImpl(UserDao userDao, KafkaTemplate kafkaTemplate){
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(userSaveRequestDto user) {
        User saveUser = User.builder()
                .username(user.username())
                .email(user.email())
                .password(user.password())
                .joined_at(LocalDateTime.now())
                .build();
        userDao.save(saveUser);
        return new Result(true,"User saved");
    }

    @Override
    public DataResult<List<String>> findByUsername(String username) {
        User returnUser = this.userDao.getByUsername(username);
        List<String> list = new ArrayList<>();
        list.add(returnUser.getUsername());
        list.add(returnUser.getEmail());
        list.add(returnUser.getJoined_at().toString().substring(0,10));
        // TODO: 5/31/2023 ADD FİELD
        return new DataResult<>(list,true,"Data Listelendi");
    }

    @Override
    public DataResult<List<User>> findByUsernames(List<Integer> users) {
        return new DataResult<List<User>>((List<User>) users.stream().map(n -> this.userDao.getByUserid(n)),true,"Data Listed");
    }

    @Override
    public DataResult MainLatestPosts(int userid) {
        List<List> arr = new ArrayList<>();
        arr.addAll(restTemplate.getForObject("http://localhost:8093/api/subreddit/MainLatestPosts?userid="+userid,List.class));

        List<String> usernames = new ArrayList<>();

        arr.get(0).forEach(i-> {
            if (i.getClass() == LinkedHashMap.class){
                usernames.add(userDao.getUsernameByUserid(((LinkedHashMap<String, Integer>) i).get("userid")));
            }
        });

        arr.add(usernames);

        return new DataResult<>(arr,true,"deneme");
    }

    @Override
    public DataResult getById(List<Integer> userId) {
        List<User> arr = new ArrayList<>();
        userId.forEach((n) -> arr.add(userDao.getDataByUserid(n)));
        return new DataResult<>(arr,true,"User Listed");
    }
}
