package sopt.org.SecondSeminar.domain.user;


import lombok.Getter; //자동 getter


@Getter
public class User {
    private long id;
    private String gender;
    private String name;
    private String contact;

    private int age;
    public User(String gender, String name, String contact, int age) {
        this.gender = gender;
        this.name = name;
        this.contact = contact;
        this.age = age;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "gender: " + this.gender + "\n" +
                "name: " + this.name + "\n" +
                "contact: " + this.contact + "\n" +
                "age: " + this.age;
    }

    //왜 재정의하느냐....
    // List의 contains() 메소드와 indexOf() 메소드는 List안에 값이 같으면 true를 리턴하는데
    // 이때 '값이 같으면'이 List안의 객체의 equals 메소드를 실행시켜 확인하기 때문
    @Override
    public boolean equals(Object o){
        System.out.println("1단계");
        if(o instanceof String && this.name.equals(o) ){
            System.out.println("2단계");
            return true;

        }
        return false;
    }
}
