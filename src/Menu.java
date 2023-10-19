public class Menu {
     String menuName;
     String explanation;
     static int menuNum;

    public Menu(String menuName, String explanation){
        this.menuName = menuName;
        this.explanation = explanation;
    }
    public void printMenu(){ // 생성자에 넣으면 프로덕트 객체 생성 시 출력되는 문제 때문에 따로 메서드로 만듬
        System.out.printf("%d %s  |  %s\n", menuNum++,menuName,explanation);
    }
}
