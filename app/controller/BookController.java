package controller;

import com.google.inject.Inject;
import dto.BookDto;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.BookService;

import java.util.concurrent.CompletionStage;

public class BookController extends Controller {
    
    @Inject
    private BookService bookService;

    private static Counter daniel_api_requests = Counter.build().name("daniel_api_requests").help("Total daniel_api_requests.").register();
    
    public Result saveBook() {
        
        BookDto bookDto = Json.fromJson(request().body().asJson(), BookDto.class);
        daniel_api_requests.inc();
        if (bookService.saveBook(bookDto)) {
            return ok();
        }
        return internalServerError();
    }
    
    public CompletionStage<Result> findBookBySerial(Long serial) {

        daniel_api_requests.inc();
        return bookService.findBookBySerial(serial).thenApplyAsync((x) -> {
            return ok(Json.toJson(x));
        });
    }

    public CompletionStage<Result> findAllBooks() {

        daniel_api_requests.inc();
        return bookService.findAllBooks().thenApplyAsync((x) -> {
            return ok(Json.toJson(x));
        });
    }
    
}
