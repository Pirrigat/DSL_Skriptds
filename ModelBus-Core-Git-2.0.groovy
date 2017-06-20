job('ModelBus-Core-Git-2.0') {
    description 'ModelBus Core Build.'
    scm {
        git {
            remote {
                url ("git@gitlab.fokus.fraunhofer.de:modelbus/modelbus.git")
                credentials("ModelBus")
            }
            branch ("ecf-version")
        }
    }
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package")
            properties(skipTest: true)
            rootPOM("build/org.modelbus.build.core.master/pom.xml")
        }
               
        ant {
            antInstallation("Ant")
            buildFile("/build/org.modelbus.build.core.master/javadoc.xml")
            target("UpdateSiteJavaDoc")
        }    
    }
    publishers {
    	droneRecorder {
    		serverUrl("http://10.147.66.165:8080")
    		channel("TestJenkins")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
    		artifacts("UpdateSiteJavaDoc/javadoc/*.zip, p2repositories/org.modelbus.build.core/target/*.zip")
			failsAsUpload(true)

        }
    }
}