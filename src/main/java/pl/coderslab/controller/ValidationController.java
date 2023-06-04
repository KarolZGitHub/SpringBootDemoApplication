package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@AllArgsConstructor
class ValidationController {

    private final Validator validator;
    private BookService bookService;

    @RequestMapping("/validate/{id}")
    String validateTest(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                log.error(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
            model.addAttribute("violations", violations);

            return "/violation/violations";
        } else {
            return "Validation status OK!";
        }
    }
}