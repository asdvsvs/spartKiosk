import java.util.HashMap;
import java.util.Scanner;

public class Menu {
     String menuName;
     String explanation;
     static int menuNum;
     int menuId=0;

    static HashMap<Integer, Menu> menu = new HashMap<Integer, Menu>();


    public void addMenu(int menuId,String menuName, String explanation){
        this.menuId = menuId;
        this.menuName = menuName;
        this.explanation = explanation;
    }
    public static void numError(){
        try {
            System.out.println("##번호 입력 오류!##");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setMenu(){
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();
        Menu menu4 = new Menu();
        Menu menu5 = new Menu();
        menu1.addMenu(++menuId,"피자   ", "스파르타식 피자 (옵션 선택)");
        menu2.addMenu(++menuId,"사이드  ", "스파르타식 사이드");
        menu3.addMenu(++menuId,"음료   ", "스파르타식 음료");
        menu4.addMenu(++menuId,"주문   ", "장바구니를 확인 후 주문합니다.");
        menu5.addMenu(++menuId,"취소   ", "진행중인 주문을 취소합니다.");
        menu.put(1, menu1);
        menu.put(2, menu2);
        menu.put(3, menu3);
        menu.put(4, menu4);
        menu.put(5, menu5);
    }

    public void deleteMenu(){
        Menu.menuNum = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[삭제할 스파르타 메뉴 ]");
        for (int i=1; i<=3;i++){
            System.out.printf("%d %s  |  %s\n", menuNum++,menu.get(i).menuName,menu.get(i).explanation);
        }
        System.out.print("메뉴 번호 입력 : ");
        int num;
        while (true){
            num =sc.nextInt();
            if(num<1 || 3<num) System.out.println("1,2,3 중 입력");
            else break;
        }
        Product product = new Product();
        product.deleteProduct(num);
    }
    public void menuScreen(){
        Menu.menuNum = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("\"스파르타 피자 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ 스파르타 메뉴 ]");
        for (int i=1; i<menu.size()+1;i++){
            if(i==4) System.out.println("\n[ 오더 메뉴 ]");
            System.out.printf("%d %s  |  %s\n", menuNum++,menu.get(i).menuName,menu.get(i).explanation);
        }
        System.out.println();
        System.out.println("(0.총 판매), (6.상품 생성), (7.상품 삭제) (-1. 키오스크 끄기)");
        System.out.print("메뉴 번호 입력 : ");

    }

}
