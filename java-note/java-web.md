# Maven

- apache
- a tool to help create/manage java projects
  - dependency management
  - project create
  - project structure unify
- repository of maven
  - local repository --> 1
  - (private) remote repository --> 2
  - (global) central repository --> 3 https://mvnrepository.com/repos/central

<img src="java-web.assets/image-20250327201012845.png" alt="image-20250327201012845" style="zoom:70%;" />

- maven 坐标

  - unique label for maven project

  - 3 parts

    - groupId

    - artifactId

    - version

    - ```xml
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>3.4.3</version>
      ```

- exclude dependency

  - `<exclusions>...</exclusions>` 

## Lifecycle 

<img src="java-web.assets/image-20250327222700673.png" alt="image-20250327222700673" style="zoom:80%;" />

- Most important

  <img src="java-web.assets/image-20250327222909218.png" alt="image-20250327222909218" style="zoom:75%;" />

- !!! In the same lifecycle (3 different: clean, default, site), when you run the next stage, the before stage will also run

  - in clean: if you run clean, pre-clean will also run
  - in default: if you run install, compile will also run, but clean will not run, because clean is not in the same lifecycle

- range of dependency: `<scope>xxx</scope>` 



# Test

<img src="java-web.assets/image-20250327223856609.png" alt="image-20250327223856609" style="zoom:80%;" />

<img src="java-web.assets/image-20250327224109994.png" alt="image-20250327224109994" style="zoom:67%;" />

- Unit Test
- Integrate Test
- System Test



## JUnit

- pros

  - test code and src seperate
  - automatic test
  - test report

- test class and test method

  ```java
  // UserServiceTest
  
  @Test
  public void testGetAge() {
    ...
  }
  ```

  - convention: name of test class --> ...Test
  - rule: test method must be `public void`

- Annotations

  <img src="java-web.assets/image-20250327225942944.png" alt="image-20250327225942944" style="zoom:80%;" />

- parameterized test

  ```java
  @ParameterizedTets
  @ValueSoure (strings = {"111", "121", "135"})
  public void getGetGender (String idcard) {
    UserService userService = new UserService ();
    String gender = userService.getGender(idcard);
    Assertions.assertEquals("male", gender);
  }
  ```

- Cover all possible cases in the business method as much as possible, especially boundary values --> test with coverage

  <img src="java-web.assets/image-20250327232024414.png" alt="image-20250327232024414" style="zoom:80%;" />

# Web

## Basic 

- static source
- dynamic source
- B/S framework: browser / server
- C/S framework: client / server ==> seperate client 





