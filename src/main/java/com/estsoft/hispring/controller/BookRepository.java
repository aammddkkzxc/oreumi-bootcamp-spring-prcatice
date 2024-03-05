package com.estsoft.hispring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private Map<String, BookDTO> bookMap;

    public BookRepository() {
        bookMap = new HashMap<>();
        BookDTO book1 = new BookDTO("123", "오늘도 개발자가 안된다고 말했다", "기획자");
        BookDTO book2 = new BookDTO("456", "객체 지향의 원리와 이해", "조영호");
        bookMap.put(book1.getId(), book1);
        bookMap.put(book1.getId(), book2);
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        for(Map.Entry<String, BookDTO> book : bookMap.entrySet()) {
            bookList.add(book.getValue());
        }
        return bookList;
    }

    public void addBook(BookDTO bookDTO) {
        bookMap.put(bookDTO.getId(), bookDTO);
    }

    public BookDTO findBook(String id) {
        return bookMap.get(id);
    }
}
