package sopt.org.firstSeminar.OOP.classAndInstance;

//생성자를 사용하지 않는 편의점 객체예시

/*
public class ConvenienceStore {
    //브랜드
    private String brand;
    //주소
    private String address;
    //직원수
    private int staffCount;

    //총 매출
    private int totalSales;

    public void addStaffCount(){
        staffCount++;
    }

    public int getStaffCount(){
        return staffCount;
    }

    public void addTotalSales(){
        totalSales++;
    }

    public int getTotalSales(){
        return totalSales;
    }

    public void initTotalSales(){
        totalSales=0;
    }

    public void printConvenienceStoreInfo() {
        System.out.println("편의점 브랜드: " + brand);
        System.out.println("편의점 주소: " + address);
        System.out.println("편의점 직원 수: " + staffCount);
        System.out.println("편의점 총 매출 : " + totalSales);
    }


    public static void main(String[] args){
        ConvenienceStore familyMart = new ConvenienceStore();

        //복잡허다... 그나마 같은 클래스의 메소드라 프라이빗에 접근가능해서 다행
        familyMart.brand="Family Mart";
        familyMart.address = "^*^";
        familyMart.staffCount=6;

        familyMart.initTotalSales();
        familyMart.addStaffCount();
        familyMart.addTotalSales();

        familyMart.printConvenienceStoreInfo();
    }
}
*/

// 생성자 선언을 해준 편의점객체
public class ConvenienceStore {
    //브랜드
    private String brand;
    //주소
    private String address;
    //직원수
    private int staffCount;

    //총 매출
    private int totalSales;

    public ConvenienceStore(String brand, String address, int staffCount, int totalSales){
        this.brand=brand;
        this.address=address;
        this.staffCount=staffCount;
        this.totalSales=totalSales;
    }

    public void addStaffCount(){
        staffCount++;
    }

    public int getStaffCount(){
        return staffCount;
    }

    public void addTotalSales(){
        totalSales++;
    }

    public int getTotalSales(){
        return totalSales;
    }


    public void printConvenienceStoreInfo() {
        System.out.println("편의점 브랜드: " + brand);
        System.out.println("편의점 주소: " + address);
        System.out.println("편의점 직원 수: " + staffCount);
        System.out.println("편의점 총 매출 : " + totalSales);
    }


    public static void main(String[] args){
        //깔끔 good
        ConvenienceStore familyMart = new ConvenienceStore("7-11","gondDUK",4,1234);

        familyMart.addStaffCount();
        familyMart.addTotalSales();

        familyMart.printConvenienceStoreInfo();
    }
}
