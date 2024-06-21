package com.bersoft.crudapplication.model.response;


import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(LocalDateTime date, List<String> messages) {
}
