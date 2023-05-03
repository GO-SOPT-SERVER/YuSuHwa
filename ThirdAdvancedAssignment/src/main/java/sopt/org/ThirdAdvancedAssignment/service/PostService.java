package sopt.org.ThirdAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.PostCreatRequestDto;
import sopt.org.ThirdAdvancedAssignment.domain.Post;
import sopt.org.ThirdAdvancedAssignment.domain.User;
import sopt.org.ThirdAdvancedAssignment.infrastructure.PostRepository;
import sopt.org.ThirdAdvancedAssignment.infrastructure.UserRepository;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Autowired
    public PostService(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository=postRepository;
    }
    @Transactional
    public Long creatPost(PostCreatRequestDto request){
        User user = userRepository.findById(request.getUserId());

       Post post = Post.builder()
               .title(request.getTitle())
               .content(request.getContent())
               .user(user)
               .build();

       postRepository.save(post);
       return post.getId();
    }

}
