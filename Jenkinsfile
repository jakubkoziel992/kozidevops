pipeline{
	agent any
	tools {
		maven "MAVEN3"
		jdk "OracleJDK21"
	}
	stages{
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
			
			post{
				success{
					echo 'Archiving artifacts now.'
					archiveArtifacts artifacts: '**/*.jar' 
				}
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
		
		stage ("Checkstyle Analysis"){
			steps{
				sh '''
					cd app
					mvn checkstyle:checkstyle
				   '''
			}
		}
		
		stage ('SonarQube analysis'){
			environment {
                scannerHome = tool 'SonarScanner5.0.1'
            }
			steps{
				withSonarQubeEnv('SONAR'){
					sh '''${scannerHome}/bin/sonar-scanner \
					-Dsonar.projectKey=kozidevops \
					-Dsonar.projectName=kozidevops \
					-Dsonar.sources=app/src/ \
					-Dsonar.java.binaries=app/target/ 							  
					-Dsonar.java.checkstyle.reportPath=app/target/checkstyle-result.xml'''
				}
			}
		}	

	}
}
