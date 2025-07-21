    pipeline{

    agent any

    stages {

        stage('Build Jar'){

//             agent{
//                 docker{
//                     image 'maven:3.9.3-eclipse-temurin-17-focal'
//                     args '-u root -v /temp/m2:root/.m2'
//                 }
//             }
            steps {
            echo "Build Jar started....."
            sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps {
                echo "building docker image"
                sh 'docker build -t=yogesh3688/selenium:latest .''
            }

        }

        stage('Push Image'){
             environment{
                DOCKER_HUB = credentials('dockerhub-credentials')

             }
            steps {
                echo "pushing docker image"
//                 sh "docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}"
                sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR}  --password-stdin'
                sh 'docker push yogesh3688/selenium:latest'
                sh "docker tag yogesh3688/selenium:latest yogesh3688/selenium:${env.BUILD_NUMBER}"
                sh "docker push yogesh3688/selenium:${env.BUILD_NUMBER}"
                }
            }
        }

        post {
        always {
            sh "docker logout"
            }
          }


    }
