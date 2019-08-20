package repository;

import com.google.inject.ImplementedBy;
import entity.BookEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@ImplementedBy(JPABookRepository.class)
public interface BookRepository {
    
    CompletableFuture<BookEntity> findBookBySerial(Long serial);
    
    void save(BookEntity bookEntity);

    CompletableFuture<List<BookEntity>> findAllBooks();
}
