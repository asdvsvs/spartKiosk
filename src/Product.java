import java.util.Scanner;

public class Product extends Menu{
    float price;

    static String category;

    public Product(String menuName,float price, String explanation) {
        super(menuName,explanation);
        this.price = price;
        System.out.printf("%d %s \t  \t| W %.1f \t|\t%s\n", menuNum++,menuName,price,explanation);

    }

    public static void addProduct(String productName,float price, String explanation){
        Scanner sc = new Scanner(System.in);
        Product product = new Product(productName,price,explanation);

        if(Product.category.contains("피자")){    /* <--이렇게도 가능--> if(productName.contains("피자"))*/
            System.out.println("    위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.printf("\t1.기본(W %.1f)\t2.치즈 추가(+W 2.0)\t3.토핑 추가(+W 3.0)\n",price);
            switch (sc.nextInt()){
                case 1 : product.menuName=productName+"(기본)     ";    product.price=price;     break;
                case 2 : product.menuName=productName+"(치즈 추가)";    product.price=price+2;    break;
                case 3 : product.menuName=productName+"(토핑 추가)";    product.price=price+3;    break;
            }
            System.out.println();
            System.out.printf(" %d. %s | W %.1f | %s\n", menuNum-1,product.menuName,product.price,explanation);
        }


        System.out.println("    위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("  1.확인        2.취소");
        if(sc.nextInt()==1) {
            Order.addOrder(product.menuName, product.price,product.explanation);
            System.out.println("장바구니에 추가 되었습니다.");
        }
    }




}
