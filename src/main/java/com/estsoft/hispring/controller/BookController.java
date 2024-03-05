package com.estsoft.hispring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String home(Model model) {
        List<BookDTO> bookList = bookRepository.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "bookManager";
    }

    @PostMapping("/books")
    public String saveBook(@RequestParam("id") String id,
                           @RequestParam("name") String name,
                           @RequestParam("author") String author) {
        bookRepository.addBook(new BookDTO(id, name, author));

        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable("id") String isbn, Model model) {
        log.info("isbn + = " + isbn);
        model.addAttribute("book",bookRepository.findBook(isbn));
        return "bookDetail";
    }
}
