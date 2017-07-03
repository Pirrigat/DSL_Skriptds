job('ModelBus-Core-Git-2.0') {
    customWorkspace('ModelBus-Core-2.0-Seed/TychoBuild/')
    description 'ModelBus Core Build.'
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package")
            properties(skipTest: true)
            rootPOM("/build/org.modelbus.build.core.master/pom.xml")
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
    		channel("Test.modelbus.modelbus.core.git.2.0")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
    		artifacts("p2repositories/org.modelbus.build.core/target/*.zip")
		failsAsUpload(true)

        }
    }
}
