package com.sparta.readinglog.entity;

import com.sparta.readinglog.dto.BookRequestDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String comment;

    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
    }
}