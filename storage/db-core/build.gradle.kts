allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("com.h2database:h2")
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")
}

val generated = file("src/main/generated")

tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory.set(generated)
}

sourceSets {
    main {
        kotlin.srcDirs += generated
    }
}

tasks.named("clean") {
    doLast {
        generated.deleteRecursively()
    }
}
