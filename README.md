# Spring Boot Web Application Guide

## Step 01 - Creating Spring Boot Web Application with Spring Initializr

1. Open Spring Initializr and choose:
   - Group Id: com.emadd9.springboot
   - Artifact Id: myfirstwebapp
   - Dependencies: Web, DevTools

## Step 02 - Quick overview of Spring Boot Project

## Step 03 - First Spring MVC Controller, @ResponseBody, @Controller

- Ensure the presence of annotations:
  - `@Controller` on `SayHelloController`
  - `@ResponseBody` on the `sayHello` method
  - `SayHelloController.java` is under component scan
  - It is under the subpackage of `com.in28minutes.springboot.myfirstwebapp`

## Step 04 - Enhancing Spring MVC Controller to provide HTML response (Using StringBuffer)

## Step 05 - Redirect to a JSP using Spring Boot - Controller, @ResponseBody, and View Resolver

- Check code changes
- Focus on the path of JSP: `/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp`
- Verify `application.properties` changes
- Enable debug logging if issues persist: `logging.level.org.springframework=debug`

## Step 07 - Quick Overview - How does the web work - Request and Response

## Step 08 - Capturing QueryParams using RequestParam and First Look at Model

- Example: `/login => LoginController => goToLoginPage Method --->(@RequestParam String name, ModelMap Model)`
- Use of `ModelMap.put("attribute", name)` to pass parameters inside the view

## Step 09 - Quick Overview - Importance of Logging with Spring Boot

- Utilize logging with `private Logger logger = LoggerFactory.getLogger(getClass());`
- Different log levels: DEBUG, INFO, WARN
- Configure logging levels in `application.properties`

## Step 10 - Understanding DispatcherServlet, Model 1, Model 2, and Front Controller

## Step 11 - Creating a Login Form

## Step 12 - Use JSTL Core Tags to create ListTodo table

- Dependencies for JSTL in `pom.xml`
- Example taglibs: `<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>`
- `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`

## Step 13 - Use Bootstrap and jQuery for CSS styling

- Add dependencies for Bootstrap and jQuery in `pom.xml`
- Link Bootstrap and jQuery in the HTML file

## Step 14 - Validation with Spring Boot

1. Add Spring Boot Starter Validation in `pom.xml`
2. Implement command beans for form backing object
3. Add validation annotations to the bean
4. Display validation errors in the view using JSP

## Step 15 - Add a Delete Todo Feature

## Step 16 - Add an Update Todo Feature

## Step 17 - Add a TargetDate Field in Todo

- Add dependencies for Bootstrap Datepicker in `pom.xml`
- Link Bootstrap Datepicker in the HTML file
- Example configuration for using Bootstrap Datepicker

## Step 18 - Create JSP Fragments for Navigation Bar Header and Footer

- Use `<%@ include file="file_path" %>`

## Step 19 - Implementing Spring Security for userId and Password

- Add Spring Security dependency in `pom.xml`
- Configure InMemoryUserDetailsManager and PasswordEncoder
- Retrieve username from SecurityContextHolder

## Step 20 - Getting Ready with Spring Data JPA

- Add Spring Data JPA and H2 dependencies in `pom.xml`
- Configure DataJpa Repository to access methods in the controller
- Configure Controller to ControllerJpa
- Configure application.properties for DataJpa settings
- Monitor SQL queries with `spring.jpa.show-sql=true`

This guide provides a step-by-step walkthrough of creating a Spring Boot web application, covering essential topics such as MVC controllers, JSP views, form handling, validation, security, and data persistence with Spring Data JPA.
