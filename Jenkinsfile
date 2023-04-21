pipeline{
    agent any
    stages{
        stage("Git Cloning Stage"){
            steps{
                git 'https://github.com/shahJainam961/JAIRU-Backend.git'
            }
        }
        stage("Building Stage"){
            steps{
                sh 'mvn clean compile package'
            }
        }
        stage("Testing Stage"){
            steps{
                sh 'mvn test'
            }
        }
        stage("Docker Login"){
            steps{
                sh 'docker login -u "murphy961" -p "Dockerhub@961"'
            }
        }
        stage("Building Docker Image"){
            steps{
                sh 'docker build -t murphy961/jairu-backend:1.0 .'
            }
        }
        stage("Pushing Docker Image on DockerHub"){
            steps{
                sh ''docker push murphy961/jairu-backend:1.0'
            }
        }
    }
}
