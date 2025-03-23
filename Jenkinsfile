pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "your-dockerhub-username/spring-boot-mvc-crud"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/nikhil-solankhi/spring-boot-mvc-crud.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials']) {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh 'docker run -d -p 8080:8080 $DOCKER_IMAGE'
            }
        }
    }
}
