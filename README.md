# Semana18_GuiaTrabajo_ProgramacionIII_UPED

### README semana 18

```md
# Semana 18 - Programación III

Ejemplos de estados de hilos, condiciones de carrera, sincronización, comunicación entre hilos y servidores web concurrentes.

## Estructura

- `estados/`
  - Estados del ciclo de vida de un hilo:
    `NEW`, `RUNNABLE`, `TIMED_WAITING` y `TERMINATED`.

- `carrera/`
  - Contador inseguro.
  - Contador sincronizado.
  - Contador usando `AtomicInteger`.

- `comunicacion/`
  - Comunicación entre productor y consumidor.
  - Uso de `BlockingQueue`.

- `web/`
  - Cuenta compartida.
  - Cuenta sincronizada.
  - Servidor de visitas concurrente.
  - Repositorio de socios y excepciones.

- `ejercicios/`
  - Taquilla insegura.
  - Taquilla protegida con `synchronized`.

## Compilación

Entrar a la carpeta del ejemplo y ejecutar:

```bash
javac *.java
java NombreDeLaClase
