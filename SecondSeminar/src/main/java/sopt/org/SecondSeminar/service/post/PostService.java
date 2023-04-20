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

        // +) 알았다. 이런 이유였구만!!!!!!!
        //아래의 코드는 ArrayList의 정의, 선언 파일중 일부입니다.

        /*
        * public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     *
        public int indexOf(Object o) {
            return indexOfRange(o, 0, size);
        }

        int indexOfRange(Object o, int start, int end) {
            Object[] es = elementData;
            if (o == null) {
                for (int i = start; i < end; i++) {
                    if (es[i] == null) {
                        return i;
                    }
                }
            } else {
                for (int i = start; i < end; i++) {
                    if (o.equals(es[i])) {
                        return i;
                    }
                }
            }
            return -1;
        }
        */


        // 내가 구글링했을때는 ArrayList의 '원소'의 equals를 쓴다고 봤는데
        // 정확한 코드를 까보니 매개변수로 들어오는 객체의 equals를 쓰는 것이었음!!

        // 즉 User의 equals 자체가 실행이 안된것은 매개변수로 String을 주엇기때문에
        // String 의 equals가 실행된것!

        // contains와 indexOf의 로직을 그대로 쓰려면
        // 1. User의 equals 오버라이딩
        // 2. User 생성자 오버로딩(name 만으로 비교용 임시객체만들도록) <- 솔직히 이부분이 젤 짱나서 결국 이로직 안씀
        // 3. userList.indexOf(new User(이름)) 으로 User의 equals가 실행되게 하기
        // 위의 3가지 단계를 써야하는 데 너무 번잡스러워서 걍 안쓸래요 ㅅㄱ!


        /*


        if(!userList.contains(new User(request.getUserName()))){
            return new Long(-999);
        }
        //받아온 request 데이터를 토대로 실제 글 생성
        Post newPost = new Post(
                request.getTitle(),
                request.getContent(),
                userList.get(userList.indexOf(request.getUserName())
        );

*/

        //그냥 원시적으로 반복문 돌릴께요 ㅇㄴ

        User postUser;
        for (User user : userList){
            // 유저가 존재할때
            if(user.getName().equals(request.getUserName())){
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
