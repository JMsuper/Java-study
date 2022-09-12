package variable.test;

public class ImplementClass implements TestInterface{
    @Override
    public void display() {
        System.out.println(a);
        // 인터페이스의 변수가 static이기 때문에
        // 수정될 경우 공유되는 변수이므로 문제가 되지 않을까 생각했다.
        // 그러나 final로 생성되기 때문에 수정이 불가능하다.
        // 따라서 공유하는데 문제가 되지 않는다.
        // 그냥 constant한 변수라고 봐도 될 것 같다.
//        a = 30;
    }
}
