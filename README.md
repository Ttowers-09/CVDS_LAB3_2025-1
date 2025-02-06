**UNIVERSIDAD ESCUELA COLOMBIANA DE INGENIERÍA JULIO GARAVITO**

**INTEGRANTES**

**Nombres:** Camilo Andres Quintero Rodriguez e Ivan Santiago F. Torres

**Asignacion:** Laboratorio 3 (TDD)

**Asignatura:** Ciclos de Vida del desarrollo (CVDS)

**Docente:** Oscar David Ospina Rodriguez.

**RESPUESTAS:**

1. **Crear un proyecto maven**
    Crear un proyecto Maven con los siguientes parámetros:

    Grupo: edu.eci.cvds 

    Artefacto: Library 

    Paquete: edu.eci.cvds.tdd 

    archetypeArtifactId: maven-archetype-quickstart

    ![alt text](/Resources/image.png)

2. **AGREGAR DEPENDENCIA JUNIT5**
- Buscar en maven central la dependencia de JUnit5 en su versión más reciente.

- Edite el archivo pom.xml del proyecto para agregar la dependencia.

    ![alt text](/Resources/image1.png)

- Verifique que la versión de java sea la 17

    ![alt text](/Resources/image2.png)

- Compile el proyecto para validar que todo este bien

    ![alt text](/Resources/image4.png)



3. **AGREGAR ESQUELETO DEL PROYECTO**

    Cree los siguientes paquetes dentro de edu.eci.cvds.tdd

    library

        - book

        - loan

        - user

    ![alt text](/Resources//image5.png)


4. **AGREGAR CLASES**


    Creamos la clase Book.java en el paquete edu.eci.cvds.tdd.library.book: 

    ![alt text](/Resources/image6.png)

    Creamos la clase User.java en el paquete edu.eci.cvds.tdd.library.user:

    ![alt text](/Resources/image7.png)

    Creamos la clase Loan.java en el paquete edu.eci.cvds.tdd.library.loan:

    ![alt text](/Resources/image8.png)

    Ademas la clase LoanStatus.javae en el mismo paquete:

    ![alt text](/Resources/image9.png)

    Creamos la clase Library.java en el paquete edu.eci.cvds.tdd.library:

    ![alt text](/Resources/image10.png)

    Compilamos el poryecto con el comando mvn package:

    ![alt text](/Resources/image11.png)


5. **PRUEBAS UNITARIAS Y TDD**



