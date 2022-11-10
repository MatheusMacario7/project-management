## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Code Smells 

Code Smells encontrados:

- `Large Class`

    - [App](https://github.com/MatheusMacario7/project-management/blob/Project-management---POO/src/App.java)

- `Duplicated Code`

    - [User](https://github.com/MatheusMacario7/project-management/blob/Project-management---POO/src/User.java)
    ```Java
        public User(String name, String email, String password, String scholarshipValue) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.scholarshipValue = scholarshipValue;
    
    }

    public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.scholarshipValue = "R$0,00";
    
    }
    ```
    -[Project](https://github.com/MatheusMacario7/project-management/blob/Project-management---POO/src/Project.java)
    ```Java
    public  Project(String projecName, String description, String startDate, String startHour, String endDate, String endHour, String projectCoordenador, String status) { 
        this.projectName = projecName;
        this.description = description;
        this.startDate = startDate;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endHour = endHour;
        this.projectCoordenador = projectCoordenador;
        this.status = status;
        this.valueScholarship = "0,00";
        this.periodScholarship = "0";
    }

    public Project(String projecName, String description, String startDate, String startHour, String endDate, String endHour, String projectCoordenador, String status, String valueScholarship, String periodScholarship) {
        this.projectName = projecName;
        this.description = description;
        this.startDate = startDate;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endHour = endHour;
        this.projectCoordenador = projectCoordenador;
        this.status = status;
        this.valueScholarship = valueScholarship;
        this.periodScholarship = periodScholarship;

    }
    ```
