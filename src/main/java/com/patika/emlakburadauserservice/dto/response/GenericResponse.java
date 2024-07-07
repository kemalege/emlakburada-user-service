package com.patika.emlakburadauserservice.dto.response;

import com.patika.emlakburadauserservice.constants.EmlakBuradaConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {

    private String status;
    private HttpStatus httpStatus;
    private T data;
    private T error;

    public static GenericResponse<ExceptionResponse> failed(String message) {
        return GenericResponse.<ExceptionResponse>builder()
                .status(EmlakBuradaConstants.FAILED)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .error(new ExceptionResponse(message))
                .build();
    }

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .status(EmlakBuradaConstants.SUCCESS)
                .httpStatus(HttpStatus.OK)
                .data(data)
                .build();
    }

}
