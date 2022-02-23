# Challenge LuizaLabs

## Project Structure (3 Steps)

* Step 1: Spring Boot (Maven) API using JAVA 11 SDK
* Step 2: Front End with Bootstrap v5
* Step 3: DB Scripts to MySql DB

## How to run the local `Backend` in Prod and Dev Environment? 
    *(You need SDK v11 to Java)

1. Clone the repo https://github.com/Dionatas1114/Desafio_LABs using bash command in the terminal:
   ```bash
   git clone https://github.com/Dionatas1114/Desafio_LABs
    ```

2. In your IDE (preferably Intellij), open the project's `Backend` folder and navigate to `application.properties` archive. Into the archive, paste the scripts:
    ```
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.hibernate.show-sql=true
    spring.jpa.generate-ddl=true
    ```

    And (PROD ENVIRONMENT)

        spring.datasource.url=jdbc:mysql://b0b68ad9911508:6bc5a861@us-cdbr-east-04.cleardb.com/heroku_eec9f4eb2c48665?createDatabaseIfNotExist=true
        spring.datasource.username=b0b68ad9911508
        spring.datasource.password=6bc5a861

    OR (DEV)

        spring.datasource.url=jdbc:mysql://localhost:3306/db_magalu?createDatabaseIfNotExist=true
        spring.datasource.username=db_magalu
        spring.datasource.password=strongpassword

3. (OPTIONAL) If you want run in Dev Environment, you must create Mysql Database using docker bash command in the terminal:

    ```bash
    docker run -d -p 3306:3306 --name db_magalu -e MYSQL_ROOT_PASSWORD=strongpassword -e MYSQL_DATABASE=db_magalu -e MYSQL_USER=db_magalu -e MYSQL_PASSWORD=strongpassword mysql
    ```

4. In your IDE: 
    - Download the Maven dependencies, 
    - select the JDK 11, 
    - configure the application with the main class, 
    - build the project and run.

5. (OPTIONAL) If you prefer to test on POSTMAN, the collection is in the project root named as `LuizaLabs-Challenge.postman_collection`.

## How to run the local `Frontend`?

In your IDE (preferably VSCode), open the project's `Frontend` folder and enter these commands in the bash terminal: 
* (Caution!) Wait for the dependencies to finish downloading to run

```bash
$ npm install
$ npm run start
```

The project will open automatically in some browser with the url: `http://localhost:3000/` and You can open it in your preferred browser (Chrome, Mozilla, Opera or other).

* No configuration like `env vars` or disable the firewall is required.

On the Login Page, enter this data:

    name: magalu
    password: m@galu123  

See this screenshots:

* Login Page: (Login with wrong user data)
  
![picture alt](./prints/teste.jpg "Login Page")

* Home Page: (Login with correct user data)
  
![picture alt](./prints/home.jpg "Login Page")

## How to run the local `DB Scripts`?

To Run the Scripts, You need a *SQL client software* or a *database administration tool* how `DBeaver` or `Mysql Workbench`

    HOST: mysql://b0b68ad9911508:6bc5a861@us-cdbr-east-04.cleardb.com/heroku_eec9f4eb2c48665
    DB_NAME(Optional): db_magalu
    USERNAME: b0b68ad9911508
    PASSW: 6bc5a861

After connecting the DB, You need open a Sql Script page, paste the scripts into page and run each script.
