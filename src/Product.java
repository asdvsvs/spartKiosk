import java.util.HashMap;
import java.util.Scanner;

public class Product extends Menu{
    float price;
    static String category;
    static HashMap<Integer, Product> product = new HashMap<Integer, Product>();

    public Product(String menuName,float price, String explanation) {
        super(menuName,explanation);
        this.price = price;
    }

    public static void selectProduct(String productName, float price, String explanation){
        Scanner sc = new Scanner(System.in);
        Product product = new Product(productName,price,explanation);
        if(Product.category.contains("피자")){    /* <--이렇게도 가능--> if(productName.contains("피자"))*/
            Loop :
            while (true){
                System.out.println("---------------------------------------------------");
                System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum,product.menuName,product.price,explanation);
                System.out.println("    위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                System.out.printf("\t1.기본(W %.1f)\t2.치즈 추가(+W 2.0)\t3.토핑 추가(+W 3.0)\n",price);
                int inputNum = sc.nextInt();
                if(inputNum<1 || 3<inputNum) {
                    numError();
                    continue;
                }
                switch (inputNum){
                    case 1 : product.menuName=productName+"(기본)     ";    product.price=price;     break Loop;
                    case 2 : product.menuName=productName+"(치즈 추가)";    product.price=price+2;    break Loop;
                    case 3 : product.menuName=productName+"(토핑 추가)";    product.price=price+3;    break Loop;
                }
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum,product.menuName,product.price,explanation);
        System.out.println("\t위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("\t1.확인        2.취소");
        if(sc.nextInt()==1) {
            Order.addOrder(product.menuName, product.price,product.explanation);
            System.out.println("장바구니에 추가 되었습니다.");
        }
    }

    public static void setProduct(int num){
        Product.category = Menu.menu.get(num).menuName;
        Product product1 = new Product("",0,"");
        Product product2 = new Product("",0,"");
        Product product3 = new Product("",0,"");
        Product product4 = new Product("",0,"");
        switch (num){
            case 1 :
                product1 = new Product("햄피자    ", 11.9f, "햄이 들어간 피자");
                product2 = new Product("치즈피자  ", 9.9f, "치즈가 들어간 피자");
                product3 = new Product("감자피자  ", 12.9f, "감자가 들어간 피자");
                product4 = new Product("고구마피자 ", 13.9f, "고구마가 들어간 피자");
                break;
            case 2 :
                product1 = new Product("감자튀킴            ", 4.9f, "구운 감자튀킴");
                product2 = new Product("너겟                ", 2.9f, "구운 너겟");
                product3 = new Product("크림스파게티         ", 8.9f, "크림소스가 들어간 스파게티");
                product4 = new Product("토마토스파게티        ", 7.9f, "토마토소스가 들어간 스파게티");
                break;
            case 3 :
                product1 = new Product("콜라                ", 2.9f, "코카콜라");
                product2 = new Product("사이다              ", 2.9f, "스프라이트");
                product3 = new Product("환타                ", 2.9f, "오렌지 환타");
                product4 = new Product("제로콜라            ", 2.9f, "제로 코카콜라");
                break;
        }
        product.put(1, product1);
        product.put(2, product2);
        product.put(3, product3);
        product.put(4, product4);
    }

    public static void productScreen(){
        Scanner sc = new Scanner(System.in);
        Menu.menuNum = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("[ 피자 메뉴 ]");
        for (int i=1;i<product.size()+1;i++) System.out.printf("%d %s \t  \t| W %.1f \t|\t%s\n", menuNum++,product.get(i).menuName,product.get(i).price,product.get(i).explanation);
        System.out.println();
        System.out.print("메뉴 번호 입력 : ");

        int productNum;
        while (true){
            productNum = sc.nextInt();
            if(0<productNum && productNum<=product.size()) break;
            else numError();
        }
        Menu.menuNum = productNum;
        if(product.containsKey(productNum)) selectProduct(product.get(productNum).menuName,product.get(productNum).price,product.get(productNum).explanation);
    }
}
