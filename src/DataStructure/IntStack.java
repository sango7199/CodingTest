package DataStructure;

import java.util.Scanner;

public class IntStack {
    private int[] stk; // 스택용 배열
    private int capacity; // 스택의 크기
    private int ptr; // 스택 포인터

    //--- 실행시 예외: 스택이 비어있음 ---//
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    // 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없음
            capacity = 0;
        }
    }
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public void clear() {
        ptr = 0;
    }

    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비었습니다.");
        else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("|----------------------- 스택 프로그램 실행 -----------------------|");;
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("---------------------------------------------------------------");;
            System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
            System.out.println("---------------------------------------------------------------");;
            System.out.println("(1)push / (2)pop / (3)clear / (4)search / (5)dump / (0)exit");

            System.out.print("입력 : ");
            int input = sc.nextInt();
            if (input == 0) {
                System.out.print("프로그램을 종료합니다.");
                break;
            }

            switch (input) {
                case 1:
                    System.out.print("push하실 데이터를 입력해주세요 : ");
                    int pushVal = sc.nextInt();
                    try {
                        s.push(pushVal);
                    } catch (IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득 찼습니다");
                    }
                    break;
                case 2:
                    try {
                        int popVal = s.pop();
                        System.out.println("pop한 데이터는 " + popVal + " 입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 3:
                    s.clear();
                    System.out.println("stack 데이터를 전부 삭제했습니다.");
                    break;
                case 4:
                    System.out.print("검색하실 데이터를 입력해주세요 : ");
                    int searchResult = s.indexOf(sc.nextInt());
                    if (searchResult == -1) {
                        System.out.println("해당 데이터를 찾을 수 없습니다.");
                    } else {
                        System.out.println("검색하신 데이터는 " + (searchResult + 1) + "에 있습니다.");
                    }
                    break;
                case 5:
                    s.dump();
                    break;
                default:
                    System.out.println("입력값이 올바르지 않습니다.");
                    break;
            }
        }
    }
}
