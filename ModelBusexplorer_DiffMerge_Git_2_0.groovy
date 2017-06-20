job('ModelBusExplorer-DiffMerge-Git-2.0') {
    description 'ModelBus TeamProvider-UpdateSite Build.'
    scm {
        git {
            remote {
                name ("origin")
                url ("git@gitlab.fokus.fraunhofer.de:modelbus/ModelBusExplorer.git")
                credentials("ModelBus")
                refspec ("+refs/heads/ecf-version:refs/remotes/origin/ecf-version")
                extensions{
                    relativeTargetDirectory("ModelBusExplorer")
                }
            }
            remote {
                name ("origin1")
                url ("git@gitlab.fokus.fraunhofer.de:modelbus/DiffMerge.git")
                credentials("ModelBus")
                refspec ("+refs/heads/*:refs/remotes/origin1/*")
                 extensions{
                    relativeTargetDirectory("DiffMerge")
                }
            }
            branch ("ecf-version")
        }
    }
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package pmd:pmd checkstyle:checkstyle")
            properties(skipTest: true)
            rootPOM("ModelBusExplorer/trunk/org.modelbus.tools.modelbusexplorer.build.master/pom.xml")
        }
                 
    }
    publishers {
    	droneRecorder {
    		serverUrl("http://10.147.66.165:8080")
    		channel("TestJenkins")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
    		artifacts("ModelBusExplorer/trunk/org.modelbus.tools.modelbusexplorer.build.category/target/*zip")
			failsAsUpload(true)

        }
    }
}