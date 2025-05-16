# Java Dependency Injection Project (Fatima's Example)

This project demonstrates multiple ways to implement **Inversion of Control (IoC)** and **Dependency Injection (DI)** in Java using:

* Pure Java (manual injection and reflection)
* Spring Framework (XML and annotation-based configurations)

---

##  Project Structure

```
fatima/
├── dao/
│   ├── IDao.java            # DAO interface
│   └── DaoImpl.java         # DAO implementation V1
├── ext/    
│   └── DaoImplV2.java       # DAO implementation V2
├── metier/
│   ├── IMetier.java         # Business logic interface
│   └── MetierImpl.java      # Business logic implementation
├── pres/
│   ├── Pres1.java           # Manual constructor injection
│   ├── Pres2.java           # Reflection with config.txt
│   ├── PresSpringXML.java   # Spring XML configuration
│   └── PresSpringAnnotation.java # Spring annotation configuration
└── config.xml               # Spring XML configuration
```

---

## 1. Manual Constructor Injection (`Pres1.java`)

```java
DaoImplV2 dao = new DaoImplV2();
MetierImpl metier = new MetierImpl(dao); // Inject dependency via constructor
System.out.println("Result: " + metier.calcul());
```

**Highlights**:

* Simple, no frameworks needed.
* Hard-coded dependencies, not flexible.

---

##  2. Reflection-Based Injection with `config.txt` (`Pres2.java`)

**config.txt**:

```
fatima.dao.DaoImpl
fatima.metier.MetierImpl
```

## 2. Spring XML Configuration (`PresSpringXML.java`)

### config.xml:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dao" class="fatima.dao.DaoImpl"/>

    <bean id="metier" class="fatima.metier.MetierImpl">
        <constructor-arg ref="dao"/>
    </bean>

</beans>
```

### Java Code:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = (IMetier) context.getBean("metier");
System.out.println("RES=" + metier.calcul());
```

**Highlights**:

* XML-based configuration
* Good separation of configuration and code
* Requires `spring-context` dependency

---

## 3. Spring Annotation Configuration (`PresSpringAnnotation.java`)

### Example Annotations:

```java
@Component
public class DaoImpl implements IDao {
    public double getData() { return 55; }
}

@Component
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;

    public double calcul() { return dao.getData() * 11; }
}
```

### Java Code:

```java
ApplicationContext context = new AnnotationConfigApplicationContext("fatima");
IMetier metier = context.getBean(IMetier.class);
System.out.println("Res=" + metier.calcul());
```

**Highlights**:

* No XML needed
* Uses annotations: `@Component`, `@Autowired`
* Clean and maintainable

---


## Requirements

* Java 8+
* Spring Framework 5.x

### Maven Dependency for Spring:

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.3.10</version>
</dependency>
```

---

##  How to Run

### 1. Manual:

Run `Pres1.java` or `Pres2.java` using any IDE or `javac/java` CLI.

### 2. Spring XML:

Ensure `config.xml` is in `resources/`, then run `PresSpringXML.java`.

### 3. Spring Annotation:

Make sure classes are annotated with `@Component`, then run `PresSpringAnnotation.java`.

---

## Author

Developed by **Fatima** for learning and demonstration of DI and Spring framework basics.
[LinkedIn Profile](https://www.linkedin.com/in/fatima-al-b11039263/)
