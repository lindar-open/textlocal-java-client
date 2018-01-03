pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deliver') {
      steps {
        script {
          configFileProvider(
            [configFile(fileId: 'ac6238ce-1db5-4705-85ad-19089a2e2b36', variable: 'MAVEN_SETTINGS')]) {
              sh 'mvn -s $MAVEN_SETTINGS deploy'
            }
          }
          
        }
      }
    }
  }