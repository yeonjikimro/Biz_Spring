# EMS 프로젝트
* mysql-connector-j
* mybatis
* mybatis-spring
* spring-jdbc
* commons-dbcp
* commons-io
* commons-fileupload 

## 파일 업로드 도구
* commons-io
* commons-fileupload

## JSON 관련도구
* jackson-bind

## 메일 전송 도구
```
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>
```

## 암호화 도구
* spring security core(5.3.13 release 버전 사용)
* jasypt(git 에 올라가도 암호화되어 보이지 않음)
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>${org.jasypt-version}</version>
</dependency>
```

```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt-spring31 -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt-spring31</artifactId>
    <version>${org.jasypt-version}</version>
</dependency>
```
version(1.9.3)이 동일한 것이 2개 있으니
version 안에 ${org.jasypt-version}을 넣어준다.


## 데이터 유효성 검사 도구
* 서버(Controller) 단에서 데이터 유효성 검사 도구
* validation api
* hibernate validation
```
<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```
* hibernate validation
```
<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>
```

* Spring framework 5.x 버전에서는 서버단 유효성검사를 위하여 framwork 관련 요소를 추가해 주어야 한다.
```
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>5.3.21</version>
		</dependency>
```