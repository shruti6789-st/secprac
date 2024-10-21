pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deployment will be done on my Birthday!!'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Using credentials for SonarQube token
                    def sonarToken = credentials('sonar-token-id') // Replace with your credentials ID

                    withSonarQubeEnv('SonarHome') {
                        sh """
                        sonar-scanner -D"sonar.projectKey=python1" \
                        -D"sonar.sources=." \
                        -D"sonar.host.url=http://localhost:9000" \
                        -D"sonar.login=${sonarToken}"
                        """
                    }
                }
            }
        }
    }
}
