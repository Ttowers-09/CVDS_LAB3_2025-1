**UNIVERSIDAD ESCUELA COLOMBIANA DE INGENIERÍA JULIO GARAVITO**

**INTEGRANTES**

**Nombres:** Camilo Andres Quintero Rodriguez e Ivan Santiago F. Torres

**Asignacion:** Laboratorio 3 (TDD)

**Asignatura:** Ciclos de Vida del desarrollo (CVDS)

**Docente:** Oscar David Ospina Rodriguez.

**RESPUESTAS:**

1. **CREAR UN PROYECTO CON MAVEN**
    - Crear un proyecto Maven con los siguientes parámetros:

        ![alt text](/Resources/image12.png)

        ![alt text](/Resources/image.png)

2. **AGREGAR DEPENDENCIA JUNIT 5**
    - Buscar en maven central la dependencia de JUnit5 en su versión más reciente.

    - Edite el archivo pom.xml del proyecto para agregar la dependencia.

    ![alt text](/Resources/image1.png)

    - Verifique que la versión de java sea la 17.

    ![alt text](/Resources/image2.png)

    - Compile el proyecto para validar que todo este bien.

    ![alt text](/Resources/image4.png)



3. **AGREGAR ESQUELETO DEL PROYECTO**
    - Cree los siguientes paquetes dentro de edu.eci.cvds.tdd

        library

            - book

            - loan

            - user

    ![alt text](/Resources/image5.png)


4. **AGREGAR CLASES**
    - Creamos la clase Book.java en el paquete edu.eci.cvds.tdd.library.book:

        ![alt text](/Resources/image14.png)

        Verificamos la creación:

       ![alt text](/Resources/image6.png)

    - Creamos la clase User.java en el paquete edu.eci.cvds.tdd.library.user:

        ![alt text](/Resources/image16.png)

        Verificamos la creació:

      ![alt text](/Resources/image7.png)

    - Creamos la clase Loan.java en el paquete edu.eci.cvds.tdd.library.loan:

        ![alt text](/Resources/image15.png)

        Verificamos la creación:

        ![alt text](/Resources/image8.png)

        Ademas la clase LoanStatus.javae en el mismo paquete:

        ![alt text](/Resources/image9.png)

    - Creamos la clase Library.java en el paquete edu.eci.cvds.tdd.library:

        ![alt text](/Resources/image20.png)
        ![alt text](/Resources/image17.png)

        Verificamos la creación:

        ![alt text](/Resources/image10.png)

   -  Compilamos el poryecto con el comando mvn package:

        ![alt text](/Resources/image11.png)


5. **PRUEBAS UNITARIAS Y TDD**
    -  vamos a aplicar la técnica de TDD, por cada caso de prueba se debe hacer un commit, cada commit debe tener la prueba nueva y la implementación para que la prueba del commit funcione.

6. **CREAR CLASE DE PRUEBA**
    - Crear la clase de prueba para edu.eci.cvds.tdd.Library, la clase debe seguir los estándares de nombres estudiados en clase.

    (FOTO)

7. **COBERTUTA**
    - Agregar la dependencia de jacoco, utilizar la última versión disponible en maven central.

    - Para usar Jacoco es necesario agregar la siguiente sección en el pom.xml:
    ![alt text](/Resources/image13.png)

    - Compilar el proyecto en la carpeta target se debe crear una carpeta con el nombre site la cual tiene un index.html

    (FOTO)

    - Al abrir dicho archivo se debe ver la cobertura total y de cada una de las clases, el objetivo es tener la cobertura superior al 80%.

    (FOTO)
    
7. **SONARCUBE**
    - Necesitamos tener Docker.
        - Descargar la imagen de docker con el siguiente comando:
        
             docker pull sonarqube.

        - Arrancar el servicio de SonarQube con el siguiente comando:

                docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
        
        - Validar funcionamiento: 
        
            docker ps -a
        
        - Iniciar sesión en sonar localhost:9000 cambiar la clave por defecto usuario y contraseña es admin.

        - Entrar a las opciones de la cuenta.
        
            Account -> settings -> generate token.

        - Una vez sonar este corriendo deben generar un token.

        - Instale sonarLint en el IDE que este manejando.

        - Añada el plugin de Sonar en el archivo pom del proyecto.

            ![alt text](/Resources/image18.png)
        
        - Añada las propiedades de SonarQube y Jacoco. 

            ![alt text](/Resources/image19.png)
        
        - Construya el proyecto, genere el reporte de JACOCO y corrija el cubrimiento de las pruebas de unidad para que su proyecto se construya adecuadamente.

        - genere la integración con sonar mvn verify sonar:sonar -D sonar.token=[TOKEN_GENERADO].




