package sopt.org.ThirdAdvancedAssignment.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdAdvancedAssignment.domain.Post;

public interface PostRepository extends Repository<Post, Long> {
    Post save(Post post);
    Post findById(Long id);
}
