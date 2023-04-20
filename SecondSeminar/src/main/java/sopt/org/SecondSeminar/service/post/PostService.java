package sopt.org.SecondSeminar.service.post;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRegisterRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.domain.user.User;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;
@Service
public class PostService {
    public Long register(PostRegisterRequestDto request){

        //contains 메소드와 indexOf 메소드르 실행할때 arrayList의 원소객체의 euqals 메소드르 실행한다고 알고있는데
        // 왜인지 실행이 안됨......
        /*
        if(!userList.contains(request.getUserName())){
            return new Long(-999);
        }
        //받아온 request 데이터를 토대로 실제 글 생성
        Post newPost = new Post(
                request.getTitle(),
                request.getContent(),
                userList.get(userList.indexOf(request.getUserName()))
        );
        */

        //그냥 원시적으로 반복문 돌릴께요 ㅇㄴ

        User postUser;
        for (User user : userList){
            // 유저가 존재할때
            if(user.equals(request.getUserName())){
                postUser=user;


                Post newPost = new Post(
                        request.getTitle(),
                        request.getContent(),
                        postUser
                );

                //db? 에 저장
                postList.add(newPost);
                newPost.setId((long) postList.size());

                //저장한 아이디 값 반환
                return newPost.getId();

            }
        }
        return new Long(-999);


    }

    public Post getPostById(Long postId){
        return postList.get(postId.intValue() -1);
    }

    public Post getPostByTitle(String title){
        for ( Post p : postList){
            if(p.getTitle().contains(title)){
                return p;
            }
        }
        return null;
    }

    }
