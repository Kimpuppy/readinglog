package com.sparta.readinglog.dto;

import com.sparta.readinglog.entity.Book;
import lombok.*;

@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String comment;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.comment = book.getComment();
    }
}
