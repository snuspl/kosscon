# KOSSCON 2018 Tutorial: Apache Nemo 위에서 주어진 Beam Application을 특정 환경에 대한 설정으로 실행하기

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

