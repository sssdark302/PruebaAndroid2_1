# Documentación de la Aplicación de Horarios

---
Hecho por: Augusto Perrone
Link al repo: https://github.com/sssdark302/Prueba2_2.git

## Descripción General
Esta aplicación está diseñada para ayudar a los usuarios a gestionar su horario académico de manera sencilla y eficiente. La aplicación ofrece las siguientes funcionalidades principales:

1. **Agregar Clases**: Los usuarios pueden añadir clases indicando el nombre de la asignatura, el día de la semana y la hora.
2. **Ver Horario por Día**: Permite consultar las clases programadas para un día específico.
3. **Consultar Qué Clase Está en Curso** *(pendiente de resolución)*: Esta funcionalidad debería mostrar la clase que se está impartiendo en el momento actual según la fecha y hora del dispositivo.

---

## Funcionalidades

### **1. Agregar Clases**
- Los usuarios pueden agregar clases desde la pantalla de "Agregar Clase".
- Deben introducir:
    - El nombre de la asignatura.
    - El día de la semana (ejemplo: Lunes, Martes, etc.).
    - La hora exacta en formato de 24 horas.
- Una vez agregada, la clase debería aparecer en el horario correspondiente.

### **2. Ver Horario por Día**
- Los usuarios pueden seleccionar un día de la semana desde un menú desplegable.
- La aplicación mostrará una lista de las clases programadas para ese día.
- **Nota Importante**: En algunos casos, es necesario agregar al menos dos clases antes de que el horario del día seleccionado se muestre correctamente. Este es un comportamiento conocido que aún está pendiente de resolución.

### **3. Consultar Qué Clase Está en Curso** *(No Funcional)*
- Esta funcionalidad debería identificar la clase que coincide con el día y la hora actuales.
- **Problema Actual**: La lógica para identificar la clase en curso no está funcionando correctamente, por lo que esta funcionalidad no está disponible en la versión actual.
---

