
package com.example.demo;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {
	Exception e;
@Autowired
    ArticleRepository articleRepository;

// Get All Notes
    @GetMapping("/article")
    public List<Article> getAllNotes() {
        return articleRepository.findAll();
    }

// Create a new Article
    @PostMapping("/article")
    public Article createNote(@Valid @RequestBody Article article) throws Exception {
        return articleRepository.save(article);
    }

// Get a Single Note
    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable(value = "id") Long prodId) throws Exception {
        return articleRepository.findById(prodId)
                .orElseThrow(() -> new Exception(e));
    }
/*
// Update a Note
    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Article bookDetails) throws BookNotFoundException {

    	Article book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());

        Article updatedBook = bookRepository.save(book);

return updatedBook;
    }
*/
// Delete a Article
    @DeleteMapping("/article/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Long prodId) throws Exception {
    	Article article = articleRepository.findById(prodId)
                .orElseThrow(() -> new  Exception(e));

articleRepository.delete(article);

return ResponseEntity.ok().build();
    }
}
