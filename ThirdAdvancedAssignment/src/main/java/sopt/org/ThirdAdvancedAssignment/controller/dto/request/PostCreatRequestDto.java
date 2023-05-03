package sopt.org.ThirdAdvancedAssignment.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreatRequestDto {

    @NotBlank
    private String title;

    private String content;

    @NotNull
    private Long userId;
}
