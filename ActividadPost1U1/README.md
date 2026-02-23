# ActividadPost1U1

## Descripción del Proyecto

Este proyecto es un sistema simple para evaluar solicitudes de préstamos bancarios. Está hecho en Java y usa Maven para manejar las dependencias y la compilación. Incluye pruebas con JUnit 5 para asegurar que todo funcione bien. El sistema decide si aprobar, rechazar o revisar manualmente un préstamo basado en reglas como la edad, el puntaje crediticio, deudas y otros factores.

## Instrucciones de Uso

### Compilar el Proyecto
Para compilar el proyecto, usa Maven. Abre una terminal en la carpeta del proyecto y ejecuta:
```
mvn compile
```
Esto creará los archivos compilados en la carpeta `target`.

### Ejecutar las Pruebas
Para correr las pruebas unitarias, usa este comando:
```
mvn test
```
Las pruebas verificarán que el código funcione correctamente.

### Activar Assertions (si es necesario)
Si necesitas activar las assertions en Java (que se usan para verificar condiciones en el código), ejecuta el programa con la opción `-ea`. Por ejemplo:
```
java -ea -cp target/classes com.mycompany.actividadpost1u1.Main
```
Esto es útil para depurar y asegurar que las reglas del código se cumplan.

## Decisiones de Diseño

En este proyecto, tomamos algunas decisiones para hacer el código más seguro y fácil de entender:

- **Invariantes en la clase Solicitante**: Usamos reglas que siempre deben ser ciertas para los datos de un solicitante, como que la edad sea positiva o el ingreso mayor a cero. Esto evita errores desde el principio.

- **Precondiciones con IllegalArgumentException**: Antes de procesar algo, verificamos que los datos de entrada sean válidos. Si no lo son, lanzamos una excepción para detener el programa y mostrar el error.

- **Uso de assert para postcondiciones**: Después de ejecutar una función, usamos `assert` para confirmar que el resultado es correcto. Esto ayuda a detectar problemas durante el desarrollo.

- **Tabla de decisión para la lógica**: Implementamos la lógica de evaluación usando una tabla de decisión. Esto hace que sea fácil ver todas las combinaciones posibles de condiciones y sus resultados, como si fuera una tabla de verdad.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven:

- `src/main/java`: Aquí están las clases principales del programa, como `Solicitante`, `EvaluadorPrestamo`, `ResultadoPrestamo` y `Main`.
- `src/test/java`: Aquí están las pruebas unitarias, como `TestEvaluadorPrestamos`, que usan JUnit para probar el código.

## Tabla de Decisión

Esta tabla muestra cómo se decide si un préstamo es aprobado, rechazado o necesita revisión manual. Las condiciones son reglas que se evalúan, y el resultado depende de cuáles se cumplan.

| Condiciones             | R1 | R2 | R3 | R4 | R5 | R6 | R7 | R8 |
|------------------------|----|----|----|----|----|----|----|----|
| Edad >= 18             | V  | V  | V  | V  | V  | F  | -  | V  |
| Puntaje >= 700         | V  | V  | F  | F  | F  | -  | -  | V  |
| Sin deudas             | V  | F  | -  | -  | -  | -  | -  | V  |
| Puntaje >= 500         | -  | -  | V  | V  | F  | -  | F  | -  |
| Empleo >= 2 años       | -  | -  | V  | F  | -  | -  | -  | V  |
| Monto <= 5x ingreso    | V  | V  | V  | V  | V  | -  | -  | F  |
| Resultado              | Aprobado | Revisión | Revisión | Rechazado | Rechazado | Rechazado | Rechazado | Rechazado |

- **V**: Verdadero (se cumple la condición)
- **F**: Falso (no se cumple)
- **-**: No importa (no afecta el resultado)
- **Resultado**: Aprobado, Revisión (revisión manual) o Rechazado