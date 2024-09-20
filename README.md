# Michael Test Api
Micahel Test API Server 입니다. Spring Boot를 활용하여 API Server를 구성 하였습니다. 주입된 의존성은
1. JPA
2. Query DSL
3. MapStruct
4. Swagger
5. AOP
6. Open Feign
7. JWT
8. Spring Security

## 프로젝트 소개
Michael Test API 프로젝트로써 여러가지 실험적인 프로젝트를 다루는 프로젝트 입니다.

## 버그

## 참고 및 출처

- [참고 1] shell script
```shell
cd /home/{user folder}/deploy
base=${pwd}

pid=$(ps -ef | grep "{user app jar file name}.jar" | grep -v "grep" | awk \'{print $2}\')

if [[$pid == ""]]
then
    echo "**********api is not running.**********"
else
    kill -9 $pid
echo "**********api end**********"
fi

nohup java -jar -Dspring.profiles.active={env prod|dev|local} /home/{user folder}/deploy/{user app jar file name}.jar 2>> /dev/null >> /dev/null & echo $!
echo "**********api start**********"
```

## 버전 및 업데이트 정보
1. 2024-09-19 프로젝트 생성