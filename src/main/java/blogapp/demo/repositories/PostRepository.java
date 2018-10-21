package blogapp.demo.repositories;


import blogapp.demo.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    List<Post>findAllById(Long id);

}
