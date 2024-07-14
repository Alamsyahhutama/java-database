package alamsyahhutama.database;

import alamsyahhutama.database.entity.Comment;
import alamsyahhutama.database.repository.ComentRepository;
import alamsyahhutama.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private ComentRepository comentRepository;

    @BeforeEach
    void setUp() {
        comentRepository = new CommentRepositoryImpl();
    }
    @Test
    void testInsert() {
        Comment comment = new Comment("alamsyah@test.com", "hi");
        comentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }
    @Test
    void testFindById() {
        Comment comment = comentRepository.findById(402);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notFound = comentRepository.findById(10000000);
        Assertions.assertNull(notFound);
    }
    @Test
    void testFindAll() {
        List<Comment> comments = comentRepository.findAll();
        System.out.println(comments.size());
    }
    @Test
    void testFindByEmail() {
        List<Comment> comments = comentRepository.findAllByEmail("alamsyah@test.com");
        System.out.println(comments.size());
    }
}
