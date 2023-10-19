import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Menu.menuNum = 1;
            System.out.println("---------------------------------------------------");
            System.out.println("\"스파르타 피자 에 오신걸 환영합니다.\"");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            System.out.println("[ 스파르타 메뉴 ]");
            Menu menu1 = new Menu("피자   ", "스파르타식 피자 (옵션 선택)");
            Menu menu2 = new Menu("사이드  ", "스파르타식 사이드");
            Menu menu3 = new Menu("음료   ", "스파르타식 음료");
            menu1.printMenu();
            menu2.printMenu();
            menu3.printMenu();

            System.out.println();
            System.out.println("[ 오더 메뉴 ]");
            Menu menu4 = new Menu("주문", "장바구니를 확인 후 주문합니다.");
            Menu menu5 = new Menu("취소", "진행중인 주문을 취소합니다.");
            menu4.printMenu();
            menu5.printMenu();

            System.out.println();
            System.out.println("(9. 키오스크 끄기), (0.총 판매)");
            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴 번호 입력 : ");
            int num = sc.nextInt();


            if (num == 1) {
                Menu.menuNum = 1;
                Product.category = menu1.menuName;
                System.out.println("---------------------------------------------------");
                System.out.println("[ 피자 메뉴 ]");
                Product pizza1 = new Product("햄피자    ", 11.9f, "햄이 들어간 피자");
                Product pizza2 = new Product("치즈피자  ", 9.9f, "치즈가 들어간 피자");
                Product pizza3 = new Product("감자피자  ", 12.9f, "감자가 들어간 피자");
                Product pizza4 = new Product("고구마피자 ", 13.9f, "고구마가 들어간 피자");
                System.out.println();
                System.out.print("메뉴 번호 입력 : ");
                int productNum = sc.nextInt();

                System.out.println("---------------------------------------------------");
                Menu.menuNum = productNum;
                if (productNum == 1) Product.addProduct(pizza1.menuName, pizza1.price, pizza1.explanation);
                else if (productNum == 2) Product.addProduct(pizza2.menuName, pizza2.price, pizza2.explanation);
                else if (productNum == 3) Product.addProduct(pizza3.menuName, pizza3.price, pizza3.explanation);
                else if (productNum == 4) Product.addProduct(pizza4.menuName, pizza4.price, pizza4.explanation);
                else System.out.println("번호 입력 오류");
            }
            if (num == 2) {
                Menu.menuNum = 1;
                Product.category = menu2.menuName;
                System.out.println("---------------------------------------------------");
                System.out.println("[ 사이드 메뉴 ]");
                Product side1 = new Product("감자튀킴            ", 4.9f, "구운 감자튀킴");
                Product side2 = new Product("너겟                ", 2.9f, "구운 너겟");
                Product side3 = new Product("크림스파게티         ", 8.9f, "크림소스가 들어간 스파게티");
                Product side4 = new Product("토마토스파게티        ", 7.9f, "토마토소스가 들어간 스파게티");
                System.out.println();
                System.out.print("메뉴 번호 입력 : ");
                int productNum = sc.nextInt();

                System.out.println("---------------------------------------------------");
                Menu.menuNum = productNum;
                if (productNum == 1) Product.addProduct(side1.menuName, side1.price, side1.explanation);
                else if (productNum == 2) Product.addProduct(side2.menuName, side2.price, side2.explanation);
                else if (productNum == 3) Product.addProduct(side3.menuName, side3.price, side3.explanation);
                else if (productNum == 4) Product.addProduct(side4.menuName, side4.price, side4.explanation);
                else System.out.println("번호 입력 오류");
            }
            if (num == 3) {
                Menu.menuNum = 1;
                Product.category = menu3.menuName;
                System.out.println("---------------------------------------------------");
                System.out.println("[ 음료 메뉴 ]");
                Product drink1 = new Product("콜라                ", 2.9f, "코카콜라");
                Product drink2 = new Product("사이다              ", 2.9f, "스프라이트");
                Product drink3 = new Product("환타                ", 2.9f, "오렌지 환타");
                Product drink4 = new Product("제로콜라            ", 2.9f, "제로 코카콜라");
                System.out.println();
                System.out.print("메뉴 번호 입력 : ");
                int productNum = sc.nextInt();

                System.out.println("---------------------------------------------------");
                Menu.menuNum = productNum;
                if (productNum == 1) Product.addProduct(drink1.menuName, drink1.price, drink1.explanation);
                else if (productNum == 2) Product.addProduct(drink2.menuName, drink2.price, drink2.explanation);
                else if (productNum == 3) Product.addProduct(drink3.menuName, drink3.price, drink3.explanation);
                else if (productNum == 4) Product.addProduct(drink4.menuName, drink4.price, drink4.explanation);
                else System.out.println("번호 입력 오류");
            }
            if (num == 4) {
                Order.showOrders();
                Order.orderComplete();
            }
            if (num == 5) {
                Order.orderCancel();
            }
            if (num == 9) break;
            ;
            if (num == 0) Order.showTotalSale();
        }

    }
}