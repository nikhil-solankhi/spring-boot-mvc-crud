pipeline {
    agent any

    environment {
        IMAGE_NAME = 'nikhilsolankhi/mvccrud'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                git branch: 'main', url: 'https://github.com/nikhil-solankhi/spring-boot-mvc-crud.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Login to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDENTIALS', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }

        stage('Deploy Application') {
            steps {
                sh "docker stop mvccrud || true && docker rm mvccrud || true"
                sh "docker run -d -p 8090:8090 --name mvccrud ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }
}
