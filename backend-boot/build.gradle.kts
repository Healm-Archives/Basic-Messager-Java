plugins {
	java
	id("org.springframework.boot") version "4.0.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")

	implementation("org.springframework.boot:spring-boot-starter-validation")	
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	// implementation("spring-boot-starter-graphql")
	// implementation("spring-boot-starter-graphql-test")
	
	// implementation("com.github.javafaker:javafaker:1.0.2") 

	runtimeOnly("org.postgresql:postgresql")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")	
	
	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// JWT
	implementation("io.jsonwebtoken:jjwt-api:0.13.0")
    	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.13.0")
    	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.13.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
