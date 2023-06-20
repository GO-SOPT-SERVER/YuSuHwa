package sopt.org.FourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.dto.ApiResponse;
import sopt.org.FourthSeminar.config.jwt.JwtService;
import sopt.org.FourthSeminar.config.resolver.UserId;
import sopt.org.FourthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            //@RequestHeader("Authorization") String accessToken,
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        //boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)),request);
        boardService.create(userId,request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}