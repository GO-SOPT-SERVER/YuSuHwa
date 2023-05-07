package sopt.org.ThirdAdvancedAssignment.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.ThirdAdvancedAssignment.common.dto.ApiResponseDto;
import sopt.org.ThirdAdvancedAssignment.exception.ErrorStatus;
import java.sql.SQLIntegrityConstraintViolationException;
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    protected ApiResponseDto SQLIntegrityConstraintViolationException(final SQLIntegrityConstraintViolationException e){

        if (e.getMessage().contains("'user_id' cannot be null")){
            return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_UNVALID_USERID);
        }
        else if(e.getMessage().contains("Duplicate entry")){
            if (e.getMessage().contains("user.UK_ob8kqyqqgmefl0aco34akdtpe")) {
                return ApiResponseDto.error(ErrorStatus.CONFLICT_EMAIL_EXCEPTION);
            } else if (e.getMessage().contains("user.UK_n4swgcf30j6bmtb4l4cjryuym")) {
                return ApiResponseDto.error(ErrorStatus.CONFLICT_NICKNAME_EXCEPTION);
            }
        }


        return ApiResponseDto.error(ErrorStatus.VALIDATION_EXCEPTION);
    }



}