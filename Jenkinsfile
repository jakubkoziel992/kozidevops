pipeline{
	agent any
	tools {
		maven "MAVEN3"
		jdk "OracleJDK21"
	}
	
	stages {
		stage("Show Build number"){
			steps{
				echo "The build ID is: ${env.BUILD_ID} "
			}
		}
	
	
		stage("Fetch Code"){
			steps{
				git url: 'https://github.com/jakubkoziel992/kozidevops.git', branch: 'master'
			}
		}
		
		stage ("Build") {
			steps {
				sh '''
					cd app
					mvn clean package
				   '''
			}
		}


		stage ("UNIT test"){
			steps {
				sh '''
					cd app
					mvn test
				   '''
			}
		}

		stage ("Checkstyle Analysis"{
			steps{
				sh '''
					cd app
					mvn checkstyle:checkstyle
				   '''
			}
		}
	}
}

