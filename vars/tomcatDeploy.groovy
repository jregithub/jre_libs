def call(ip,warName,credID){
sshagent(["${credID}"]) {
                    
		    sh "scp -o StrictHostKeyChecking=no target/${warName}.war ec2-user@${ip}:/opt/tomcat9/webapps/"
	// stop tomcat
                   sh " ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
	// start tomcat
                    sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
 }
}
