    pipeline{

    agent any

    stages {

        stage('Build Jar'){
            steps {
            echo "Build Jar started....."
            sh "mvn clean package -DskipTests"
            }
        }

        stage('Build Image'){
            steps {
                echo "building docker image"
                sh "docker build -t=yogesh3688/selenium ."
            }

        }

        stage('Push Image'){
            steps {
                echo "pushing docker image"
                sh "docker push yogesh3688/selenium"
            }
        }
    }

    }
