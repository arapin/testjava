# 젠킨스 파이프라인 스크립트

```shell
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                credentialsId: '6201f8e5-d63b-4613-ad79-ba71ce29c989', 
                url: '{git url}'
            }
        }
        
        stage('Gradle Build') {
            steps {
                bat '''
                    echo 'start bootJar'
                    ./gradlew clean bootJar
                '''
            }
            post{
                failure{
                    error 'Fail Build'
                }
            }
        }
        
        stage('Deploy {server ip}') {
            steps{
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: '{}', 
                            transfers: [
                                sshTransfer(
                                    cleanRemote: false, 
                                    excludes: '', 
                                    execCommand: '''
                                        cd {path}
                                        base=${pwd}
                
                                        pid=$(ps -ef | grep "GMELoanApi-1.0.0-SNAPSHOT.jar" | grep -v "grep" | awk \'{print $2}\')
                
                                        if [[$pid == ""]]
                                        then
                                            echo "**********api is not running.**********"
                                        else
                                            kill -9 $pid
                                        echo "**********api end**********"
                                        fi
                
                                        nohup java -jar -Dspring.profiles.active=prod /home/wein/deploy/GMELoanApi-1.0.0-SNAPSHOT.jar 2>> /dev/null >> /dev/null & echo $!
                                        echo "**********api start**********"
                                        ''', 
                                        execTimeout: 120000, 
                                        flatten: false, 
                                        makeEmptyDirs: false, 
                                        noDefaultExcludes: false, 
                                        patternSeparator: '[, ]+', 
                                        remoteDirectory: '{path}', 
                                        remoteDirectorySDF: false, 
                                        removePrefix: 'build/libs', 
                                        sourceFiles: 'build/libs/GMELoanApi-1.0.0-SNAPSHOT.jar'
                                )
                            ], 
                            usePromotionTimestamp: false, 
                            useWorkspaceInPromotion: false, 
                            verbose: true
                        )
                    ]
                )                
            }
        }
    }
}
```

- pipeline syntax를 사용하여서 각 영역의 내용을 채워 넣어야 한다.