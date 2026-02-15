plugins {
	java
	id("org.springframework.boot") version "3.3.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.sonarqube") version "5.0.0.4638"
}

group = "com.paradigma0621"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

extra["springCloudVersion"] = "2023.0.6" // Spring Cloud Leyton (Boot 3.3.x)

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.data:spring-data-commons")

	// ✅ Eureka Client
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

	runtimeOnly("com.mysql:mysql-connector-j")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.mockito:mockito-junit-jupiter")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}