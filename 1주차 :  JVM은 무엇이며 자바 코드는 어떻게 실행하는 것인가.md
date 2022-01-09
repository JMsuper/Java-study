# 1주차 :  JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가
### 목표
자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기.
### 학습할 것
- JVM이란 무엇인가
- 컴파일하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파이러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

## JVM이란 무엇인가
JVM은 Java Virtual Machine의 약자로 자바 가상 머신을 말한다. 가상머신이란 프로그램을 실행하기 위해 물리적 머신과 유사한 머신을 소프트웨어로 구현한 것이다.
JVM은 `.java`파일을 컴파일한 `.class`파일들을 load하여 실행시켜주는 머신을 말한다. 즉, 바이트코드로 컴파일된 자바코드를 실행시키는 머신을 의미한다.
이때 머신은 소프트웨어만을 지칭하는 것이 아니며 구현은 하드웨어로 구현 되는 경우도 JVM이라고 말할 수 있다. 하지만, 하드웨어 구현은 상용화되지 않았으며
거의 모든 JVM은 소프트웨어로 구현되있다. <br>
<br>
JVM이 필요한 이유는 `"Write Once, Run Anywhere"`이라는 JAVA의 목표와 관련이 있다. 한번의 개발로 모든 곳에서 프로그램을 동작시킬 수 있도록 하는 것이
초기 자바 개발의 목표였다. 이를 수행하기 위해서 JAVA는 OS로 부터 independent해야했다. 이를 위해서 OS에 dependent한 JVM을 개발하였다.
즉, JVM은 각각의 OS에 맞는 JVM이 설치되어야 한다. 이러한 이유는 OS마다 사용하는 시스템 콜이 다르며, CPU마다 사용하는 instruction이 다르기 때문이다.
JVM이 OS에 dependent함으로서, Java 프로그램은 한번의 개발을 통해 JVM이 설치된 모든 OS에서 실행가능해 진 것이다.<br>
<br>
JVM은 스택기반의 가상머신이다. JVM은 레지스터를 사용하지 않는다. 모든 CPU가 동일한 레지스터 구성을 가지고 있지는 않다. 만약 JVM이 레지스터를 사용한다면,
JVM은 원래도 OS에 independent하지만, 더더욱 independent해질 것이다. 왜냐하면 각 CPU의 레지스터 구성에 맞게 JVM이 개발되어야 하기 때문이다.
레지스터를 사용하지 않고, 스택으로 레지스터를 대신함으로써 CPU에 덜 independent해질 수 있다.<br>

##### JVM의 특성
- 스택 기반의 가상 머신
- 단일 상속 형태의 객체 지향 프로그래밍을 가상 머신 수준에서 구현
- 포인터를 지원하되 C와 같이 주소 값을 임의로 조작이 가능한 포인터 연산이 불가능
- 가비지 컬렉션 사용
- 모든 기본 타입의 정의를 명확히 함으로써 플랫폼 독립성 보장
- 데이터 흐름 분석에 기반한 자바 바이트코드 검증기를 통해 스택 오버프로우, 명령어 피연산자의<br>
  타입 규칙 위반, 필드 접근 규칙 위반, 지역 변수의 초기화 전 사용 등 많은 문제를 실행 전에 검증하여<br>
  실행 시 안전을 보장하고 별도의 부담을 줄여줌
- 명령어에서 스택에서 가져올 피연산자의 타입을 명령어에 지정(예: 정수 덧셈은 iadd, 단정밀도 실수 덧셈은 fadd)

## 바이트코드란 무엇인가
자바 바이트코드란 JVM이 이해할 수 있는 언어로 변환된 자바 소스 코드를 의미한다.
자바 컴파일러에 의해 변환되는 코드의 명령어 크기가 1바이트라서 자바 자이트 코드라고 불리고 있다.
이러한 자바 바이트 코드의 확장자는 `.class`이며, 자바 바이트 코드는 JVM만 설치되어 있으면,
어떤 운영체제에서라도 실행될 수 있다.
#### java코드를 byte 코드로 변환하기
intellij에는 java코드를 build후 byte 코드를 볼 수 있는 기능을 제공한다.
`intellij`->`View`->`Show Bytecode`
Java 코드
```
public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);
    }
```
Byte 코드
```
public static main([Ljava/lang/String;)V
   L0
    LINENUMBER 3 L0
    ICONST_1
    ISTORE 1
   L1
    LINENUMBER 4 L1
    ICONST_2
    ISTORE 2
   L2
    LINENUMBER 5 L2
    ILOAD 1
    ILOAD 2
    IADD
    ISTORE 3
   L3
    LINENUMBER 6 L3
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    ILOAD 3
    INVOKEVIRTUAL java/io/PrintStream.println (I)V
   L4
    LINENUMBER 7 L4
    RETURN
   L5
    LOCALVARIABLE args [Ljava/lang/String; L0 L5 0
    LOCALVARIABLE a I L1 L5 1
    LOCALVARIABLE b I L2 L5 2
    LOCALVARIABLE c I L3 L5 3
    MAXSTACK = 2
    MAXLOCALS = 4
```
Byte 코드는 C언어로 작성된 `.c`파일을 컴파일 했을 때 생성되는 `.obj`파일과 유사하다.
Byte 코드또한 Instruction을 가지고 있다. 특이점은 레지스터를 사용하지 않고 스택에 변수값을 저장한다는 것이다.

## JVM 구성 요소
<img src="https://github.com/JMsuper/whiteship-live-study-java/blob/main/img/JVM%20%EA%B5%AC%EC%A1%B0.PNG" witdh=800>


## JIT 컴파이러란 무엇이며 어떻게 동작하는지

## 컴파일하는 방법
컴파일 명령어 구조 : `javac <option> <source files> <args>`
`-classpath` 옵션 : 컴파일러가 컴파일 할 때 필요로하는 라이브러리나 클래스들의 경로를 지정해주는 옵션
예를 들어 하나의 클래스에서 다른 클래스의 인스턴스를 사용하는 구조일 때 인스턴스를 사용하는 클래스는
`-classpath`를 통해 참조하고 있는 클래스의 위치를 정의해줘야 한다.
EX) `javac -classpath ./* TestClass.java` (컴파일)

#### 1개 java파일 컴파일
1. `.java`파일 작성
2. `javac 클래스명.java`(컴파일 명령어)
3. `클래스명.class` 바이트코드 파일 생성
4. `java 클래스명.class` 바이트코드 실행


## 실행하는 방법
EX) `java example.TestClass` (실행 명령어)
java 명령은 패키지의 parent 디렉토리 위치에서 실행하되, 실행할 클래스 파일의 이름은
`패키지명.클래스파일명`으로 지정해야 한다.




## JDK와 JRE의 차이



### 참고자료
- JVM이란 무엇인가? : https://asfirstalways.tistory.com/158
- 김김의 JVM Specification : https://www.youtube.com/watch?v=6reapO0gLPs
- 무민의 JVM Stack & Heap : https://www.youtube.com/watch?v=UzaGOXKVhwU
- JVM 위키백과 : https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%EA%B0%80%EC%83%81_%EB%A8%B8%EC%8B%A0
- 자바컴파일 - javac : https://suzxc2468.tistory.com/193
- 자바 바이트 코드 : http://www.tcpschool.com/java/java_intro_programming
