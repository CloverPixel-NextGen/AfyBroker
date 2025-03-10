plugins {
    java
    `maven-publish`
}

extensions.configure<PublishingExtension> {
    repositories {
        maven("https://maven.mcplugin.top/repository/minecraft/") {
            credentials(PasswordCredentials::class.java){
                username = project.findProperty("user").toString()
                password = project.findProperty("password").toString()
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
