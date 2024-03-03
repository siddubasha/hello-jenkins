pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage("SCM Checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/siddubasha/hello-jenkins.git']])
            }
        }

        stage("Build Process") {
            steps {
                bat 'mvn clean install'
            }
        }
        
        stage("Deploy WAR") {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'id-pwd-2', path: '', url: 'http://localhost:8082/')], contextPath: 'hello-jenkins', war: '**/*.war'
            }
        }
    }
    
    post {
        always{
            emailext attachLog: true, body: '''<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jenkins Build Notification</title>
</head>
<body>
    <p>Dear Jenkins User,</p>
    
    <p>Your Jenkins build has completed with the following details:</p>
    
    <ul>
        <li>Project: ${PROJECT_NAME}</li>
        <li>Build Number: ${BUILD_NUMBER}</li>
        <li>Status: ${BUILD_STATUS}</li>
        <li>Build URL: <a href="${BUILD_URL}">${BUILD_URL}</a></li>
    </ul>

    <p>Thank you for using Jenkins!</p>

    <p>This email was sent by Jenkins. Do not reply to this email.</p>
</body>
</html>
''', mimeType: 'text/html', replyTo: 'siddubasha420@gmail.com', subject: 'pipeline Status : ${BUILD_NUMBER}', to: 'siddubasha420@gmail.com'
        }
    }
}

//SCM  Checkout
//Build
//Deploy war
//Email notification