package com.example.demo.tempInf.BeanValid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    @Min(1)
    private int adminId;

    @NotEmpty(message = "startTime 은 비어있을 수 없습니다")
    private String startTime;

    @NotEmpty(message = "endTime 은 비어있을 수 없습니다")
    private String endTime;

    @NotNull(message = "messahe는 비어있을 수 업습니다")
    private String message;


}
