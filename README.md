# Kaprekar
Este proyecto implementa la constante de Kaprekar y sus algoritmos relacionados en Java.

## Descripción
Este proyecto implementa la constante de Kaprekar y sus algoritmos relacionados en Java. La constante de Kaprekar es un número curioso descubierto por el matemático D. R. Kaprekar: si tomas cualquier número de 4 dígitos cuyos dígitos no sean todos iguales, lo ordenas de mayor a menor, luego de menor a mayor, y restas el menor del mayor, al repetir este proceso eventualmente llegarás al número 6174, conocido como la constante de Kaprekar.

## Características principales
- Verificación de números de Kaprekar
- Cálculo de rutas de Kaprekar (pasos hasta llegar a 6174)
- Implementación para diferentes bases numéricas
- Visualización gráfica del proceso
- API para integración con otros sistemas

## Tecnologías utilizadas
- Java 17+
- Maven/Gradle para gestión de dependencias
- JUnit para pruebas unitarias
- JavaFX para interfaz gráfica (opcional)

## Requisitos del sistema
- JDK 17 o superior
- Maven 3.8+ o Gradle 7.0+ (según el sistema de construcción elegido)



## Uso básico
```java
import com.tudominio.kaprekar.KaprekarCalculator;

public class Main {
    public static void main(String[] args) {
        KaprekarCalculator calculator = new KaprekarCalculator();
        
        // Calcular la ruta de Kaprekar para el número 3524
        List<Integer> route = calculator.calculateKaprekarRoute(3524);
        
        // Imprimir la ruta
        System.out.println("Ruta Kaprekar para 3524:");
        route.forEach(System.out::println);
        
        // Verificar si un número es un número de Kaprekar
        boolean isKaprekarNumber = calculator.isKaprekarNumber(9);
        System.out.println("¿Es 9 un número de Kaprekar? " + isKaprekarNumber);
    }
}
```

## Documentación
La documentación completa se encuentra en el directorio `docs/`. También puedes generar la documentación JavaDoc ejecutando:
```bash
mvn javadoc:javadoc
# o con Gradle
gradle javadoc
```

## Contribuir
1. Haz fork del proyecto
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -am 'Agrega nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crea un nuevo Pull Request

## Licencia
Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Autor
alejandra - [a24alejandravc@iessanclemente.net]