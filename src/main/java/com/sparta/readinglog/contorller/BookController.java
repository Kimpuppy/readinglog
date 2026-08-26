package com.sparta.readinglog.contorller;

import com.sparta.readinglog.entity.Book;
import com.sparta.readinglog.dto.BookRequestDto;
import com.sparta.readinglog.dto.BookResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {
    private final Map<Long, Book> listBook = new HashMap<>();
    private Long currentId = 0L;

    @PostMapping("/books")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto) {
        var book = new Book(requestDto);

        // ID Setting
        book.setId(++currentId);
        listBook.put(book.getId(), book);

        var responseDto = new BookResponseDto(book);

        return responseDto;
    }

    @GetMapping("/books")
    public List<BookResponseDto> getBookList() {
        var listResponse = listBook.values().stream()
                .map(BookResponseDto::new).toList();

        return listResponse;
    }
}
