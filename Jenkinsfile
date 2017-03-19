echo 'Hallo Pipeline'

node {
	
	stage('Checkout') {
		checkout scm
	}
	
	stage('Build') {
		 execGradle('clean build');
	}
	
	stage('Integrationtests') {
		execGradle('-Dcorebanking.base.url=http://localhost:8090/corebanking itest');
   }

	stage('Results') {
		junit '**/build/test-results/*/TEST-*.xml'
		archive '**/build/libs/*.war'
	}

	stage('Postbuild') {
		if (isUnix()) {
			sh 'ls -la'
		} else {
			bat 'dir'
		}
	}
}
 
def execGradle(command) {
	if (isUnix()) {
		sh "./gradlew $command"
	} else {
		bat "./gradlew.bat $command"
	}
}