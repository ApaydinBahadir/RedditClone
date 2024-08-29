package io.service.user.userservice.entities.dtos;

public record userSaveRequestDto(String username,
                                 String email,
                                 String password) {

}
