package sopt.org.SecondSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sopt.org.SecondSeminar.domain.user.User;
import sopt.org.SecondSeminar.domain.post.Post;

import java.util.ArrayList;
@SpringBootApplication
public class SecondSeminarApplication {
	public static ArrayList<User> userList;
	public static ArrayList<Post> postList;

	public static void main(String[] args) {
		SpringApplication.run(SecondSeminarApplication.class, args);

		postList=new ArrayList<>();
		userList = new ArrayList<>();
	}
}
