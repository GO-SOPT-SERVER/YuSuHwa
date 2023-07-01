package sopt.org.FourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.dto.ApiResponse;
import sopt.org.FourthSeminar.config.jwt.JwtService;
import sopt.org.FourthSeminar.config.resolver.UserId;
import sopt.org.FourthSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.FourthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.external.client.aws.S3Service;
import sopt.org.FourthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final S3Service s3Service;
    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            //@RequestHeader("Authorization") String accessToken,
            @UserId Long userId,
            @ModelAttribute @Valid final BoardImageListRequestDto request
    ) {

        //boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)),request);
        List<String> boardThumbnailImageUrlList = s3Service.uploadImages(request.getBoardImages(), "board");
        boardThumbnailImageUrlList.forEach(url -> s3Service.deleteFile(url));
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}