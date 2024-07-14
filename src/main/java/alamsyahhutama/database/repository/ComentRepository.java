package alamsyahhutama.database.repository;

import alamsyahhutama.database.entity.Comment;

import java.util.List;

public interface ComentRepository {

    void insert (Comment comment);

    Comment findById (Integer id);

    List<Comment> findAll ();

    List<Comment> findAllByEmail (String email);

}
