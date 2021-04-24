package com.api.lecturerscheduling.controller;

import com.amazonaws.Response;
import com.api.lecturerscheduling.dto.*;

import com.api.lecturerscheduling.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Login by user name and uid", description = "Login by user name and uid", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "There aren't notification"),
            @ApiResponse(responseCode = "501", description = "Not implement")})
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody UserDTO dto) {

        UserDTO userDTO = userService.login(dto);
        if(userDTO != null) {
            return new ResponseEntity(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }


    @Operation(summary = "Get all user", description = "Get all user expect admin role", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "501", description = "Not implement")})
    @GetMapping("/get-all-user")
    public List<UserInfoDTO> getAllUser() {
            return userService.getAllUser();
    }

    @Operation(summary = "Check token fcm", description = "Check token fcm", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "501", description = "Not implement")})
    @GetMapping("/send-token-fcm")
    public ResponseEntity checkTokenFcm(@RequestParam("tokenFcm")String tokenFcm){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
