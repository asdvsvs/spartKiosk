
import java.util.List;
import java.util.Scanner;

public class Manager {

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 설정 : ");
        String menuName = sc.nextLine();

        System.out.println("설명 설정 : ");
        String explanation = sc.nextLine();

        System.out.println("가격 설정 : ");
        float price = sc.nextFloat();

        return new Product(menuName, price, explanation);
    }

    public void deleteProduct(Menu menu,Product product){
        Scanner sc = new Scanner(System.in);
//        Product product = new Product()
        String[] tempString= new String[product.productMap.size()];
        String menuName;
        int num=0;
        System.out.println("---------------------------------------------------");
        System.out.println("[ 삭제할 메뉴 ]");
        for (String s : product.productMap.keySet()){
            tempString[num] = s;
            System.out.println(num+1+". "+tempString[num++]);
        }
        System.out.print("삭제할 menuId : ");
        menuName=tempString[sc.nextInt()-1];
        num=0;
        System.out.println("---------------------------------------------------");
        System.out.println("[ 삭제할 상품 ]");
        for(Product p :product.productMap.get(menuName)){
            System.out.println(num+1+". "+p.menuName);
            num++;
        }
        System.out.print("삭제할 productId : ");
        int input = sc.nextInt();
        System.out.println("---------------------------------------------------");
        System.out.println(product.productMap.get(menuName).get(input-1).menuName+" 을 삭제하시겠습니까?");
        System.out.println("1. 삭제, 2~. 취소");
        if(sc.nextInt()==1) {
            product.productMap.get(menuName).remove(input-1);
            menu.deleteMenu(product);
        }
        else System.out.println("삭제 취소");
    }
    public void deleteProductById(Menu menu,Product product){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("상품 id로 삭제하기");
        for (List<Product> p : product.productMap.values()){
            for(int i=0;i<p.size();i++)  System.out.println(p.get(i).menuName+p.get(i).id);
        }
        System.out.print("삭제할 id 입력: ");
        int inputId = sc.nextInt();
        for (List<Product> p : product.productMap.values())
            for(int i=0;i<p.size();i++)  {
                if(inputId==p.get(i).id) p.remove(i);
                break;
            }
        System.out.println("삭제완료");
        menu.deleteMenu(product);
    }
}
