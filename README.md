# KOSSCON 2018 Tutorial: Beam Application을 Apache Nemo 를 활용하여 특정 환경에 최적화하여 실행하기

## 실습 환경 갖추기

#### Mac OS

1. Homebrew 설치 (`$ brew -version` 을 실행했을 때, `Homebrew ...` 으로 시작되는 문구가 출력되지 않는 경우):
```
$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

2. Java8 설치 (`$ java -version` 을 실행했을 때, `java version 1.8...` 으로 시작되는 문구가 출력되지 않는 경우):
```
$ brew tap caskroom/versions
$ brew cask install java8
```

3. Maven 설치 (`$ mvn -version` 을 실행했을 때, `Apache Maven..` 이라고 시작되는 문구가 출력되지 않는 경우):
```
$ brew install maven
```


#### Ubuntu

Ubuntu 16.04 이상의 버전을 권장함.

```
$ sudo apt update
$ sudo apt install openjdk-8-jdk maven unzip
$ sudo update-alternatives --config java
```

그 이후, 다음과 같은 출력값이 나오는데,

```
Output
There are 3 choices for the alternative java (providing /usr/bin/java).

  Selection    Path                                            Priority   Status
------------------------------------------------------------
* 0            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1101      auto mode
  1            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1101      manual mode
  2            /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java   1081      manual mode
  3            /usr/lib/jvm/java-8-oracle/jre/bin/java          1081      manual mode
```

이 때 `java-8-openjdk...` 에 해당하는 숫자 (위 예시에서는 2) 를 쓰고 엔터를 누른다.
이후에 다음 과정을 통해 `$JAVA_HOME`을 세팅한다.

```
$ sudo vi /etc/environments
```

여기에서 `o`를 눌러서 새로운 줄에다가 다음 줄을 삽입한다

```
JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/bin/"
```

`:wq` 를 누르고 나와서 새로운 environment variable을 적용하고 확인한다.

```
$ source /etc/environments
$ sudo ln -s `which java` /bin/java
$ echo $JAVA_HOME
```

## 실습 다운로드 링크 및 설치

(링크 삽입 예정)

위 링크에서 zip파일을 다운 받은 뒤, 압축을 해제한다 (e.g., `$ unzip FILENAME.zip`)

다음 커맨드를 통해 Apache Nemo를 설치한다

```
$ cd 추후수정예정
$ mvn clean install -T2C -DskipITs
```

## 텍스트 에디터 설치하기

기본적으로 vim을 사용하는데 문제가 없으신 분이나 emacs, sublime text등 기존에 편하게 사용하는 텍스트 에디터가 있으신 분은 이 과정을 따라하지 않으셔도 됩니다.

하지만, 아직 코딩에 익숙하지 않으신 분들에 대해서는 sublime text가 가장 사용하기 쉽다고 개인적으로 생각하기 때문에 다음 과정을 통해 Sublime Text를 설치하실 수 있습니다. 후반부에 실제로 코딩하는 부분에 있어서는 필수적인 부분이기 때문에 텍스트 에디터가 익숙하지 않으신 분들은 꼭 따로 이 과정을 따라하시길 바랍니다.

#### Mac OS에 Sublime Text 설치하기

```
$ brew cask install sublime-text
```

#### Ubuntu에 Sublime Text 설치하기

```
$ sudo add-apt-repository ppa:webupd8team/sublime-text-3
$ sudo apt-get update
$ sudo apt-get install sublime-text-installer
```

## 에러 발생 시

만약에 설치를 하다가 에러가 발생한다면, 그 에러는 약 99%의 경우 다른 사람이 한 번쯤은 겪어보았던 문제입니다. [이 링크](https://www.google.com)를 통해서 찾을 수 있는 [구글 사이트](https://www.google.com)에 가셔서 에러 메시지 (보통 ERROR 으로 시작하는 줄입니다)를 복사&붙여넣기 하셔서 검색하면 보통 친절한 답변을 찾을 수 있습니다 (StackOverflow 라는 사이트에 있는 답변이 보통은 가장 좋습니다).

또한, 실습 진행 중 발생하는 문제는 대략 85%의 경우 오타로 인한 문제입니다 (e.g., `stdio.h` 대신 `studio.h`로 잘못 입력). 보통 실행을 해서 에러 메시지가 출력되면, 해당하는 메시지에서 문제가 있는 해당 줄에 대한 정보를 찾으실 수 있습니다. 해당 줄을 자세히 살펴보시고 오타가 있는지 확인 해 주시길 바랍니다.

이렇게 하셔도 해결이 되지 않는다면 손을 드셔서 질문을 해 주시길 바랍니다. 달려가서 해결해드리겠습니다. :)

