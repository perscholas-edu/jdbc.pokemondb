# JDBC Pokemon Database


### Description
* **Objective** - To implement a console interface capable of prompting a user to populate a respective table in a respective database.
* **Purpose** - To establish familiarity with
    * Java Database Connections
    * Error handling & Debugging
    * `.xml` configuration
* **Details**
    * You are provided with a set of [JDBC](https://www.baeldung.com/java-jdbc) utility classes located in the package `utils.jdbc`.
    * Most of the project's design and implementation has been considered for you.
    * **Milestone 1** - configure this project to connect to `mariadb` rather than `mysql`
    * **Milestone 2** - create an console (or graphical) interface to `add`, `remove`, `update`, and `get` a respective entity from a respective table from a respective database.   
    

    

### Configuring Environment
* Ensure you have `MySQL` installed.
    * This project's current `MySQL` version can be found by viewing its `pom.xml`
    * Your machine's current `MySQL` version can be found by executing `SELECT VERSION()`
* Using a [persistent unit](./README-JPANotes.md#what-is-a-persistence-unit), one can configure the project to make use of different database configurations and dialects.
    * This project's persistent unit can be found in the `src/main/resources/META-INF/` directory.
* View each of the `README*.md` files to ascertain more details about this project's configuration.
    * [README-Project Utilities](./README-ProjectUtilities)
    * [README-JDBC Notes](./README-JDBCNotes.md)
    * [README-JPA Notes](./README-JPANotes.md)
    

### Getting Started
* Begin by _forking_ this project into a personal repository.
   * To do this, click the `Fork` button located at the top right of this page.
* Navigate to your github profile to find the _newly forked repository_.
* Clone the repository from **your account** into the `~/dev` directory.
* Open the newly cloned project in a code editor (Visual Studio Code, for example).
