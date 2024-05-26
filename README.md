# Proyecto-Juego

El proyecto toma el juego base de lluvia, en el cual el objetivo es recoger la mayor cantidad de gotas de lluvia buenas para obtener un mayor puntaje, y busca realizarle modificaciones aplicando encapsulamiento

## Requisitos previos

Asegúrate de tener los siguientes programas y herramientas instalados en tu sistema:

- Java Development Kit (JDK) 17
- Eclipse IDE
- Gradle

## Instrucciones de instalación

Sigue estos pasos para configurar el proyecto en tu entorno local.

### 1. Clonar el repositorio

Clona el repositorio del proyecto desde GitHub a tu máquina local:

```sh
git clone https://github.com/CarlosAbarza/Proyecto-Juego.git
```

### 2. Importar el proyecto en Eclipse

1. Abre Eclipse.
2. Selecciona File > Import....
3. En la ventana de importación, selecciona Gradle > Existing Gradle Project y haz clic en Next.
4. Navega hasta el directorio donde clonaste el repositorio y selecciona la carpeta raíz del proyecto.
5. Haz clic en Finish para importar el proyecto.

### 3. Configurar las dependencias de libGDX

Si el proyecto no configura automáticamente las dependencias de libGDX, puedes hacerlo manualmente:

1. Abre el archivo build.gradle ubicado en la raíz del proyecto.

2. Asegúrate de que las dependencias de libGDX estén listadas en la sección dependencies.

3. Sincroniza el proyecto con Gradle. Puedes hacerlo haciendo clic derecho en el proyecto en el Explorador de Proyectos y seleccionando Gradle > Refresh Gradle Project.

## Ejecutar el pryecto
1. En el Explorador de Proyectos, expande el proyecto hasta encontrar la clase principal del módulo desktop.

2. Haz clic derecho en la clase principal, llamada "DesktopLauncher.java", y selecciona Run As > Java Application.

## Listo, disfruta el juego
