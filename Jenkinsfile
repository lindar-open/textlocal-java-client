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
      def SERVER_ID = 'server-1'
      def server = Artifactory.server SERVER_ID
      def uploadSpec =
      """
      {
      "files": [
          {
              "pattern": "target/textlocal-client-(*).jar",
              "target": "libs-snapshots-local/com/lindar/textlocal-client/{1}/"
          }
        ]
      }
      """
      def buildInfo = Artifactory.newBuildInfo()
      buildInfo.env.capture = true
      buildInfo=server.upload(uploadSpec)
      server.publishBuildInfo(buildInfo)
    }
  }
}