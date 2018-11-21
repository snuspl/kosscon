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
$ sudo apt install openjdk-8-jdk maven
$ sudo update-java-alternatives /usr/lib/jvm/java-8-openjdk-amd64
```

## 실습 다운로드 링크

(링크 삽입 예정)
