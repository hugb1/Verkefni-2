# SpringBootMVC
Project skeleton for Software Project class in the University of Iceland.

## How do I get this ?
Your IDE ([IntelliJ](https://www.jetbrains.com/idea/), [Eclipse](https://eclipse.org/), [Spring Tool Suit](https://spring.io/tools)) should be able to clone a project from Github.
It should be easy to find information regarding how to do that for your chosen IDE.
It's also possible to download the project as a .zip [here](https://github.com/mbook/SpringBootMVC/archive/master.zip).

## How do I run this ?
This project is setup using [Maven](https://maven.apache.org/what-is-maven.html) as a dependency manager, so if your IDE does not manage that, or you don't have it installed you can look [here](https://maven.apache.org/install.html) for further information.
When all the dependencies are downloaded, you can run the project by running the ``main()`` method in the class ``Application`` and then enter [localhost:8080](http://localhost:8080) into the address bar of your favorite web browser.

## What is going on ?
Look at the code and find the comments I wrote. I tried explaining what was happening in such a way that it should hopefully be easy to understand.

### What did you use to make this ?
I used IntelliJ Ultimate with Maven to setup this project. Students and Teachers get the Ultimate edition for free, apply [here](https://www.jetbrains.com/student/).

### Database
This project assumes there is a database called HBV at the URL: postgresql://localhost:5432/HBV .   
See username and password in [application.properties](https://github.com/danielpall/SpringBootMVC/blob/master/src/main/resources/application.properties)

### Where can I find help ?
In case of any questions, please refer to the "Spring Boot Intro" slides in the HBV501G Verkefni folder on Ugla, or contact your tutor.

### Credits
This skeleton project was originally created by Daníel Páll Jóhannsson while tutoring the HBV501G course in Fall 2015. Daníel has since moved on to work at TM Software. Therefore, please direct any questions to *your own* tutors - thanks :-)
